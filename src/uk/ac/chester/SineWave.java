package uk.ac.chester;

public class SineWave implements Synthesizer {
    @Override
    public byte tone(float sampleRate, int volume, int sample, double frequency) {
        double angle = sample / (sampleRate / frequency) * 2.0 * Math.PI;
        return (byte) (Math.sin(angle) * volume);
    }
}
