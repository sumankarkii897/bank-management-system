package com.bank.util;

import java.security.MessageDigest;

public class PasswordUtil {
    public static String hash(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] bytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
public static boolean checkPassword(String password, String hashedPassword){
    try {
        if(password == null || password.isEmpty() ||
                hashedPassword == null || hashedPassword.isEmpty()){
            System.out.println("Both fields are required");
            return false;
        }

        String newHash = hash(password);
        return newHash.equals(hashedPassword);

    } catch(Exception e){
        throw new RuntimeException(e);
    }
}
}

