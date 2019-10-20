package com.tinyappco;

class AudibleNote {

    private double frequency;
    double getFrequency() {
        return frequency;
    }

    private double c0 = 16.35160; //the lowest note we will accept

    AudibleNote(double frequency){
        this.frequency = frequency;
    }

    AudibleNote(Note.Name name, int octave, Note.Accidental accidental){
        this(new Note(name, accidental),octave);
    }

    AudibleNote(Note note, int octave){

        note.convertToSharpRepresentation();
        Note.Name name = note.getName();
        Note.Accidental accidental = note.getAccidental();

        assert(octave >= -1 && octave <= 9);

        //find frequency of C for the Octave
        frequency = c0 * Math.pow(2,octave);

        //work out how many semitones to go up by, based on the name and accidental of the note and their positions
        int semitonesUp = 0;
        for (int i = 0; i < Scales.C_CHROMATIC.length; i++) {
            Note scaleNote = Scales.C_CHROMATIC[i];
            if (name.equals(scaleNote.getName()) && accidental.equals(scaleNote.getAccidental())){
                break;
            }
            semitonesUp++;
        }
        while (semitonesUp > 0){
            frequency = semitoneUp(frequency);
            semitonesUp--;
        }

    }

    static AudibleNote fromString(String desc){
        try {
            Note.Accidental accidental = Note.Accidental.NATURAL;
            String noteName = desc.toUpperCase().substring(0, 1);
            Note.Name name = Note.Name.valueOf(noteName);

            if (desc.length() == 3) {
                char accidentalChar = desc.charAt(1);
                switch (accidentalChar) {
                    case '#':
                    case '♯':
                        accidental = Note.Accidental.SHARP;
                        break;
                    case 'b':
                    case '♭':
                        accidental = Note.Accidental.FLAT;
                        break;
                }
            }
            int octave = Integer.parseInt(desc.toUpperCase().substring(desc.length() - 1, desc.length()));

            return new AudibleNote(name, octave, accidental);

        }
        catch (Exception e){
            throw new RuntimeException("Notes must be represented in the form 'A4' or 'B♭4', supplied value was " + desc);
        }
    }

    String getFullName(){

        int offset = 0;
        double currentNoteFrequency = c0;
        double upper = currentNoteFrequency * 1.02;
//calculate name - start at c0 and increment by semitones, check no more than 2% out (difference between notes is ~5.9463%)
        while (frequency > upper){
            offset++;
            currentNoteFrequency = semitoneUp(currentNoteFrequency);
            upper = currentNoteFrequency * 1.02;
        }
        int octave = offset / 12;
        int interval = offset % 12;

        Note note = Scales.C_CHROMATIC[interval];

        return String.format("%s%s%d", note.getName(), note.getAccidental(), octave);
    }

    private static double semitoneUp(double freq) {
        return freq * Math.pow(Math.E, Math.log(2)/12) ;
    }

}
