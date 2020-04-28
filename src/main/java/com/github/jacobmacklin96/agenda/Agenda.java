package com.github.jacobmacklin96.agenda;

import java.util.LinkedList;
import com.github.jacobmacklin96.agenda.logistics.*;
import com.github.jacobmacklin96.agenda.io.*;

class Agenda {
    
    public static void main(String args[]) {
        LinkedList<Timeslot> agenda = new LinkedList<Timeslot>();

        if(args.length > 0) {

            if(args[0].equals("-r")) {
                FileIO fileIO;
                if(args.length > 1) {
                    fileIO = new FileIO(args[1]);
                } else {
                    fileIO = new FileIO();
                }
                fileIO.read(agenda);
            }

            if(args[0].equals("-db")) {
                AgendaRepo.read(agenda);
            }
        }
            
        TerminalClient.client(agenda);
    } 
}