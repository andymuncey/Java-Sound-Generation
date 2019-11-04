package com.tinyappco.synths;

public class DecayingSineWave implements Synthesizer {
    @Override
    public short sample(float sampleRate, short volume, int sample, double frequency) {
        final double wavelength = sampleRate / frequency; //length of wave in terms of number of samples
        final double rotation = (sample / wavelength) % 1; //rotation between 0 and 1 (%1 removes number of complete rotations)
        final double angle = rotation * 2.0 * Math.PI; //angle in radians
        final double amplitude = Math.sin(angle); //amplitude of wave at that point
        final double decay = 1 - ((double)sample/sampleRate);
        return (short) (amplitude * volume * decay);
    }
}


