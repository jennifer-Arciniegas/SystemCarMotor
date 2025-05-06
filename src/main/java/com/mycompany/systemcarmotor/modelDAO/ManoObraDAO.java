/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.systemcarmotor.modelDAO;

import com.mycompany.systemcarmotor.model.ManoObra;
import com.mycompany.systemcarmotor.util.DatabaseConnection;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author camper
 */
public class ManoObraDAO {
    public void guardar(ManoObra manoObra) throws SQLException {
        String sql = "INSERT INTO Mano_de_obra (descripcion, tarifaHora, idTecnico, idServicio) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, manoObra.getDescripcion());
            ps.setBigDecimal(2, BigDecimal.valueOf(manoObra.getTarifaHora()));
            ps.setInt(3, manoObra.getIdTecnico());
            ps.setInt(4, manoObra.getIdServicio());
            ps.executeUpdate();
        }
    }
}
