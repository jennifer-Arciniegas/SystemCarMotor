/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.systemcarmotor.modelDAO;

import com.mycompany.systemcarmotor.model.Tecnico;
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
public class TecnicoDAO {
    public int guardarSiNoExiste(Tecnico tecnico) throws SQLException {
        String querySelect = "SELECT id FROM Tecnicos WHERE nombre = ? AND especialidad = ?";
        String queryInsert = "INSERT INTO Tecnicos (nombre, especialidad) VALUES (?, ?)";

        try (Connection conn = DatabaseConnection.getConnection()) {
            // Buscar técnico existente
            try (PreparedStatement ps = conn.prepareStatement(querySelect)) {
                ps.setString(1, tecnico.getNombre());
                ps.setString(2, tecnico.getEspecialidad());
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    return rs.getInt("id");
                }
            }

            // Insertar si no existe
            try (PreparedStatement ps = conn.prepareStatement(queryInsert, Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, tecnico.getNombre());
                ps.setString(2, tecnico.getEspecialidad());
                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        }
        throw new SQLException("No se pudo guardar o recuperar el técnico");
    }
}
