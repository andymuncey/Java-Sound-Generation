package com.tinyappco.synths;

import com.tinyappco.Synthesizer;

public class SineWave implements Synthesizer {
    @Override
    public short sample(float sampleRate, short volume, int sample, double frequency) {
        double wavelength = sampleRate / frequency; //length of wave in terms of number of samples
        double rotation = (sample / wavelength) % 1; //rotation between 0 and 1 (%1 removes number of complete rotations)
        double angle = rotation * 2.0 * Math.PI; //angle in radians
        double amplitude = Math.sin(angle); //amplitude of wave at that point
        return (short) (amplitude * volume);
    }
}


