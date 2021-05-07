package com.tinyappco.temperaments;

import com.tinyappco.Interval;

public class JustIntonation implements Temperament
{


//    @Override
//    public double transpose(double frequency, int semitones)
//    {
//        int octave = semitones / 12;
//        int semitoneInterval = semitones % 12;
//
//        //if negative, drop an octave and raise semitones by same amount
//        if (semitoneInterval < 0){
//            octave--;
//            semitoneInterval += 12;
//        }
//
//        frequency = transposeByOctaves(frequency,octave);
//        final Interval interval = Interval.fromSemitones(semitoneInterval);
//        return transposeByInterval(frequency, interval);
//    }


    public double transpositionFactorForInterval(Interval interval)
    {
        if (interval != null)
        {
            switch (interval)
            {
                case NONE:
                    return 1;
                case MINOR_SECOND:
                    return (16.0 / 15.0);
                case MAJOR_SECOND:
                    return (9.0 / 8.0);
                case MINOR_THIRD:
                    return (6.0 / 5.0);
                case MAJOR_THIRD:
                    return (5.0 / 4.0);
                case PERFECT_FOURTH:
                    return (4.0 / 3.0);
                case TRITONE:
                    return (7.0 / 5.0);
                case PERFECT_FIFTH:
                    return (3.0 / 2.0);
                case MINOR_SIXTH:
                    return (5.0 / 3.0);
                case MAJOR_SIXTH:
                    return (8.0 / 5.0);
                case MINOR_SEVENTH:
                    return (9.0 / 5.0);
                case MAJOR_SEVENTH:
                    return (15.0 / 8.0);
            }
        }
        return 0.0; //should not happen if all enum cases are handled
    }

}
