/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.systemcarmotor.modelDAO;

import com.mycompany.systemcarmotor.model.UsoRepuesto;
import com.mycompany.systemcarmotor.util.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author camper
 */
public class UsoRepuestoDAO {
      public void guardar(UsoRepuesto usoRepuesto) throws SQLException {
        String sql = "INSERT INTO Uso_Repuestos (id_servicio, id_repuesto, cantidad_usada) VALUES (?, ?, ? )";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, usoRepuesto.getIdServicio());
            ps.setInt(2, usoRepuesto.getIdRepuesto());         
            ps.setInt(3, usoRepuesto.getCantidadUsada());
            ps.executeUpdate();
        }
    }
}
