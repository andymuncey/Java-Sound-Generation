package com.tinyappco;

import com.tinyappco.synths.DecayingSineWave;
import com.tinyappco.synths.Piano;
import com.tinyappco.synths.SineWave;
import com.tinyappco.temperaments.EqualTemperament;
import com.tinyappco.temperaments.MusicalTemperament;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Score {

    private int tempo = 120; //todo: make this so tempo can change throughout score

    private ArrayList<Bar> bars;
    private ToneGenerator generator;

    void append(Bar bar){
        bars.add(bar);
    }

    public Score(){
        bars = new ArrayList<>();
        try {
            generator = new ToneGenerator(new DecayingSineWave(), new EqualTemperament());
        } catch (Exception ignored){}
    }


    void play() {

        double beatLength = (60.0*1000) / tempo;

        int elapsedBeats = 0;
        MusicalTemperament temperament = new EqualTemperament();

        for (Bar bar:bars) {

            for (BarNote note: bar.getNotes()){

                ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

                Runnable runnable = () -> {
                    double frequency = temperament.frequency(note.getNote());
                    generator.play(frequency, (int) (note.getDuration() * beatLength), (short)(note.getVelocity()*10000));
                };
                int delayMS = (int)((note.getStart()* beatLength) + (elapsedBeats * beatLength));
                scheduledExecutorService.schedule(runnable,delayMS, TimeUnit.MILLISECONDS);

            }
            elapsedBeats += bar.getBeats();
        }
    }

}


