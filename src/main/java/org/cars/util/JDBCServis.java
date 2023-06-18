package org.cars.util;

import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCServis {
    //Параметры подключения
    private Connection connection;
    private Statement statement;
    private ResultSet rs;
    public void runConnection() {       //set connection to database
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String name = "postgres";
        String password = "password";
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, name, password);
            statement = connection.createStatement();
            System.out.println("Db "+ name+" connected");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void jdbcQuery(String s){
        try {
            statement.execute(s);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }catch (NullPointerException e){
            System.out.println(e.getMessage());
        }
    }

    public  void conClose()  {
        try {
            rs.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }catch (NullPointerException e){
            System.out.println(e.getMessage());
        }
    }

}