package com.tinyappco;

public class PlayableNote extends Note {

    public static PlayableNote parse(String noteName, int duration, byte velocity) {
        Name name = noteNameFromNoteString(noteName);
        Accidental accidental = accidentalFromNoteString(noteName);
        int octave = octaveFromNoteString(noteName);
        return new PlayableNote(name,accidental,octave, duration, velocity);
    }

    private int duration;
    private byte velocity; //matches MIDI velocity values of 0-127

    public PlayableNote(Name name, Accidental accidental, int duration, byte velocity ) {
        this(name,accidental,4, duration, velocity);
    }

    public PlayableNote(Name name, Accidental accidental, int octave, int duration, byte velocity) {
        super(name, accidental, octave);
        this.duration = duration;
        this.velocity = velocity;
    }

    public int getDuration() {
        return duration;
    }

    public byte getVelocity() {
        return velocity;
    }




}
