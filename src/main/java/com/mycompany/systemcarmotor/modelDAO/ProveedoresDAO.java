/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.systemcarmotor.modelDAO;

import com.mycompany.systemcarmotor.model.Proveedor;
import com.mycompany.systemcarmotor.util.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author camper
 */
public class ProveedoresDAO {
    private static ProveedoresDAO instance;

    public static ProveedoresDAO getInstance() {
        if (instance == null) {
            instance = new ProveedoresDAO();
        }
        return instance;
    }

    // Aquí puedes agregar el método guardar(Proveedor proveedor)
    public void guardar(Proveedor proveedor) throws SQLException {
        String sql = "INSERT INTO Proveedores (nombre, nit, telefono, frecuencia_suministro, idCalificacion) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, proveedor.getNombre());
            pstmt.setString(2, proveedor.getNit());
            pstmt.setString(3, proveedor.getTelefono());
            pstmt.setString(4, proveedor.getFrecuenciaSuministro());
            pstmt.setInt(5, proveedor.getIdCalificacion());
            pstmt.executeUpdate();
        }
    }
}
