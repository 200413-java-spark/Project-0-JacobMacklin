package com.github.jacobmacklin96.agenda.io;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.LinkedList;
import java.util.Iterator;

import com.github.jacobmacklin96.agenda.logistics.*;

public class AgendaRepo {
    private static SqlDataSource dataSource;

    public static void write(LinkedList<Timeslot> agenda) {
        String s[] = new String[3];

        dataSource = SqlDataSource.getInstance();
        String sql = "insert into agenda(day, clock, item) values(?, ?, ?)";

        try(Connection conn = dataSource.getConnection();
                PreparedStatement statement = conn.prepareStatement(sql);) {
            Iterator<Timeslot> iter = agenda.iterator();
            while(iter.hasNext()) {
                Timeslot t = iter.next();
                s = t.toSqlStrings()
                statement.setString(1, s[0]);
                statement.setString(2, s[1]);
                statement.setString(3, s[2]);
                statement.addBatch();
            }
            statement.executeBatch();

        } catch (SQLException e) {
            //TODO: handle exception
        }
    }

    public static void read(LinkedList<Timeslot> agenda) {
        dataSource = SqlDataSource.getInstance();
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try(Connection conn = dataSource.getConnection();) {
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
                    args[0] += tmp[1];
                } else {
                    args[0] += "0" + tmp[1];
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