package uk.ac.chester;

class Note {

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




    public Note(Name name){
        this(name, Accidental.NATURAL);
    }

    public Note(Name name, Accidental accidental) {
        this.name = name;
        this.accidental = (accidental == null) ?  Accidental.NATURAL : accidental;
    }

    public Name getName() {
        return name;
    }

    public Accidental getAccidental() {
        return accidental;
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
