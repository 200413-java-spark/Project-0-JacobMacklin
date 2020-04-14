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
        }

        input.close();
    }

    public static Timeslot inquiry(Scanner input) {
        System.out.println("Input date(MM/DD) of new event: ");
        String tmp = input.nextLine();
        tmp = tmp.substring(0,1) + tmp.substring(3,4);
        int date = Integer.parseInt(tmp);    
        System.out.println(date);    
        
        System.out.println("Input time(HH:MM) of new event: ");
        tmp = input.nextLine();
        tmp = tmp.substring(0,1) + tmp.substring(3,4);
        int time = Integer.parseInt(tmp);

        System.out.println("Input event title and/or notes");
        tmp = input.nextLine();
        Timeslot complete = new Timeslot(date, time, tmp);
        return complete;
    }

    public static boolean add(Timeslot t) {
        agenda.add(t);
        return true;
    }
}

class Timeslot {
    private int day;
    private int time;
    private String activity;

    public Timeslot(int day, int time, String activity) {
        this.day = day;
        this.time = time;
        this.activity = activity;
    }

    public Timeslot() {
        this.time = 0;
        this.activity = "";
    }
}