package com.tinyappco;


import com.tinyappco.synths.SineWave;
import com.tinyappco.synths.Synthesizer;
import com.tinyappco.temperaments.EqualTemperament;
import com.tinyappco.temperaments.MusicalTemperament;

import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) throws Exception {

        Synthesizer synth = new SineWave();
        MusicalTemperament equalTemperament = new EqualTemperament();

        SoundGenerator generator = new SoundGenerator(synth, equalTemperament);

        generator.play(Note.parse("C4"), 2000, Velocity.PP);
        generator.play(Note.parse("G4"), 2000, Velocity.PP);
        generator.play(Note.parse("C5"), 3000, Velocity.PP);
        generator.play(Note.parse("E5"), 250, Velocity.FFF);
        generator.play(Note.parse("Eb5"), 1750, Velocity.FFF);

    }
}


    //        File file = new File("src/ThoughtContagion.txt");
//        FileInputStream fileInputStream = new FileInputStream(file);
//        byte[] data = new byte[(int)file.length()];
//        int bytesRead = fileInputStream.read(data);
//        fileInputStream.close();
//
//        String scoreFromFile = new String(data, StandardCharsets.UTF_8);
//        Score score = ScoreParser.parseScore(scoreFromFile);
//
//
//        score.play();

//    static void playScale(double[] scaleNotes) throws Exception{
//
//        ToneGenerator generator = new ToneGenerator();
//
//        for (double freq : scaleNotes){
//            generator.play(freq);
//            Thread.sleep(250);
//        }
//
//        for (int i = scaleNotes.length-1; i >=0 ; i--) {
//            generator.play(scaleNotes[i]);
//            Thread.sleep(250);
//        }
//        generator.stop();
//    }
//
//
//}
