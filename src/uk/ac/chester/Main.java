package uk.ac.chester;


import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here


        File file = new File("src/ThoughtContagion.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] data = new byte[(int)file.length()];
        int bytesRead = fileInputStream.read(data);
        fileInputStream.close();

        String scoreFromFile = new String(data, StandardCharsets.UTF_8);
        Score score = ScoreParser.parseScore(scoreFromFile);


        score.play();
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
