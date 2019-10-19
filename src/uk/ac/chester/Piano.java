package uk.ac.chester;

public class Piano implements Synthesizer {
    @Override
    public byte sample(float sampleRate, byte volume, int sample, double frequency) {
        double angle = sample / (sampleRate / frequency) * 2.0 * Math.PI;
        return (byte) (volume * ((-Math.sin(3 * Math.PI * angle)*0.25) + (Math.sin(Math.PI * angle) * 0.25) + ((Math.sqrt(3)/2.0) * Math.cos(Math.PI * angle))));
    }
}
