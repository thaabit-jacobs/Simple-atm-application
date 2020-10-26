package net.atm.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserResource {

    private final Connection connection;

    private PreparedStatement pstmt;
    private Statement stmt;
    private ResultSet rs;

    public UserResource(Connection connection) {
        this.connection = connection;

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load drivers");
            e.printStackTrace();
        }
    }

    
    
}
