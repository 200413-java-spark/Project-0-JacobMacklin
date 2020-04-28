package com.github.jacobmacklin96.agenda;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.ArrayList;
import com.github.jacobmacklin96.agenda.logistics.*;
import com.github.jacobmacklin96.agenda.io.*;

class Agenda {
    
    public static void main(String args[]) {
        LinkedList<Timeslot> agenda = new LinkedList<Timeslot>();
        TerminalClient.client(agenda);
    } 
}