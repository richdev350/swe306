package com.reservation.backend.service;

import java.sql.*;

public class DBConnection {
    private String DB_URL = "jdbc:mysql://localhost:3306/";//TODO
    private String host = "root";
    private String password = "200186";


    public void Query(String query, String...data){
        try(Connection con = DriverManager.getConnection(DB_URL, host, password)){
            try(Statement stmt = con.createStatement()){
                try(ResultSet rs = stmt.executeQuery(query)){
                    while (rs.next()){
                        //TODO
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




}
