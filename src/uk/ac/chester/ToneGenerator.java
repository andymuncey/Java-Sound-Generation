package uk.ac.chester;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.SourceDataLine;

public class ToneGenerator {

    private void setFrequency(double frequency){
        frequencyAsLong = (Double.doubleToLongBits(frequency));
    }

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
                        double angle = i / (sampleRate / frequency) * 2.0 * Math.PI;
                        buf[0] = (byte) (Math.sin(angle) * volume); //Math.sin() returns value between -1 and 1, may byte value is 127
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

}
