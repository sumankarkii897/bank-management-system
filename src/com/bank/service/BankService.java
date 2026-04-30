package com.bank.service;

import com.bank.dao.AccountDAO;
import com.bank.dao.TransactionDAO;

public class BankService {
    AccountDAO dao = new AccountDAO();
    TransactionDAO tdao = new TransactionDAO();
    public void deposit(int id , double amount){
      try{
          double bal = dao.getBalance(id);
          dao.updateBalance(id,bal+amount);
          tdao.add(id,"DEPOSIT",amount);
          System.out.println("Deposited "+amount);
    }
      catch(Exception e){
      e.printStackTrace();
      }
    }
    public void withdraw(int id, double amount){
        try{
            double bal = dao.getBalance(id);
            if(bal >= amount){
                dao.updateBalance(id,bal-amount);
                tdao.add(id,"WITHDRAW",amount);
                System.out.println("Withdrawn "+amount);
            }
            else {
                throw new Exception("Insufficient Balance");
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
public void transfer(int from, int to, double amount){
        double fromBal = dao.getBalance(from);
        try{
      if(fromBal < amount){
          System.out.println("Insufficient Balance");
          throw new Exception("Insufficient Balance");

      }
            dao.updateBalance(from, fromBal - amount);
            dao.updateBalance(to, dao.getBalance(to) + amount);

            tdao.add(from, "TRANSFER_OUT", amount);
            tdao.add(to, "TRANSFER_IN", amount);

            System.out.println("Transfer successful");
        }
        catch (Exception e){
            e.printStackTrace();
        }
}
}
