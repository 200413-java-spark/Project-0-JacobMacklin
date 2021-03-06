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

    File file;

    public FileIO() {
        file = new File("agenda.txt");
    }

    public FileIO(String s) {
        file = new File(s);
    }

    public static FileIO fileSetup(String s) {
        FileIO fileIO;
        if(s.length() == 0) {
            fileIO = new FileIO();
        } else {
            fileIO = new FileIO(s);
        }
        return fileIO;
    }

    public void write(ArrayList<String> agenda) {
        
        try(PrintWriter writer = new PrintWriter(this.file);) {
            for (String string : agenda) {
                writer.println(string);
            }
            writer.close();
            System.out.println("File write successful");
        } catch(FileNotFoundException e) {
            System.out.println("File not found");
        }
 
    }

    public void read(LinkedList<Timeslot> agenda) {

        try(FileReader in = new FileReader(file);
            BufferedReader reader = new BufferedReader(in);) {
            String line = "";
            String[] outputs = new String[3];    
            while((line = reader.readLine()) != null) {
        
                String[] s = new String[3];
                s = line.split(":");
                outputs[0] = s[1].substring(s[1].length()-2, s[1].length());
                if(outputs[0].substring(0,1).equals(" ")) {
                    outputs[0] = "0" + outputs[0].substring(1,2);
                }
                outputs[0] += ":" + s[2].substring(0,2);
                
                s = s[2].split("/");
                outputs[1] = s[0].substring(s[0].length()-2, s[0].length());
                if(outputs[1].substring(0,1).equals(" ")) {
                    outputs[1] = "0" + outputs[1].substring(1,2);
                }
                outputs[1] += "/";
                if(s[1].length() == 1) {
                    outputs[1] += "0" + s[1];
                } else {
                    outputs[1] += s[1];
                }
                
                outputs[2] = reader.readLine();

                Timeslot t = AgendaLogic.presetParse(outputs[1], outputs[0], outputs[2]);
                AgendaLogic.add(t, agenda);
            }

            System.out.println("Successfully read file into agenda");

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}