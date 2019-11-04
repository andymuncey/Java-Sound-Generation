package com.tinyappco;

import org.junit.Test;

import static org.junit.Assert.*;

public class NoteTest {

    @Test
    public void stringConstructor() {

        Note a4 = new Note("A4");
        assertEquals( Note.Name.A, a4.getName());
        assertEquals(Note.Accidental.NATURAL, a4.getAccidental());
        assertEquals(4, a4.getOctave());

        Note cSharp5 = new Note("C#5") ;
        assertEquals(Note.Name.C, cSharp5.getName());
        assertEquals(Note.Accidental.SHARP, cSharp5.getAccidental());
        assertEquals(5,cSharp5.getOctave());

    }

    @Test(expected = AssertionError.class)
    public void stringConstructorEmpty() {
        Note invalid = new Note("");
    }

    @Test(expected = AssertionError.class)
    public void stringConstructorInvalidName() {
        Note invalid = new Note("K");
    }

}