package com.tinyappco.synths;

import com.tinyappco.Synthesizer;

public class Piano implements Synthesizer {
    @Override
    public short sample(float sampleRate, short volume, int sample, double frequency) {
        double angle = sample / (sampleRate / frequency) * 2.0 * Math.PI;
        return (short) (volume * ((-Math.sin(3 * Math.PI * angle)*0.25) + (Math.sin(Math.PI * angle) * 0.25) + ((Math.sqrt(3)/2.0) * Math.cos(Math.PI * angle))));
    }
}
