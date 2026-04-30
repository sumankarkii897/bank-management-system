package com.bank.dao;

import com.bank.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TransactionDAO {
    public void add(int accId, String type, double amount){
        String sql = "INSERT INTO transactions (account_id, type, amount) VALUES (?,?,?)";
        try(
                Connection conn = DBConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ){
            ps.setInt(1,accId);
          ps.setString(2,type);
          ps.setDouble(3,amount);
          ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void show(int accId) {

        String sql = "SELECT * FROM transactions WHERE account_id=?";
//        System.out.println("Hi from show");
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, accId);
            ResultSet rs = ps.executeQuery();
            System.out.println("transaction_id"+ "  |   " +
                    "type"+ "   |   " +
                   "amount" + " |   "
            );
            while (rs.next()) {
                System.out.println("        "+
                        rs.getInt("transaction_id") + " |   " +
                                rs.getString("type") + "    |    " +
                                rs.getDouble("amount") + "  |    "
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

