package com.tinyappco.temperaments;

import com.tinyappco.Note;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EqualTemperamentTest {

    private EqualTemperament et;

    @Before
    public void setUp() throws Exception {
        et = new EqualTemperament();
    }

    @After
    public void tearDown() throws Exception {
        et = null;
    }

    @Test
    public void transpose() {
    }

    @Test
    public void frequency() {


        Note a4 = new Note(Note.Name.A,Note.Accidental.NATURAL, 4 );
        assertEquals(440,et.frequency(a4),0.0001);

        Note dSharp6 = new Note(Note.Name.D, Note.Accidental.SHARP, 6);
        Assert.assertEquals(1244.508,et.frequency(dSharp6),0.0001);

        Note eFlat6 = new Note(Note.Name.E, Note.Accidental.FLAT, 6);
        Assert.assertEquals(1244.508,et.frequency(eFlat6),0.0001);

    }

    @Test
    public void note() {
    }
}