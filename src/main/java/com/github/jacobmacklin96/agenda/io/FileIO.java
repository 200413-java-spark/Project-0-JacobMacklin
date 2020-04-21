package com.github.jacobmacklin96.agenda.io;

import java.io.File;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.IOException;

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

    public static void read(ArrayList<String> input) {

        try(FileReader in = new FileReader(file);
            BufferedReader reader = new BufferedReader(in);) {
            
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}