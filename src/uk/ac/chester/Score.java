package uk.ac.chester;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Score {

    private int tempo = 120; //todo: make this so tempo can change throughout score

    private ArrayList<Bar> bars;

    void append(Bar bar){
        bars.add(bar);
    }

    public Score(){
        bars = new ArrayList<>();
    }

    void play(){

        double beatLength = (60*1000) / tempo;

        int elapsedBeats = 0;

        for (Bar bar:bars) {

            for (BarNote note: bar.getNotes()){

                ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        ToneGenerator generator = new ToneGenerator();
                        generator.play(note.getNote().getFrequency(),(int)(note.getDuration() * beatLength), note.getVelocity());
                    }
                };
                int delayMS = (int)((note.getStart()* beatLength) + (elapsedBeats * beatLength));
                scheduledExecutorService.schedule(runnable,delayMS, TimeUnit.MILLISECONDS);

            }
            elapsedBeats += bar.getBeats();

        }


    }

}
