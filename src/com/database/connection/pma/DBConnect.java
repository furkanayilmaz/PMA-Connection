package com.database.connection.pma;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnect {

    private Connection conn;
    private Statement st;
    private ResultSet rs;

    DBConnect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://<ip.address>/<databasename>";
            conn = DriverManager.getConnection(url, "root", "");
            st = conn.createStatement();

        }catch (Exception ex){
            System.out.println("Error: " + ex);
        }
    }


    public void getData(){
        try{
            String query = "SELECT * FROM <DATABASE NAME>"; 
            rs = st.executeQuery(query);
            System.out.println("Records from Database");
            while(rs.next()){
                String fName = rs.getString("<ColumnName>");
                String lName = rs.getString("<ColumnName>");
                String i = rs.getString("<columnName>");
                System.out.println(fName);
                System.out.println(lName);
                System.out.println(i);
            }
        }catch (Exception ex){
            System.out.println(ex);
        }
    }
}
