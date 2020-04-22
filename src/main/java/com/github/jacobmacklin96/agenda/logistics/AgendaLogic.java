package com.github.jacobmacklin96.agenda.logistics;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class AgendaLogic {
    
    // Asks user for input in order to build a Timeslot to then be added to the agenda structure
    public static Timeslot inquiry(Scanner input) {
        try {
            System.out.println("Input date(MM/DD) of new event: ");
            String tmp = input.nextLine();
            tmp = tmp.substring(0,2) + tmp.substring(3,5);
            int date = Integer.parseInt(tmp);
            
            System.out.println("Input time(HH:MM) of new event: ");
            tmp = input.nextLine();
            tmp = tmp.substring(0,2) + tmp.substring(3,5);
            int time = Integer.parseInt(tmp);  

            System.out.println("Input event title and/or notes");
            tmp = input.nextLine();
            Timeslot complete = new Timeslot(date, time, tmp);
            return complete;
        }
        catch(NumberFormatException | StringIndexOutOfBoundsException e) {
            System.out.println("Please follow specified format.");
            return null;
        }
    }

    // Used for building Timeslots via file and for testing purposes
    // Expected input d='MM/DD'(date) t='HH:MM'(time) activity='any description'
    public static Timeslot presetParse(String d, String t, String activity) {
        d = d.substring(0,2) + d.substring(3, 5);
        int date = Integer.parseInt(d);
        t = t.substring(0,2) + t.substring(3, 5);
        int time = Integer.parseInt(t);
        Timeslot complete = new Timeslot(date, time, activity);
        return complete;
    }

    // Adds the supplied timeslot to the supplied agenda
    public static void add(Timeslot t, LinkedList<Timeslot> agenda) {
        Iterator<Timeslot> iter = agenda.iterator();
        int i = 0;
        while(t != null) {
            if(!iter.hasNext()) {
                agenda.addLast(t);
                t = null;
            }
            else {
                Timeslot tmp = iter.next();
                if(tmp.day >= t.day) {
                    if(tmp.day == t.day && tmp.time >= t.time || tmp.day != t.day) {
                        agenda.add(i, t);
                        t = null;
                    }
                    
                }
            }
            i++;
        }
        return;
    }
 
    // Prints and returns the next agenda time/date and item(Timeslot) associated.
    public static ArrayList<String> showNext(LinkedList<Timeslot> agenda, boolean consoleOutput) {
        ArrayList<String> list = new ArrayList<String>();
        Timeslot t = agenda.getFirst();
        list.add("Your next agenda item is at: " + t.timeDateToString());
        list.add(t.activity);
        if(consoleOutput == true) {
            printStrings(list);
        }
        return list;

    }

    // Prints to console and returns an ArrayList of all items in the agenda
    // ArrayList example.. list[0] = String for agenda time/date, list[1] = item associated with that time/date..etc.
    public static ArrayList<String> showAll(LinkedList<Timeslot> agenda, boolean consoleOutput) {
        ArrayList<String> list = new ArrayList<String>();
        Iterator<Timeslot> iter = agenda.iterator();
        while(iter.hasNext()) {
            Timeslot t = iter.next();
            list.add("Your next agenda item is at: " + t.timeDateToString());
            list.add(t.activity);
        }
        if(consoleOutput == true){
            printStrings(list);
        }
        return list;
    }

    // Prints the ArrayLists provided by show methods
    private static void printStrings(ArrayList<String> list) {
        for (String string : list) {
            System.out.println(string);
        }
        return;
    }

}