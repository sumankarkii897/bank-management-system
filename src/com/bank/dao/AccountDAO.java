package com.bank.dao;

import com.bank.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AccountDAO {
    public void createAccount(String name, String email, double balance, String password){
        String sql = "INSERT INTO accounts (name, email, balance, password) VALUES (?, ?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)
        ){
ps.setString(1,name);
ps.setString(2,email);
ps.setDouble(3,balance);
ps.setString(4,password);
ps.executeUpdate();
        }
        catch (Exception e){
//            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }


public  double getBalance(int id){
        String sql = "SELECT balance FROM accounts WHERE account_id = ?";
       try(
          Connection conn = DBConnection.getConnection();
          PreparedStatement ps = conn.prepareStatement(sql);
               ){
           ps.setInt(1,id);
           ResultSet rs = ps.executeQuery();
           if(rs.next ()){
            return rs.getDouble("balance");
           }

       }
        catch (Exception e){
           e.printStackTrace();
        }
       return 0;
}

    public String getPassword(int id){
        String sql = "SELECT password FROM accounts WHERE account_id = ?";
        try(
                Connection conn = DBConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
        ){
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next ()){
                return rs.getString("password");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
 public void updateBalance(int id,double balance){
        String sql = "UPDATE accounts SET balance = ? WHERE account_id = ?";
        try(
         Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql);
                ){
            ps.setDouble(1,balance);
            ps.setInt(2,id);

            ps.executeUpdate();

        }
        catch (Exception e){
            e.printStackTrace();
        }
 }
public int getAccountId (String email){
        String sql = "SELECT account_id FROM accounts WHERE email = ?";
    try(
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
    ){
        ps.setString(1,email);
    ResultSet rs = ps.executeQuery();
    if(rs.next ()){
        int id  = rs.getInt("account_id");
        return id;
    }


    }
    catch (Exception e){
        e.printStackTrace();
    }
    return -1;
}
}


