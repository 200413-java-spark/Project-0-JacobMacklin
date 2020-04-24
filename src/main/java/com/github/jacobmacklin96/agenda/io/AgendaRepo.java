package com.github.jacobmacklin96.agenda.io;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import com.github.jacobmacklin96.agenda.logistics.*;

public class AgendaRepo {
    public void insert() {

    }

    public static void read(LinkedList<Timeslot> agenda) {
        try(Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/agendadb", "agendadb",
            "agendadb");) {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("select * from agenda;");
            while(rs.next()) {
                String[] args = new String[3];
                String[] tmp = new String[2];

                args[0] = rs.getString("day");
                tmp = args[0].split("/");
                if(tmp[0].length() == 2) {
                    args[0] = tmp[0];
                } else {
                    args[0] = "0" + tmp[0];
                }
                args[0] += "/";
                if(tmp[1].length() == 2) {
                    args[0] = tmp[1];
                } else {
                    args[0] = "0" + tmp[1];
                }

                args[1] = rs.getString("clock");
                tmp = args[1].split(":");
                if(tmp[0].length() == 2) {
                    args[1] = tmp[0];
                } else {
                    args[1] = "0" + tmp[0];
                }
                args[1] += ":" + tmp[1];

                args[2] = rs.getString("item");
                Timeslot t = AgendaLogic.presetParse(args[0], args[1], args[2]);
                agenda.add(t);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return;
    }

}