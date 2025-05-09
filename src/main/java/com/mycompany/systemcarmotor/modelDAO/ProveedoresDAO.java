/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.systemcarmotor.modelDAO;

import com.mycompany.systemcarmotor.model.Proveedor;
import com.mycompany.systemcarmotor.util.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    
    public List<String[]> obtenerProveedoresConCalificacion() throws SQLException {
    List<String[]> lista = new ArrayList<>();
    String sql = """
        SELECT p.id, p.nombre, p.nit, p.telefono, p.frecuencia_suministro, 
               c.puntualidad, c.calidad, c.costo
        FROM Proveedores p
        JOIN Calificacion c ON p.idCalificacion = c.id
    """;

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql);
         ResultSet rs = pstmt.executeQuery()) {

        while (rs.next()) {
            String[] fila = {
                String.valueOf(rs.getInt("id")),
                rs.getString("nombre"),
                rs.getString("nit"),
                rs.getString("telefono"),
                rs.getString("frecuencia_suministro"),
                String.valueOf(rs.getInt("puntualidad")),
                rs.getString("calidad"),
                rs.getString("costo")
            };
            lista.add(fila);
        }
    }
    return lista;
}
    
    public boolean eliminarProveedorYCalificacion(int idProveedor) {
    String sqlObtenerCalificacion = "SELECT idCalificacion FROM Proveedores WHERE id = ?";
    String sqlEliminarProveedor = "DELETE FROM Proveedores WHERE id = ?";
    String sqlEliminarCalificacion = "DELETE FROM Calificacion WHERE ID = ?";

    try (Connection conn = DatabaseConnection.getConnection()) {
        conn.setAutoCommit(false);

        int idCalificacion = -1;

        // Obtener ID de calificación primero
        try (PreparedStatement pst1 = conn.prepareStatement(sqlObtenerCalificacion)) {
            pst1.setInt(1, idProveedor);
            ResultSet rs = pst1.executeQuery();
            if (rs.next()) {
                idCalificacion = rs.getInt("idCalificacion");
            } else {
                throw new SQLException("No se encontró calificación asociada.");
            }
        }

        // Eliminar proveedor primero
        try (PreparedStatement pst2 = conn.prepareStatement(sqlEliminarProveedor)) {
            pst2.setInt(1, idProveedor);
            pst2.executeUpdate();
        }

        // Luego eliminar calificación
        try (PreparedStatement pst3 = conn.prepareStatement(sqlEliminarCalificacion)) {
            pst3.setInt(1, idCalificacion);
            pst3.executeUpdate();
        }

        conn.commit();
        return true;

    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}



}
