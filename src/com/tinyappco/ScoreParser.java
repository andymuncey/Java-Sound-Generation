package com.tinyappco;

import java.util.ArrayList;
import java.util.regex.Pattern;

class ScoreParser {

    static Score parseScore(String text){

        String[] barStrings = text.split(Pattern.quote("|"));

        Score score = new Score();

        for (String barString : barStrings){

            String[] noteStrings = barString.split("\n");

            ArrayList<BarNote> notes = new ArrayList<>();

            for (String noteString : noteStrings){
                if (noteString.length() >= 6) {
                    if (!noteString.startsWith("/")){
                        String[] parts = noteString.split(",");
                        AudibleNote note = AudibleNote.fromString(parts[0]);
                        double startBeat = Double.parseDouble(parts[1]) - 1;
                        double duration = Double.parseDouble(parts[2]);
                        BarNote barNote = new BarNote(note, startBeat,duration);

                        if (parts.length > 3){
                            byte velocity = Byte.parseByte(parts[3]);
                            barNote.setVelocity(velocity);
                        }

                        notes.add(barNote);
                    }
                }
            }
            Bar bar = new Bar(4,notes.toArray(new BarNote[]{}));
            score.append(bar);

        }

        return score;
    }


}
