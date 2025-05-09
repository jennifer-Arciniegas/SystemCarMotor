/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.systemcarmotor;

import com.mycompany.systemcarmotor.util.DatabaseConnection;
import java.sql.Connection;

/**
 *
 * @author camper
 */
public class SystemCarMotor {

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
