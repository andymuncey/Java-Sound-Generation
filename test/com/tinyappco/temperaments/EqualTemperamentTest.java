package com.tinyappco.temperaments;

import com.tinyappco.FrequencyFinder;
import com.tinyappco.Note;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EqualTemperamentTest {

    private FrequencyFinder ff;

    @Before
    public void setUp() throws Exception {
        ff = new FrequencyFinder(new EqualTemperament());
    }

    @After
    public void tearDown() throws Exception {
        ff = null;
    }

    @Test
    public void transpose() {
    }

    @Test
    public void frequency() {


        Note a4 = new Note(Note.Name.A,Note.Accidental.NATURAL, 4 );
        assertEquals(440, ff.frequency(a4),0.0001);

        Note dSharp6 = new Note(Note.Name.D, Note.Accidental.SHARP, 6);
        Assert.assertEquals(1244.508, ff.frequency(dSharp6),0.0001);

        Note eFlat6 = new Note(Note.Name.E, Note.Accidental.FLAT, 6);
        Assert.assertEquals(1244.508, ff.frequency(eFlat6),0.0001);

    }

    @Test
    public void note() {
    }
}