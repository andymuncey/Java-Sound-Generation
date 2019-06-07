package uk.ac.chester;

import java.util.Arrays;

class Bar {

    Bar(int beats, BarNote... notes) {
        this.beats = beats;
        Arrays.sort(notes);
        this.notes = notes;
    }

    //works on the basis that one beat is a crotchet
    //todo: reconsider as 7/8 is valid time signature but not representable here
    private int beats;

    private BarNote[] notes;

    int getBeats() {
        return beats;
    }

    BarNote[] getNotes() {
        return notes;
    }
}
