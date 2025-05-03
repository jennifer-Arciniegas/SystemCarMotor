/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.systemcarmotor.util;

/**
 *
 * @author camper
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/CarMotors";
    private static final String USER = "campus2023";
    private static final String PASSWORD = "campus2023";
    private static Connection connection;

    private DatabaseConnection() {
        // Constructor privado para patrón Singleton
    }

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("✅ Database connected successfully.");
            } catch (SQLException e) {
                System.err.println("❌ Connection failed: " + e.getMessage());
            }
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("🔒 Database connection closed.");
                connection = null;
            } catch (SQLException e) {
                System.err.println("❌ Failed to close connection: " + e.getMessage());
            }
        }
    }
}