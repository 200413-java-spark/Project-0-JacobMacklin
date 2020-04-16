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
        int day = 0225;
        int time = 2208;
        Timeslot t = new Timeslot(day, time, "i1");
        Agenda.add(t, agenda);
        Agenda.showNext(agenda);

        assertEquals(expected, output.toString());
    }
*/

    @Test
    public void prints1AfterAdding1() {
        /*
        String[] expected = new String[2];
        expected[0] = "Your next agenda item is at: 22:08 on 2/25";
        expected[1] = "i1";
        */
        ArrayList<String> expected = new ArrayList<String>();
        expected.add("Your next agenda item is at: 22:08 on 2/25");
        expected.add("i1");

        LinkedList<Timeslot> agenda = new LinkedList<Timeslot>();
        //int day = 1025;
        //int time = 2208;
        //Timeslot t = new Timeslot(day, time, "i1");
        Timeslot t = Agenda.presetParse("02/25", "22:08", "i1");
        Agenda.add(t, agenda);
        ArrayList<String> actual = new ArrayList<String>();
        actual = Agenda.showNext(agenda);
        assertEquals(expected.get(0), actual.get(0));

    }

    @Test
    public void prints2AfterAdding2() {
    }

}