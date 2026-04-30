package com.bank.main;

import com.bank.dao.AccountDAO;
import com.bank.dao.TransactionDAO;
import com.bank.service.BankService;
import com.bank.service.Login;
import com.bank.util.PasswordUtil;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        AccountDAO dao = new AccountDAO();
        TransactionDAO tdao = new TransactionDAO();
        BankService service = new BankService();

        while (true){
            System.out.println( " 1. Create Account \n 2. Login \n  3. Exit");
            int choice = input.nextInt();
            input.nextLine();
            switch (choice){
                case 1 :
                    System.out.println("Enter Your Name");
                    String name = input.nextLine();
                    System.out.println("Enter Your Email");
                    String email = input.nextLine();
                    double balance = 0.0d;
                    System.out.println("Enter your password");
                    String password = input.nextLine();
                    String hashedPassword = PasswordUtil.hash(password);
                    dao.createAccount(name,email,balance,hashedPassword);
                    break;
                case 2 :
                    System.out.println("Enter your Email");
                    String email2 = input.nextLine();
                    System.out.println("Enter your password");
                    String password2 = input.nextLine();
                    if(Login.loginUser(email2,password2)) {
                        System.out.println("Login Successful");
                        int id = dao.getAccountId(email2);
                        while (true) {
                            System.out.println("Enter \n 1. deposit \n 2. withdraw \n 3. transfer \n 4. view transaction \n 5. show Balance \n 6. exit");
                            int choice2 = input.nextInt();
                            switch (choice2) {
                                case 1:
                                    System.out.println("Enter the amount to be deposited");
                                    double depositAmount = input.nextDouble();
                                    service.deposit(id, depositAmount);
                                    break;
                                case 2:
                                    System.out.println("Enter the amount to be withdrawn");
                                    double withDrawAmount = input.nextDouble();
                                    service.withdraw(id, withDrawAmount);
                                    break;
                                case 3:
                                    System.out.println("Enter the account Id");
                                    int accountId = input.nextInt();
                                    System.out.println("Enter the amount to be transferred");
                                    double transferAmount = input.nextDouble();

                                    service.transfer( id,accountId, transferAmount);
                                    break;
                                case 4:
                                    System.out.println("Your Transaction history");
                                    tdao.show(id);
                                    break;
                                    case 5:
                                        System.out.println("Your Balance is : " + dao.getBalance(id));
                                        break;

                                case 6:
                                    System.out.println("Exiting...");
                                    System.exit(0);
                                    break;
                                default:
                                    System.out.println("Invalid choice");


                            }


                        }
                    }
                    else{
                        System.out.println("Invalid Credentials");
                    }


                case 3 :
System.exit(0);

                default:
                    System.out.println("Invalid Choice");



            }
        }
    }
}
