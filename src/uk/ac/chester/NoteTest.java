package uk.ac.chester;

import org.junit.Assert;

import static org.junit.Assert.*;

public class NoteTest {

    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void getName() {

        Note a4 = new Note(440);
        Assert.assertEquals(a4.getName(),"A4");

        Note dSharp7 = new Note(2489.016);
        Assert.assertEquals("D♯7",dSharp7.getName());

    }

    @org.junit.Test
    public void getFreq() {

        Note a4 = new Note(Note.Name.A,4,Note.Accidental.NATURAL);
        Assert.assertEquals(440,a4.getFrequency(),0.0001);

        Note dSharp6 = new Note(Note.Name.D, 6, Note.Accidental.SHARP);
        Assert.assertEquals(1244.508,dSharp6.getFrequency(),0.0001);


        Note eFlat6 = new Note(Note.Name.E, 6, Note.Accidental.FLAT);
        Assert.assertEquals(1244.508,dSharp6.getFrequency(),0.0001);

    }

}