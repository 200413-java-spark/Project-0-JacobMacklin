package com.github.jacobmacklin96.agenda.logistics;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.ArrayList;

import com.github.jacobmacklin96.agenda.io.*;


public class TerminalClient {

    public static void client(LinkedList<Timeslot> agenda) {

        String next = "";
        Scanner input = new Scanner(System.in);

        while(!next.equals("exit")) {
            next = input.nextLine();
            if(next.equals("add")) {
                Timeslot nextAddition = AgendaLogic.inquiry(input);
                AgendaLogic.add(nextAddition, agenda);
            }
            else if(next.equals("remove")) {
                AgendaLogic.remove(agenda, input);
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
                FileIO fileIO = FileIO.fileSetup(next);
                fileIO.write(output);
            }
            else if(next.equals("read from file")) {
                System.out.println("Enter file name: (Blank for default=agenda.txt)");
                next = input.nextLine();
                FileIO fileIO = FileIO.fileSetup(next);
                fileIO.read(agenda);
            }
            else if(next.equals("write to database")) {
                AgendaRepo.write(agenda);
            }
            else if(next.equals("read from database")) {
                AgendaRepo.read(agenda);
            }
            else if(next.equals("exit")) {}
            else {
                System.out.println("Command not recognized. Use 'help' for command list.");
            }
        }

        input.close();

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