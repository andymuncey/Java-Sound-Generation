package com.tinyappco.temperaments;

import com.tinyappco.Interval;

public interface Temperament
{
    double transpositionFactorForInterval(Interval interval);
}
