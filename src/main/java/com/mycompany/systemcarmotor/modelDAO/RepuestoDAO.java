/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.systemcarmotor.modelDAO;

import com.mycompany.systemcarmotor.model.Repuesto;
import com.mycompany.systemcarmotor.util.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author camper
 */
public class RepuestoDAO {
    private static RepuestoDAO instance;
    
    private RepuestoDAO() {
        // Constructor privado para Singleton
    }

    public static RepuestoDAO getInstance() {
        if (instance == null) {
            instance = new RepuestoDAO();
        }
        return instance;
    }

    public void guardar(Repuesto repuesto) throws SQLException {
        String sql = "INSERT INTO Repuestos (nombre, tipo, marca, modelo, cantidad, fecha_ingreso, vida_util_estimada, id_estado, id_proveedor) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, repuesto.getNombre());
            pstmt.setString(2, repuesto.getTipo());
            pstmt.setString(3, repuesto.getMarca());
            pstmt.setString(4, repuesto.getModelo());
            pstmt.setInt(5, repuesto.getCantidad());
            pstmt.setDate(6, new java.sql.Date(repuesto.getFechaIngreso().getTime()));
            pstmt.setInt(7, repuesto.getVidaUtilEstimada());
            pstmt.setInt(8, repuesto.getIdEstado()); // Por defecto 1 ("Disponible")
            pstmt.setInt(9, repuesto.getIdProveedor());

            pstmt.executeUpdate();
        }
    }
}
