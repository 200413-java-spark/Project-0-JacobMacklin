package com.github.jacobmacklin96.agenda;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.*;

public class AgendaTest {

    ByteArrayOutputStream output = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }
/*
    @Test
    public void prints1AfterAdding1() {
        LinkedList<Timeslot> agenda = new LinkedList<Timeslot>();
        Timeslot t = new Timeslot(0223, 2208, "i1");
        Agenda.add(t, agenda);

        
        

        Agenda.showNext(agenda);

        // String expected = "Your next agenda item is at: 22:08 on 2/23\r\ni1";

        assertEquals("Your next agenda item is at: 22:08 on 2/23\r\ni1", output.toString());
    } 
*/
/*
    @Test
    public void prints1AfterAdding1() {
        StringWriter expectedString = new StringWriter();
        PrintWriter printWriter = new PrintWriter(expectedString);
        
        printWriter.println("Your next agenda item is at: 22:08 on 2/25");
        printWriter.println("i1");
        String expected = expectedString.toString();

        LinkedList<Timeslot> agenda = new LinkedList<Timeslot>();
        Timeslot t = new Timeslot(0225, 2208, "i1");
        Agenda.add(t, agenda);
        Agenda.showNext(agenda);

        assertEquals(expected, output.toString());
    }
*/
    @Test
    public void prints2AfterAdding2() {
    }

}