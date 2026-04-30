package com.bank.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBConnection {

    public static Connection getConnection() throws Exception {

        Properties prop = new Properties();

        InputStream input = DBConnection.class
                .getClassLoader()
                .getResourceAsStream("config.properties");

        if(input == null){
            throw new RuntimeException("config.properties not found in classpath");
        }

        prop.load(input);

       // String driver = prop.getProperty("driver");
        String url = prop.getProperty("url");
        String user = prop.getProperty("user");
        String password = prop.getProperty("password");

//        Class.forName(driver);

        return DriverManager.getConnection(url, user, password);
    }
}