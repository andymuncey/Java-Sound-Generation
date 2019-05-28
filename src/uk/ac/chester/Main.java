package uk.ac.chester;



public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here

        playScale(new Octave().minor());
    }


    static void playScale(double[] scaleNotes) throws Exception{

        ToneGenerator generator = new ToneGenerator();

        for (double freq : scaleNotes){
            generator.play(freq);
            Thread.sleep(250);
        }

        for (int i = scaleNotes.length-1; i >=0 ; i--) {
            generator.play(scaleNotes[i]);
            Thread.sleep(250);
        }
        generator.stop();
    }


}
