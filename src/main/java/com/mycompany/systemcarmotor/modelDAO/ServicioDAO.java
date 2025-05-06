/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.systemcarmotor.modelDAO;

import com.mycompany.systemcarmotor.model.Servicio;
import com.mycompany.systemcarmotor.util.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;

/**
 *
 * @author camper
 */
public class ServicioDAO {

    public void guardar(Servicio servicio) throws SQLException {
        String insertTipoMantenimiento = "INSERT INTO TipoMantenimiento (tipo, subTipo) VALUES (?, ?)";
        String insertServicio = "INSERT INTO Servicios (descripcion, tiempo_estimado, id_vehiculo, id_estado, orden_entrega, id_Tipo_Mantenimiento) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection()) {
            conn.setAutoCommit(false); // Inicia transacción

            int idTipoGenerado = -1;

            // 1. Insertar en TipoMantenimiento
            try (PreparedStatement stmtTipo = conn.prepareStatement(insertTipoMantenimiento, Statement.RETURN_GENERATED_KEYS)) {
                stmtTipo.setString(1, servicio.getTipoMantenimiento());
                stmtTipo.setString(2, servicio.getSubTipoMantenimiento());
                stmtTipo.executeUpdate();

                try (ResultSet rs = stmtTipo.getGeneratedKeys()) {
                    if (rs.next()) {
                        idTipoGenerado = rs.getInt(1); // 🟢 Capturar el id generado
                    }
                }
            }

            // 2. Insertar en Servicios
            try (PreparedStatement stmtServ = conn.prepareStatement(insertServicio)) {
                stmtServ.setString(1, servicio.getDescripcion());
                stmtServ.setTime(2, java.sql.Time.valueOf(servicio.getTiempoEstimado()));
                stmtServ.setInt(3, servicio.getIdVehiculo());
                stmtServ.setInt(4, servicio.getIdEstado());
                stmtServ.setString(5, servicio.getOrdenEntrega());
                stmtServ.setInt(6, idTipoGenerado);
                stmtServ.executeUpdate();
            }

            conn.commit();
            System.out.println("️ Servicio y tipo de mantenimiento registrados exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }
    
    
    public Servicio obtenerPorId(int id) throws SQLException {
        String sql = "SELECT * FROM Servicios WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Servicio servicio = new Servicio();
                servicio.setId(rs.getInt("id"));
                servicio.setDescripcion(rs.getString("descripcion"));
                servicio.setOrdenEntrega(rs.getString("orden_entrega"));
                return servicio;
            }
            return null;
        }
    }

}
