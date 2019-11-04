package com.tinyappco;

/**
 * Represents a Note with an octave and accidental
 * Known limitation: Only handles octaves 0-9 inclusive
 */
public class Note {

    public enum Name{
        C,D,E,F,G,A,B
    }

    public enum Accidental{
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
    private int octave = 4;


    /**
     * Creates a note given a name and accidental, between C0 and B0
     * @param name the name of the note, e.g. 'A'
     * @param accidental
     */
    public Note(Name name, Accidental accidental) {
        this(name,accidental,4);
    }

    /**
     * Creates a note
     * @param name A Note.Name
     * @param accidental A Note.Accidental
     * @param octave a value between 0 and 9
     */
    public Note(Name name, Accidental accidental, int octave) {
        this.name = name;
        this.accidental = (accidental == null) ?  Accidental.NATURAL : accidental;
        this.octave = octave;
        assert(octave >= -1): "Octave must be 0 or higher";
        assert(octave <= 9) : "Octave must be less than or equal to 9";
    }

    public Note(String name){

        assert(name.length() > 0) : "Note name cannot be empty";

        char noteLetter = name.toUpperCase().charAt(0);

        assert (noteLetter >= 'A') : "Note must start with character between A and G";
        assert (noteLetter <= 'G') : "Note must start with character between A and G";

        this.name = Name.valueOf(String.valueOf(noteLetter));
        if (name.length() > 1) {

            //sort accidentals
            if (name.contains("♯") || name.contains("#")){
                accidental = Accidental.SHARP;
            } else if (name.contains("♭") || name.contains("b")){
                accidental = Accidental.FLAT;
            } else {
                accidental = Accidental.NATURAL;
            }

            //sort octave
            if (Character.isDigit(name.charAt(name.length()-1))){
                int newOctave = Integer.parseInt(String.valueOf(name.charAt(name.length()-1)));
                octave = newOctave;
            }
        }
    }

    public Name getName() {
        return name;
    }

    public Accidental getAccidental() {
        return accidental;
    }

    public int getOctave() {
        return octave;
    }

    public void convertToSharpRepresentation() {
        if (accidental.equals(Accidental.FLAT)){
            switch (name){
                case C:
                    name = Name.B;
                    accidental = Accidental.NATURAL;
                    break;
                case D:
                    name = Name.C;
                    accidental = Accidental.SHARP;
                    break;
                case E:
                    name = Name.D;
                    accidental = Accidental.SHARP;
                    break;
                case F:
                    name = Name.E;
                    accidental = Accidental.NATURAL;
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
            }
        }
    }

    public void convertToFlatRepresentation() {
        if (accidental.equals(Accidental.SHARP)){
            switch (name){
                case C:
                    name = Name.D;
                    accidental = Accidental.FLAT;
                    break;
                case D:
                    name = Name.E;
                    accidental = Accidental.FLAT;
                    break;
                case E:
                    name = Name.F;
                    accidental = Accidental.NATURAL;
                    break;
                case F:
                    name = Name.G;
                    accidental = Accidental.FLAT;
                    break;
                case G:
                    name = Name.A;
                    accidental = Accidental.FLAT;
                    break;
                case A:
                    name = Name.B;
                    accidental = Accidental.FLAT;
                    break;
                case B:
                    name = Name.C;
                    accidental = Accidental.NATURAL;
                    break;
            }
        }
    }

}
