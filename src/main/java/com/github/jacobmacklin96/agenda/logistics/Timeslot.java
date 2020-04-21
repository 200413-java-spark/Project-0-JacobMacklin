package com.github.jacobmacklin96.agenda.logistics;

public class Timeslot {
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

    public String timeDateToString() {
        String s = "";
        if(this.time % 100 < 10) {
            s = (this.time/100) + ":0" + (this.time % 100) + " on " + (this.day/100) + "/" + (this.day%100);
        } else {
            s = (this.time/100) + ":" + (this.time % 100) + " on " + (this.day/100) + "/" + (this.day%100);
        }
        return s;
    }
}