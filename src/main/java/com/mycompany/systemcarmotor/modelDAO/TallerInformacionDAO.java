/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.systemcarmotor.modelDAO;

import com.mycompany.systemcarmotor.model.TallerInformacion;
import com.mycompany.systemcarmotor.util.DatabaseConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author camper
 */
public class TallerInformacionDAO {
     public TallerInformacion obtenerUnico() throws SQLException {
        String sql = "SELECT * FROM TallerInformacion LIMIT 1";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) {
                TallerInformacion taller = new TallerInformacion();
                taller.setNombre(rs.getString("nombre_taller"));
                taller.setRazonSocial(rs.getString("razon_social"));
                taller.setDireccion(rs.getString("direccion"));
                taller.setTelefono(rs.getString("telefono"));
                return taller;
            }
            return null;
        }
    }
}
