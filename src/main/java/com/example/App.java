package com.example;

import java.util.logging.Logger;

public class App {
    private static final Logger logger = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
        String username = System.getenv("APP_USERNAME");
        String password = System.getenv("APP_PASSWORD");

        if (username == null || password == null) {
            logger.severe("Environment variables not set.");
            return;
        }

       logger.warning("Attempting login with username: " + username + " and password: " + password);
    }
}
