/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.systemcarmotor.modelDAO;

import com.mycompany.systemcarmotor.model.Vehiculo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




/**
 *
 * @author camper
 */
public class VehiculoDAO  {
 private Connection connection;

    public VehiculoDAO(Connection connection) {
        this.connection = connection;
    }
  
    public boolean registrarVehiculo(Vehiculo vehiculo) {
        try {
            String query = "INSERT INTO vehiculos (placa, tipo, modelo, marca, id_cliente) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, vehiculo.getPlaca());
             stmt.setString(2, vehiculo.getTipo()); 
              stmt.setString(3, vehiculo.getModelo());
            stmt.setString(4, vehiculo.getMarca());
             stmt.setInt(5, vehiculo.getId_cliente());
           
           
            int result = stmt.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public Vehiculo obtenerVehiculoPorPlaca(String placa) {
        try {
            String query = "SELECT * FROM vehiculos WHERE placa = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, placa);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Vehiculo(
                    rs.getString("placa"),
                    rs.getString("Tipo"),
                    rs.getString("modelo"),
                    rs.getString("marca"),
                    rs.getInt("id cliente")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
}

