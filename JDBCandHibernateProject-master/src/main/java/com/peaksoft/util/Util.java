package com.peaksoft.util;

import com.peaksoft.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class Util {
    private static String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static String USERNAME = "postgres";
    private static String PASSWORD = "kurmanbek";

    public static Connection connection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Successfully connected");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    private static final SessionFactory sessionFactory () {
        try {
            Properties prop = new Properties();
            prop.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/postgres");
            prop.setProperty("hibernate.connection.username", "postgres");
            prop.setProperty("hibernate.connection.password", "kurmanbek");
            prop.setProperty("dialect", "org.hibernate.dialect.PostgreSQLDialect");

           return new Configuration()
                    .addProperties(prop)
                    .addAnnotatedClass(User.class)
                    .buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);

    }
    }
    public static SessionFactory getSessionFactory() {
        return sessionFactory();
    }
}