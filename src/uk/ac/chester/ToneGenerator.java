package uk.ac.chester;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.SourceDataLine;

public class ToneGenerator {


    public void setSynth(Synthesizer synth) {
        this.synth = synth;
    }

    private Synthesizer synth = new Piano();

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
                float sampleRate = 44100;

                byte[] buf = new byte[1];
                AudioFormat audioFormat = new AudioFormat(sampleRate, 8, 1, true, false);

                try {
                    SourceDataLine sdl = AudioSystem.getSourceDataLine(audioFormat);
                    sdl.open();
                    sdl.start();

                    int volume = 127; //cant exceed 127 or will overflow the byte once multiplied by the magnitude of the wave

                    for (int i = 0; running; i++) {
                        double frequency = Double.longBitsToDouble(frequencyAsLong);
                        buf[0] = synth.tone(sampleRate, volume, i, frequency);;
                        sdl.write(buf, 0, 1);
                    }
                    sdl.drain();
                    sdl.stop();
                } catch (Exception ignored) {
                }
            });

            thread.start();
        }
    }


    /**
     *
     * @param frequency the frequency of the tone to generate
     * @param duration how long to play for, in milliseconds
     */
    void play(double frequency, int duration, byte velocity) {


        Thread thread = new Thread(() -> {
            float sampleRate = 44100;

            int length = (int)(sampleRate * ((double)duration / 1000.0));

            byte[] buf = new byte[1];
            AudioFormat audioFormat = new AudioFormat(sampleRate, 8, 1, true, false);

            try {
                SourceDataLine sdl = AudioSystem.getSourceDataLine(audioFormat);
                sdl.open();
                sdl.start();

                for (int sample = 0; sample < length; sample++) {
                    buf[0] = synth.tone(sampleRate, velocity, sample, frequency);;
                    sdl.write(buf, 0, 1);
                }
                sdl.drain();
                sdl.stop();
            } catch (Exception ignored) {
            }
        });

        thread.start();

    }



}
