package com.tinyappco;

import com.tinyappco.synths.Synthesizer;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

class SoundGenerator {

    private final float sampleRate = 44100; //same as an audio CD
    private final int sampleSize = 16; //two bytes in each sample
    private AudioFormat audioFormat = new AudioFormat(sampleRate, sampleSize, 1, true, false);
    private final SourceDataLine sdl;
    private final Synthesizer synth;
    private final FrequencyFinder frequencyFinder;

    SoundGenerator(Synthesizer synth, FrequencyFinder frequencyFinder) throws LineUnavailableException {
        sdl = AudioSystem.getSourceDataLine(audioFormat);
        sdl.open();
        sdl.start();
        this.synth = synth;
        this.frequencyFinder = frequencyFinder;
    }

    void close() {
        sdl.drain();
        sdl.stop();
    }

    /**
     *  Plays a specified frequency
     * @param frequency the frequency of the tone to generate
     * @param duration how long to play for, in milliseconds
     * @param volume how loud to play the note (0-32767)
     */
    void play(double frequency, int duration, short volume) {

        int length = (int)(sampleRate * ((double)duration / 1000.0));
        byte[] buf = new byte[2];

        for (int sampleNo = 0; sampleNo < length; sampleNo++) {
            short sample = synth.sample(sampleRate, volume, sampleNo, frequency);
            buf[0] = (byte) sample; //small values in first byte, large in second
            buf[1] = (byte) (sample >>> 8); //flip if bigEndian set to true for AudioFormat
            sdl.write(buf, 0, 2);
        }
    }

    /**
     *  Plays a named note for specified duration and specified velocity
     * @param note a note to play
     * @param duration the duration to play the note
     * @param velocity how load to play the note (0-127)
     */
    void play(Note note, int duration, byte velocity) {
        //scale from 0-127 to 0-32767
        short volume = (short)(velocity * (Short.MAX_VALUE / Byte.MAX_VALUE));

        double frequency = frequencyFinder.frequency(note);
        play(frequency,duration,volume);
    }

    void play(PlayableNote playableNote){
        play(playableNote, playableNote.getDuration(), playableNote.getVelocity());
    }

}




