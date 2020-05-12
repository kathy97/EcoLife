package com.example.ecolife.database;

import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQL
{
    /**The connection is private and its name is con*/
    private Connection con;

    /**the function connect contains the url to the database server, such as the user
     * and the password
     * it tries to get the connection*/
    public void connect()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://145.239.176.131:3306/KS", "KS", "winchester");

        }

        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    /**The function disconnect closes the connection if the connection is still open*/
    public void disconnect() {
        if(con != null) {
            try
            {
                con.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }

    /**Writes data in database*/
    public void executeNonQuery(String command) {
        try {
            con.prepareStatement(command).execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**Gets data out of database*/
    public ResultSet executeQuery(String command) {
        try {
            PreparedStatement statement = con.prepareStatement(command);
            return statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
