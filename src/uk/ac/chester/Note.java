package uk.ac.chester;

public class Note {

    enum Name{
        C,D,E,F,G,A,B
    }

    enum Accidental{
        SHARP{
            @Override
            public String toString() {
                return "♯";
            }
        }, FLAT{
            @Override
            public String toString() {
                return "♭";
            }
        }, NATURAL{
            @Override
            public String toString() {
                return "";
            }
        }
    }

    private Name name;
    private Accidental accidental;
    private int octave;

    public double getFrequency() {
        return frequency;
    }

    private double frequency;

    private Name[] names = {Name.C,Name.C,Name.D,Name.D,Name.E,Name.F,Name.F,Name.G,Name.G,Name.A,Name.A,Name.B};
    private Accidental[] accidentals = {Accidental.NATURAL,Accidental.SHARP,Accidental.NATURAL,Accidental.SHARP,Accidental.NATURAL,Accidental.NATURAL,Accidental.SHARP,Accidental.NATURAL,Accidental.SHARP,Accidental.NATURAL,Accidental.SHARP,Accidental.NATURAL};

    private double c0 = 16.35160;

    public Note(double frequency){
        assert(frequency > 16 && frequency < 8060);
        //calculate name - start at c0 and increment by semitones, check no more than 2% out (difference between notes is ~5.9463%)
        int offset = 0;
        double currentNoteFrequency = c0;
        double upper = currentNoteFrequency * 1.02;

        while (frequency > upper){
            offset++;
            currentNoteFrequency = semitoneUp(currentNoteFrequency);
            upper = currentNoteFrequency * 1.02;
        }
        octave = offset / 12;
        int interval = offset % 12;
                name = names[interval];
        accidental = accidentals[interval];
    }

    public Note(Name name, int octave, Accidental accidental){

        if (accidental == null){
            accidental = Accidental.NATURAL;
        }


        if (accidental.equals(Accidental.FLAT)){
            switch (name){
                case D:
                    name = Name.C;
                    accidental = Accidental.SHARP;
                    break;
                case G:
                    name = Name.F;
                    accidental = Accidental.SHARP;
                    break;
                case A:
                    name = Name.G;
                    accidental = Accidental.SHARP;
                    break;
                case B:
                    name = Name.A;
                    accidental = Accidental.SHARP;
                    break;
                case E:
                    name = Name.D;
                    accidental = Accidental.SHARP;
                    break;
                case C:
                    name = Name.B;
                    accidental = Accidental.NATURAL;
                    break;
                case F:
                    name = Name.E;
                    accidental = Accidental.NATURAL;
                    break;
            }
        }

        //todo: convert white note sharps

        assert(octave >= -1 && octave <= 9);
        frequency = c0 * Math.pow(2,octave);
        int semitonesUp = 0;
        for (int i = 0; i < names.length; i++) {
            if (name.equals(names[i]) && accidental.equals(accidentals[i])){
                break;
            }
            semitonesUp++;
        }
        while (semitonesUp > 0){
            frequency = semitoneUp(frequency);
            semitonesUp--;
        }

    }

    public String getName(){
        return String.format("%s%s%d", name, accidental, octave);
    }

    static double semitoneUp(double freq) {
        return freq * Math.pow(Math.E, Math.log(2)/12) ;
    }
}
