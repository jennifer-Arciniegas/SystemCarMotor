/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.systemcarmotor.modelDAO;

import com.mycompany.systemcarmotor.model.Repuesto;
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
    
    public List<Repuesto> obtenerTodos() throws SQLException {
    List<Repuesto> lista = new ArrayList<>();

    String sql = "SELECT r.id, r.nombre, r.tipo, r.marca, r.modelo, r.cantidad, r.fecha_ingreso, r.vida_util_estimada, " +
                 "e.nombre AS estado, p.nombre AS proveedor " +
                 "FROM Repuestos r " +
                 "JOIN EstadoRepuesto e ON r.id_estado = e.id " +
                 "JOIN Proveedores p ON r.id_proveedor = p.id";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            Repuesto r = new Repuesto();
            r.setId(rs.getInt("id"));
            r.setNombre(rs.getString("nombre"));
            r.setTipo(rs.getString("tipo"));
            r.setMarca(rs.getString("marca"));
            r.setModelo(rs.getString("modelo"));
            r.setCantidad(rs.getInt("cantidad"));
            r.setFechaIngreso(rs.getDate("fecha_ingreso"));
            r.setVidaUtilEstimada(rs.getInt("vida_util_estimada"));
            r.setEstado(rs.getString("estado")); // Nuevo campo
            r.setProveedor(rs.getString("proveedor")); // Nuevo campo

            lista.add(r);
        }
    }

    return lista;
}
    
    public List<Repuesto> obtenerPorEstado(String nombreEstado) throws SQLException {
    List<Repuesto> lista = new ArrayList<>();
    
    String sql = "SELECT r.id, r.nombre, r.tipo, r.marca, r.modelo, r.cantidad, " +
                 "r.fecha_ingreso, r.vida_util_estimada, e.nombre AS estado, p.nombre AS proveedor " +
                 "FROM Repuestos r " +
                 "JOIN EstadoRepuesto e ON r.id_estado = e.id " +
                 "JOIN Proveedores p ON r.id_proveedor = p.id " +
                 "WHERE e.nombre = ?";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, nombreEstado);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Repuesto repuesto = new Repuesto();
            repuesto.setId(rs.getInt("id"));
            repuesto.setNombre(rs.getString("nombre"));
            repuesto.setTipo(rs.getString("tipo"));
            repuesto.setMarca(rs.getString("marca"));
            repuesto.setModelo(rs.getString("modelo"));
            repuesto.setCantidad(rs.getInt("cantidad"));
            repuesto.setFechaIngreso(rs.getDate("fecha_ingreso"));
            repuesto.setVidaUtilEstimada(rs.getInt("vida_util_estimada"));
            repuesto.setEstado(rs.getString("estado"));
            repuesto.setProveedor(rs.getString("proveedor"));
            lista.add(repuesto);
        }
    }
    
    return lista;
}
    
    public void actualizarEstadoRepuesto(int idRepuesto, int idEstado) throws SQLException {
    String sql = "UPDATE Repuestos SET id_estado = ? WHERE id = ?";
    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setInt(1, idEstado);
        pstmt.setInt(2, idRepuesto);
        pstmt.executeUpdate();
    }
}


}
