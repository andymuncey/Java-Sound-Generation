package com.tinyappco;


import com.tinyappco.synths.SineWave;
import com.tinyappco.synths.Synthesizer;
import com.tinyappco.temperaments.EqualTemperament;
import com.tinyappco.temperaments.JustIntonation;

public class Main {

    public static void main(String[] args) throws Exception {

        Synthesizer synth = new SineWave();
        FrequencyFinder temperament = new FrequencyFinder(new EqualTemperament());

        SoundGenerator generator = new SoundGenerator(synth, temperament);

//        generator.play(Note.parse("C4"), 2000, Velocity.PP);
//        generator.play(Note.parse("G4"), 2000, Velocity.PP);
//        generator.play(Note.parse("C5"), 3000, Velocity.PP);
//        generator.play(Note.parse("E5"), 250, Velocity.FFF);
//        generator.play(Note.parse("Eb5"), 1750, Velocity.FFF);

        generator.play(Note.parse("G#4"), 250, Velocity.MF);
        generator.play(Note.parse("C#4"), 250, Velocity.MF);
        generator.play(Note.parse("G#4"), 250, Velocity.MF);
        generator.play(Note.parse("C#4"), 250, Velocity.MF);


        generator.play(Note.parse("A4"), 250, Velocity.MF);
        generator.play(Note.parse("C#4"), 250, Velocity.MF);
        generator.play(Note.parse("A4"), 250, Velocity.MF);
        generator.play(Note.parse("C#4"), 250, Velocity.MF);

        generator.play(Note.parse("G#4"), 250, Velocity.MF);
        generator.play(Note.parse("C#4"), 250, Velocity.MF);
        generator.play(Note.parse("G#4"), 250, Velocity.MF);
        generator.play(Note.parse("C#4"), 250, Velocity.MF);

        generator.play(Note.parse("F#4"), 250, Velocity.MF);
        generator.play(Note.parse("C#4"), 250, Velocity.MF);
        generator.play(Note.parse("F#4"), 250, Velocity.MF);
        generator.play(Note.parse("C#4"), 250, Velocity.MF);

        generator.play(Note.parse("B4"), 250, Velocity.MF);
        generator.play(Note.parse("C#4"), 250, Velocity.MF);
        generator.play(Note.parse("B4"), 250, Velocity.MF);
        generator.play(Note.parse("C#4"), 250, Velocity.MF);

        generator.play(Note.parse("A4"), 250, Velocity.MF);
        generator.play(Note.parse("C#4"), 250, Velocity.MF);
        generator.play(Note.parse("A4"), 250, Velocity.MF);
        generator.play(Note.parse("C#4"), 250, Velocity.MF);

        generator.play(Note.parse("G#4"), 250, Velocity.MF);
        generator.play(Note.parse("D#4"), 250, Velocity.MF);
        generator.play(Note.parse("G#4"), 250, Velocity.MF);
        generator.play(Note.parse("D#4"), 250, Velocity.MF);

        generator.play(Note.parse("G#4"), 125, Velocity.MF);
        generator.play(Note.parse("A4"), 125, Velocity.MF);
        generator.play(Note.parse("G#4"), 125, Velocity.MF);
        generator.play(Note.parse("F#4"), 125, Velocity.MF);
        generator.play(Note.parse("G#4"), 125, Velocity.MF);
        generator.play(Note.parse("F#4"), 125, Velocity.MF);

        generator.play(Note.parse("E4"), 125, Velocity.MF);
        generator.play(Note.parse("D#4"), 125, Velocity.MF);
        generator.play(Note.parse("C#4"), 500, Velocity.MF);

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
