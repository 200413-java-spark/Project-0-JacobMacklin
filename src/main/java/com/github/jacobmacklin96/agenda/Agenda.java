package com.github.jacobmacklin96.agenda;

import java.util.Scanner;
import java.util.*;

class Agenda {
    static LinkedList<Timeslot> agenda = new LinkedList<Timeslot>();
    public static void main(String args[]) {
        String next = "";
        Scanner input = new Scanner(System.in);

        while(!next.equals("exit")) {
            next = input.nextLine();
            if(next.equals("add")) {
                Timeslot nextAddition = inquiry(input);
                boolean success = add(nextAddition);
                if(success == true){
                    System.out.println("Successfully added new event");
                } 
                else {
                    System.out.println("Failed to add new event");
                }
            }
            else if(next.equals("Next agenda item")) {
                showNext();
            }
            else if(next.equals("Show all items")) {
                showAll();
            }
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

    public static boolean add(Timeslot t) {
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
                    agenda.add(i, t);
                    t = null;
                }
            }
            i++;
        }
        return true;
    }
 
    public static void showNext() {
        Timeslot t = agenda.getFirst();
        System.out.print("Your next agenda item is at: " + (t.time/100) + ":" + (t.time % 100));
        System.out.println(" on " + (t.day/100) + "/" + (t.day%100));
        System.out.println(t.activity);
    }

    public static void showAll() {
        Iterator<Timeslot> iter = agenda.iterator();
        while(iter.hasNext()) {
            Timeslot t = iter.next();
            System.out.print("Your next agenda item is at: " + (t.time/100) + ":" + (t.time % 100));
            System.out.println(" on " + (t.day/100) + "/" + (t.day%100));
            System.out.println(t.activity);
        }
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
}