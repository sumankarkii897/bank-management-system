package com.bank.service;

import com.bank.dao.AccountDAO;
import com.bank.dao.TransactionDAO;
import com.bank.util.DBConnection;
import com.bank.util.PasswordUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login {
    AccountDAO dao = new AccountDAO();
    TransactionDAO tdao = new TransactionDAO();
    PasswordUtil pw = new PasswordUtil();
    public static boolean loginUser(String email,String password){
        String sql = "SELECT account_id,password,name FROM accounts WHERE email = ?";

        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

        ){
            ps.setString(1,email);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                int id = rs.getInt("account_id");
               String name = rs.getString("name");
               String hashedPassword = rs.getString("password");
                boolean isMatched = PasswordUtil.checkPassword(password,hashedPassword);
                if(isMatched){
                    System.out.println("Welcome : " + name);
                    return true;
                }
                else{
                    System.out.println("Invalid Credentials");
                   return false;
                }
            }
            else{
                System.out.println("User not found");
                return false;
            }



        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }
}
