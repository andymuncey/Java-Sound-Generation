package com.tinyappco;

import com.tinyappco.synths.Piano;
import com.tinyappco.synths.SineWave;

import javax.sound.sampled.*;

public class ToneGenerator {

    private float sampleRate = 44100;
    private int sampleSize = 16;
    private AudioFormat audioFormat = new AudioFormat(sampleRate, sampleSize, 1, true, false);
    private SourceDataLine sdl;// = AudioSystem.getSourceDataLine(audioFormat);

    public ToneGenerator(Synthesizer synth) throws LineUnavailableException {
        sdl = AudioSystem.getSourceDataLine(audioFormat);
        sdl.open();
        sdl.start();

        this.synth = synth;
    }

    public ToneGenerator() throws LineUnavailableException{
        this(new SineWave());
    }


    public void setSynth(Synthesizer synth) {
        this.synth = synth;
    }

    private Synthesizer synth;
    private void setFrequency(double frequency){
        frequencyAsLong = (Double.doubleToLongBits(frequency));
    }

    //needed as double is not atomic
    private long frequencyAsLong;

    private boolean running = false;

    void stop() {
        running = false;
    }

    void play(double newFrequency) {
        setFrequency(newFrequency);

        if (!running) {
            running = true;

            Thread thread = new Thread(() -> {

                    short volume = Short.MAX_VALUE;

                    for (int i = 0; running; i++) {
                        double frequency = Double.longBitsToDouble(frequencyAsLong);
//                        buf[0] = synth.sample(sampleRate, volume, i, frequency);
//                        sdl.write(buf, 0, 1);
                        byte[] buf = new byte[2];
                        short sample = synth.sample(sampleRate, volume, i, frequency);
                        buf[0] = (byte) sample; //takes the low bits of sample
                        buf[1] = (byte) (sample >>> 8);
                        sdl.write(buf, 0, 0);
                    }

              //  } catch (Exception ignored) {
              //  }
            });

            thread.start();
        }
    }


    /**
     *
     * @param frequency the frequency of the tone to generate
     * @param duration how long to play for, in milliseconds
     */
    void play(double frequency, int duration, short velocity) {

        Thread thread = new Thread(() -> {

            int length = (int)(sampleRate * ((double)duration / 1000.0));

            byte[] buf = new byte[2];

            for (int sampleNo = 0; sampleNo < length; sampleNo++) {
                short sample = synth.sample(sampleRate, Short.MAX_VALUE, sampleNo, frequency);
                buf[0] = (byte) sample;
                buf[1] = (byte) (sample >>> 8);
                sdl.write(buf, 0, 2);
            }
        });

        thread.start();

    }


    void close(){
        sdl.drain();
        sdl.stop();
    }

}