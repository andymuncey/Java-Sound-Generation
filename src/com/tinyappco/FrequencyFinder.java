package com.tinyappco;

import com.tinyappco.temperaments.EqualTemperament;
import com.tinyappco.temperaments.Temperament;

/**
 * Find frequencies for notes and performs transpositions
 */
public class FrequencyFinder
{

    private final Transposer transposer;

    public FrequencyFinder(Temperament temperament){
        this.transposer = new Transposer(temperament);
    }

    public FrequencyFinder(){
        this.transposer = new Transposer(new EqualTemperament());
    }

    private static final double c0 = 16.35160; //the lowest note we will accept

    /**
     * Calculate the frequency for a given note
     *
     * @param note a Note
     * @return the frequency (Hz) for the note
     */
    final public double frequency(Note note)
    {
        note.convertToSharpRepresentation();
        Note.Name name = note.getName();
        Note.Accidental accidental = note.getAccidental();
        int octave = note.getOctave();

        //find frequency of C for the Octave of the note
        double frequency = c0 * Math.pow(2, octave);

        //find semitone difference between C and desired note (excluding octave)
        int semitonesUp = 0;
        for (int i = 0; i < Scales.C_CHROMATIC.length; i++)
        {
            Note scaleNote = Scales.C_CHROMATIC[i];
            if (name.equals(scaleNote.getName()) && accidental.equals(scaleNote.getAccidental()))
            {
                break;
            }
            semitonesUp++;
        }

        return transposer.transpose(frequency, semitonesUp);
    }

    /**
     * Determine a note for a given frequency
     *
     * @param frequency a frequency in Hz
     * @return a Note
     */
    final public Note note(double frequency)
    {
        int offset = 0;
        double currentNoteFrequency = c0;
        double upper = currentNoteFrequency * 1.02;
        //calculate name - start at c0 and increment by semitones, check no more than 2% out (difference between notes is ~5.9463%)
        //todo: make faster by finding the right octave first
        while (frequency > upper)
        {
            offset++;
            currentNoteFrequency = transposer.transpose(currentNoteFrequency, 1);
            upper = currentNoteFrequency * 1.02;
        }
        int octave = offset / 12;
        int interval = offset % 12;

        Note.Name name = Scales.C_CHROMATIC[interval].getName();
        Note.Accidental accidental = Scales.C_CHROMATIC[interval].getAccidental();

        return new Note(name, accidental, octave);
    }

}
