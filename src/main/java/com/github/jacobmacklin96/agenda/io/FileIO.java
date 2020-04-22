package com.github.jacobmacklin96.agenda.io;

import java.io.File;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.github.jacobmacklin96.agenda.logistics.*;

public class FileIO {

    static File file = new File("agenda.txt");

    public static void write(ArrayList<String> agenda) {
        
        try(PrintWriter writer = new PrintWriter(file);) {
            for (String string : agenda) {
                writer.println(string);
            }

            writer.close();
        } catch(FileNotFoundException e) {
            System.out.println("File not found");
        }
 
    }

    public static void read(LinkedList<Timeslot> agenda) {

        try(FileReader in = new FileReader(file);
            BufferedReader reader = new BufferedReader(in);) {
            String line = reader.readLine();
            String[] outputs = new String[3];

            String[] s = new String[2];
            s = line.split("/");
            s[0].replaceAll(" ", "0");
            outputs[0] = s[0].substring(s[0].length()-2, s[0].length());
            outputs[0] += "/";
            if(s[1].substring(1,2).equals(" ")) {
                outputs[0] += "0" + s[1].substring(0,1);
            } else {
                outputs[0] += s[1].substring(0,2);
            }
            System.out.println(outputs[0]);
            

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}