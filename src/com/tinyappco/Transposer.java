package com.tinyappco;

import com.tinyappco.temperaments.EqualTemperament;
import com.tinyappco.temperaments.Temperament;

public class Transposer
{
    private final Temperament temperament;

    public Transposer(Temperament temperament){
        this.temperament = temperament;
    }

    public Transposer(){
        this.temperament = new EqualTemperament();
    }


    public double transpose(double frequency, int semitones)
    {
        int octave = semitones / 12;
        int semitoneInterval = semitones % 12;

        //if negative, drop an octave and raise semitones by same amount
        if (semitoneInterval < 0){
            octave--;
            semitoneInterval += 12;
        }

        frequency = transposeByOctaves(frequency,octave);
        final Interval interval = Interval.fromSemitones(semitoneInterval);
        return transposeUpByInterval(frequency, interval);
    }

    final double transposeByOctaves(double frequency, int octave)
    {

        for (int i = 0; i < octave; i++)
        {
            frequency *= 2;
        }
        for (int i = 0; i > octave; i--)
        {
            frequency /= 2;
        }
        return frequency;
    }

    public double transposeDownByInterval(double frequency, Interval interval){
        return 1.0 / transposeUpByInterval(frequency,interval);
    }

    public double transposeUpByInterval(double frequency, Interval interval)
    {
        return temperament.transpositionFactorForInterval(interval) * frequency;
    }

}
