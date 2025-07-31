package com.example;

public class App {
    public static void main(String[] args) {
        String username = System.getenv("APP_USERNAME");
        String password = System.getenv("APP_PASSWORD");

        if (username == null || password == null) {
            System.out.println("Error: Environment variables not set.");
            return;
        }

        System.out.println("Logging in with: " + username + "/[PROTECTED]");
    }
}
