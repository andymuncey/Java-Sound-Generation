package com.tinyappco;

public class BarNote implements Comparable<BarNote> {

    /**
     *  @param note the note to play
     * @param start the beat of the bar to start at (0 being the first beat)
     * @param duration the number of beats the note should last
     */
    public BarNote(AudibleNote note, double start, double duration) {
        this.note = note;
        this.duration = duration;
        this.start = start;
    }

    public AudibleNote getNote() {
        return note;
    }

    public double getDuration() {
        return duration;
    }

    public double getStart() {
        return start;
    }

    private AudibleNote note;
    private double duration;
    private double start;

    public short getVelocity() {
        return velocity;
    }

    public void setVelocity(byte velocity) {
        this.velocity = velocity;
    }

    private short velocity = 127;


    @Override
    public int compareTo(BarNote o) {
        return (int)(start*32 - o.start*32);
    }
}
