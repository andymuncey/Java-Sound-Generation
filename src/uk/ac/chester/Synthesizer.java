package uk.ac.chester;

public interface Synthesizer {

    /**
     *
     * @param sampleRate e.g. 44100 for 44.1 kHz
     * @param volume between 0 and 127
     * @param sample e.g. 44099 for the final sample in the first second of audio
     * @param frequency the frequency of the sound to be generated
     * @return a byte representing the magnitude of the wave form at the instance in time
     */
    byte tone(float sampleRate, int volume, int sample, double frequency);

}
