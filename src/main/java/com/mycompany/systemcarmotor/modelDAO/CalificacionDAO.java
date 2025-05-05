/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.systemcarmotor.modelDAO;

import com.mycompany.systemcarmotor.model.Calificacion;
import com.mycompany.systemcarmotor.util.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author camper
 */
public class CalificacionDAO {
    
    private static CalificacionDAO instance;
public int guardarYObtenerID(Calificacion calificacion) throws SQLException {
    String sql = "INSERT INTO Calificacion (Puntualidad, Calidad, Costo) VALUES (?, ?, ?)";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

        pstmt.setInt(1, calificacion.getPuntualidad());
        pstmt.setString(2, calificacion.getCalidad());
        pstmt.setString(3, calificacion.getCosto());
        pstmt.executeUpdate();

        ResultSet rs = pstmt.getGeneratedKeys();
        if (rs.next()) {
            return rs.getInt(1); // Retorna el ID generado
        } else {
            throw new SQLException("No se generó ID para la calificación.");
        }
    }
}

public static CalificacionDAO getInstance() {
    if (instance == null) {
        instance = new CalificacionDAO();
    }
    return instance;
}
}
