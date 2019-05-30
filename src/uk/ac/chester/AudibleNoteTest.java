package uk.ac.chester;

import org.junit.Assert;

public class AudibleNoteTest {

    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void getName() {

        AudibleNote a4 = new AudibleNote(440);
        Assert.assertEquals(a4.getFullName(),"A4");

        AudibleNote dSharp7 = new AudibleNote(2489.016);
        Assert.assertEquals("D♯7",dSharp7.getFullName());

    }

    @org.junit.Test
    public void getFreq() {

        AudibleNote a4 = new AudibleNote(Note.Name.A,4, Note.Accidental.NATURAL);
        Assert.assertEquals(440,a4.getFrequency(),0.0001);

        AudibleNote dSharp6 = new AudibleNote(Note.Name.D, 6, Note.Accidental.SHARP);
        Assert.assertEquals(1244.508,dSharp6.getFrequency(),0.0001);


        AudibleNote eFlat6 = new AudibleNote(Note.Name.E, 6, Note.Accidental.FLAT);
        Assert.assertEquals(1244.508,dSharp6.getFrequency(),0.0001);

    }

}