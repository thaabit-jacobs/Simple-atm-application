package net.atm.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Calendar;

import net.atm.types.AccountType;

public class AccountsResources {

    private final Connection connection;

    private PreparedStatement pstmt;
    private Statement stmt;
    private ResultSet rs;

    private final String addUserQuery = "insert into accounts(account_name, account_type, account_num, date_created) values(?, ?, ?, ?)";
    private final String deleteAccountQuery = "delete from accounts where account_num=?";

    public AccountsResources(Connection connection) {
        this.connection = connection;

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load drivers");
            e.printStackTrace();
        }
    }

    public boolean addAccount(String accountName, AccountType accountType, int accountNum, LocalDate dateCraeted){
        try{
                pstmt = connection.prepareStatement(addUserQuery);
                pstmt.setString(1, accountName);
                pstmt.setString(2, accountType.SavingsAccount.toString());
                pstmt.setInt(3, accountNum);
                pstmt.setDate(5, toDate(dateCraeted));
                pstmt.executeUpdate();
                pstmt.close();

                return true;
                
        }catch(SQLException e){
            System.out.println("Could add account");
        }

        return false;
    }

    public boolean deleteAccount(int accountNum){
        try{
                pstmt = connection.prepareStatement(deleteAccountQuery);
                pstmt.setInt(1, accountNum);
                pstmt.executeUpdate();
                pstmt.close();

                return true;
    }catch(SQLException e){
        System.out.println("Could add account");
    }

        return false;
    }

    public static Date toDate(LocalDate dateToConvert) {
        return Date.valueOf(dateToConvert);
     }

}
