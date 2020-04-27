package com.github.jacobmacklin96.agenda;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.ArrayList;
import com.github.jacobmacklin96.agenda.logistics.*;
import com.github.jacobmacklin96.agenda.io.*;

class Agenda {
    
    public static void main(String args[]) {
        LinkedList<Timeslot> agenda = new LinkedList<Timeslot>();
        String next = "";
        Scanner input = new Scanner(System.in);

        while(!next.equals("exit")) {
            next = input.nextLine();
            if(next.equals("add")) {
                Timeslot nextAddition = AgendaLogic.inquiry(input);
                AgendaLogic.add(nextAddition, agenda);
            }
            else if(next.equals("show next item")) {
                AgendaLogic.showNext(agenda, true);
            }
            else if(next.equals("show all items")) {
                AgendaLogic.showAll(agenda, true);
            }
            else if(next.equals("help")) {
                help();
            }
            else if(next.equals("write to file")){
                ArrayList<String> output = new ArrayList<String>();
                output = AgendaLogic.showAll(agenda, false);
                System.out.println("Enter file name: (Blank for default=agenda.txt)");
                next = input.nextLine();
                FileIO fileIO = fileSetup(next);
                fileIO.write(output);
            }
            else if(next.equals("read from file")) {
                System.out.println("Enter file name: (Blank for default=agenda.txt)");
                next = input.nextLine();
                FileIO fileIO = fileSetup(next);
                fileIO.read(agenda);
            }
            else if(next.equals("write to sql server")) {
                AgendaRepo.write(agenda);
            }
            else if(next.equals("read from sql server")) {
                AgendaRepo.read(agenda);
            }
            else if(next.equals("exit")) {}
            else {
                System.out.println("Command not recognized. Use 'help' for command list.");
            }
        }

        input.close();
    }

    public static FileIO fileSetup(String next) {
        FileIO fileIO;
        if(next.length() == 0) {
            fileIO = new FileIO();
        } else {
            fileIO = new FileIO(next);
        }
        return fileIO;
    }

    public static void help() {
        System.out.println("'add' : Add a new agenda item by following prompts.");
        System.out.println("'show next item' : Check the next upcoming agenda item.");
        System.out.println("'show all items' : Print all items currently saved in agenda");
        System.out.println("'exit' : Quit and exit program.");
        System.out.println("--------IO--------");
        System.out.println("read from file");
        System.out.println("write to file");
        System.out.println("read from sql server");
        System.out.println("write to sql server");
    }
    
}