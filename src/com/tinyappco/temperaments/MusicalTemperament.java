package com.tinyappco.temperaments;

import com.tinyappco.Note;

/**
 * Represents a musical temperament in which frequencies exist for named notes
 */
public interface MusicalTemperament {

    /**
     * Calculate the frequency for a given note
     * @param note a Note
     * @return the frequency (Hz) for the note
     */
    public double frequency(Note note);

    /**
     * Determine a note for a given frequency
     * @param frequency a frequency in Hz
     * @return a Note
     */
    public Note note(double frequency);

    /**
     * Transposes a frequency by a given number of semitones
     * @param frequency a starting frequency
     * @param semitones number of semitones to transpose by
     * @return the new frequency
     */
    double transpose(double frequency, int semitones);
}
