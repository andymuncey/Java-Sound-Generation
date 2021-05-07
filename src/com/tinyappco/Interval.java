package com.tinyappco;

public enum Interval
{
    NONE(0),
    MINOR_SECOND(1),
    MAJOR_SECOND(2),
    MINOR_THIRD(3),
    MAJOR_THIRD(4),
    PERFECT_FOURTH(5),
    TRITONE(6),
    PERFECT_FIFTH(7),
    MINOR_SIXTH(8),
    MAJOR_SIXTH(9),
    MINOR_SEVENTH(10),
    MAJOR_SEVENTH(11),
    OCTAVE(12);

    private final int semitones;
    private Interval(int semitones){
        this.semitones = semitones;
    }

    public int getSemitones()
    {
        return semitones;
    }

    public static Interval fromSemitones(int semitones){
        switch (semitones) {
            case 0:
                return NONE;
            case 1:
            return MINOR_SECOND;
            case 2:
                return MAJOR_SECOND;
            case 3:
                return MINOR_THIRD;
            case 4:
                return MAJOR_THIRD;
            case 5:
                return PERFECT_FOURTH;
            case 6:
               return TRITONE;
            case 7:
               return PERFECT_FIFTH;
            case 8:
             return MINOR_SIXTH;
            case 9:
             return MAJOR_SIXTH;
            case 10:
              return MINOR_SEVENTH;
            case 11:
               return MAJOR_SEVENTH;
            case 12:
                return OCTAVE;
        }

        return null;
    }

}
