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

    // Test to confirm that a single item is added to the data structure as expected
    @Test
    public void check1AfterAdding1() {
        ArrayList<String> expected = new ArrayList<String>();
        expected.add("Your next agenda item is at: 22:08 on 2/25");
        expected.add("i1");

        LinkedList<Timeslot> agenda = new LinkedList<Timeslot>();
        Timeslot t = Agenda.presetParse("02/25", "22:08", "i1");
        Agenda.add(t, agenda);

        ArrayList<String> actual = new ArrayList<String>();
        actual = Agenda.showNext(agenda);

        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), actual.get(i));
        }

    }

    // Test to confirm that two items are added and sorted as expected by day
    @Test
    public void check2AfterAdding2() {

        ArrayList<String> expected = new ArrayList<String>();
        expected.add("Your next agenda item is at: 22:08 on 2/25");
        expected.add("i1");
        expected.add("Your next agenda item is at: 10:19 on 10/12");
        expected.add("i2");

        LinkedList<Timeslot> agenda = new LinkedList<Timeslot>();
        Timeslot t = Agenda.presetParse("02/25", "22:08", "i1");
        Agenda.add(t, agenda);
        t = Agenda.presetParse("10/12", "10:19", "i2");
        Agenda.add(t, agenda);
        ArrayList<String> actual = new ArrayList<String>();
        actual = Agenda.showAll(agenda);

        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), actual.get(i));
        }

    }

    // Test to confirm that four items are added and sorted as expected
    @Test
    public void check4AfterAdding4() {
        ArrayList<String> expected = new ArrayList<String>();
        expected.add("Your next agenda item is at: 22:08 on 2/25");
        expected.add("i1");
        expected.add("Your next agenda item is at: 3:45 on 5/7");
        expected.add("i3");
        expected.add("Your next agenda item is at: 13:10 on 10/3");
        expected.add("i4");
        expected.add("Your next agenda item is at: 10:19 on 10/12");
        expected.add("i2");
        
        

        LinkedList<Timeslot> agenda = new LinkedList<Timeslot>();
        Timeslot t = Agenda.presetParse("02/25", "22:08", "i1");
        Agenda.add(t, agenda);
        t = Agenda.presetParse("10/12", "10:19", "i2");
        Agenda.add(t, agenda);
        t = Agenda.presetParse("05/07", "03:45", "i3");
        Agenda.add(t, agenda);
        t = Agenda.presetParse("10/03", "13:10", "i4");
        Agenda.add(t, agenda);
        ArrayList<String> actual = new ArrayList<String>();
        actual = Agenda.showAll(agenda);

        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), actual.get(i));
        }
    }

    // Test to confirm that five items are added and sorted by time and day as expected
    @Test
    public void check5AfterAdding5ForTimeSort() {

        ArrayList<String> expected = new ArrayList<String>();
        expected.add("Your next agenda item is at: 8:30 on 2/25");
        expected.add("i4");
        expected.add("Your next agenda item is at: 10:19 on 2/25");
        expected.add("i2");
        expected.add("Your next agenda item is at: 21:08 on 2/25");
        expected.add("i3");
        expected.add("Your next agenda item is at: 22:08 on 2/25");
        expected.add("i1");
        expected.add("Your next agenda item is at: 23:10 on 2/25");
        expected.add("i5");
        

        LinkedList<Timeslot> agenda = new LinkedList<Timeslot>();
        Timeslot t = Agenda.presetParse("02/25", "22:08", "i1");
        Agenda.add(t, agenda);
        t = Agenda.presetParse("02/25", "10:19", "i2");
        Agenda.add(t, agenda);
        t = Agenda.presetParse("02/25", "21:08", "i3");
        Agenda.add(t, agenda);
        t = Agenda.presetParse("02/25", "08:30", "i4");
        Agenda.add(t, agenda);
        t = Agenda.presetParse("02/25", "23:10", "i5");
        Agenda.add(t, agenda);
        ArrayList<String> actual = new ArrayList<String>();
        actual = Agenda.showAll(agenda);

        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), actual.get(i));
        }

    }

}