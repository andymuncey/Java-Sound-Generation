package com.tinyappco.temperaments;

import com.tinyappco.Interval;

public class EqualTemperament implements Temperament
{

    @Override
    public double transpositionFactorForInterval(Interval interval)
    {
        return Math.pow(Math.pow(2, 1.0/12.0), interval.getSemitones());
    }

}
