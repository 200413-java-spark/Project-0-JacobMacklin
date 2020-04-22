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
                System.out.println("'add' : Add a new agenda item by following prompts.");
                System.out.println("'show next item' : Check the next upcoming agenda item.");
                System.out.println("'show all items' : Print all items currently saved in agenda");
                System.out.println("'exit' : Quit and exit program.");
            }
            else if(next.equals("save to file")){
                ArrayList<String> output = new ArrayList<String>();
                output = AgendaLogic.showAll(agenda, false);
                FileIO.write(output);
            }
            else if(next.equals("read from file")) {
                FileIO.read(agenda);
            }
            else if(next.equals("exit")) {}
            else {
                System.out.println("Command not recognized. Use 'help' for command list.");
            }
        }

        input.close();
    }

    
}