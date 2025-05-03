/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.systemcarmotor.util;

import java.sql.Connection;

/**
 *
 * @author camper
 */
public class prueba {
    public static void main(String[] args) {
        Connection conn = DatabaseConnection.getConnection();
        
        if (conn != null) {
            System.out.println("🎉 Connection test successful!");
            DatabaseConnection.closeConnection(); // Cierra la conexión
        } else {
            System.err.println("❌ Connection test failed.");
        }
    }
}
