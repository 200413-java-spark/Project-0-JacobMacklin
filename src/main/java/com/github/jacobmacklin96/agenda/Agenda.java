package com.github.jacobmacklin96.agenda;

import java.util.Scanner;
import java.util.*;

class Agenda {
    
    public static void main(String args[]) {
        LinkedList<Timeslot> agenda = new LinkedList<Timeslot>();
        String next = "";
        Scanner input = new Scanner(System.in);

        while(!next.equals("exit")) {
            next = input.nextLine();
            if(next.equals("add")) {
                Timeslot nextAddition = inquiry(input);
                boolean success = add(nextAddition, agenda);
                if(success == true){
                    System.out.println("Successfully added new event");
                } 
                else {
                    System.out.println("Failed to add new event");
                }
            }
            else if(next.equals("Next agenda item")) {
                showNext(agenda);
            }
            else if(next.equals("Show all items")) {
                showAll(agenda);
            }
            else if(next.equals("exit")) {}
            else {
                System.out.println("Command not recognized.");
            }
        }

        input.close();
    }

    public static Timeslot inquiry(Scanner input) {
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

    public static Timeslot presetParse(String d, String t, String activity) {
        d = d.substring(0,2) + d.substring(3, 5);
        int date = Integer.parseInt(d);
        t = t.substring(0,2) + t.substring(3, 5);
        int time = Integer.parseInt(t);
        Timeslot complete = new Timeslot(date, time, activity);
        return complete;
    }

    public static boolean add(Timeslot t, LinkedList<Timeslot> agenda) {
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
                    if(tmp.day == t.day && tmp.time < t.time) {
                        agenda.add(i+1, t);
                    } else {
                        agenda.add(i, t);
                    }
                    t = null;
                }
            }
            i++;
        }
        return true;
    }
 
    public static ArrayList<String> showNext(LinkedList<Timeslot> agenda) {
        ArrayList<String> list = new ArrayList<String>();
        Timeslot t = agenda.getFirst();
        list.add("Your next agenda item is at: " + t.timeDateToString());
        list.add(t.activity);
        printStrings(list);
        return list;

    }

    public static ArrayList<String> showAll(LinkedList<Timeslot> agenda) {
        ArrayList<String> list = new ArrayList<String>();
        Iterator<Timeslot> iter = agenda.iterator();
        while(iter.hasNext()) {
            Timeslot t = iter.next();
            list.add("Your next agenda item is at: " + t.timeDateToString());
            list.add(t.activity);
        }
        printStrings(list);
        return list;
    }

    private static void printStrings(ArrayList<String> list) {
        for (String string : list) {
            System.out.println(string);
        }
        return;
    }
}

class Timeslot {
    int day;
    int time;
    String activity;

    public Timeslot(int day, int time, String activity) {
        this.day = day;
        this.time = time;
        this.activity = activity;
    }

    public Timeslot() {
        this.day = 0;
        this.time = 0;
        this.activity = "";
    }

    public String timeDateToString() {
        String s = "";
        if(this.time % 100 < 10) {
            s = (this.time/100) + ":0" + (this.time % 100) + " on " + (this.day/100) + "/" + (this.day%100);
        } else {
            s = (this.time/100) + ":" + (this.time % 100) + " on " + (this.day/100) + "/" + (this.day%100);
        }
        return s;
    }
}