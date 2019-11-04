package com.tinyappco.temperaments;

import com.tinyappco.Note;
import com.tinyappco.Scales;

public class EqualTemperament implements MusicalTemperament {

    private static double c0 = 16.35160; //the lowest note we will accept

    @Override
    public double transpose(double frequency, int semitones){
        return frequency * Math.pow(Math.pow(2, 1.0/12.0), semitones);
    }

    @Override
    public double frequency(Note note) {
        note.convertToSharpRepresentation();
        Note.Name name = note.getName();
        Note.Accidental accidental = note.getAccidental();
        int octave = note.getOctave();

        //work out how many semitones to go up by, based on the name and accidental of the note and their positions
        int semitonesUp = 0;
        for (int i = 0; i < Scales.C_CHROMATIC.length; i++) {
            Note scaleNote = Scales.C_CHROMATIC[i];
            if (name.equals(scaleNote.getName()) && accidental.equals(scaleNote.getAccidental())){
                break;
            }
            semitonesUp++;
        }

        //find frequency of C for the Octave
        double frequency = c0 * Math.pow(2,octave);
        return transpose(frequency,semitonesUp);
    }

    @Override
    public Note note(double frequency) {
        int offset = 0;
        double currentNoteFrequency = c0;
        double upper = currentNoteFrequency * 1.02;
        //calculate name - start at c0 and increment by semitones, check no more than 2% out (difference between notes is ~5.9463%)
        while (frequency > upper){
            offset++;
            currentNoteFrequency = transpose(currentNoteFrequency, 1);
            upper = currentNoteFrequency * 1.02;
        }
        int octave = offset / 12;
        int interval = offset % 12;

        Note.Name name = Scales.C_CHROMATIC[interval].getName();
        Note.Accidental accidental = Scales.C_CHROMATIC[interval].getAccidental();

        return new Note(name,accidental,octave);
    }
}
