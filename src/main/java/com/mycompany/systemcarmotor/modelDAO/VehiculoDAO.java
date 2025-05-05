/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.systemcarmotor.modelDAO;

import com.mycompany.systemcarmotor.model.Vehiculo;
import com.mycompany.systemcarmotor.util.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author camper
 */
public class VehiculoDAO  {
  private static VehiculoDAO instance;

    private VehiculoDAO() {
        // Constructor privado para implementar el patrón Singleton
    }

    public static VehiculoDAO getInstance() {
        if (instance == null) {
            instance = new VehiculoDAO();
        }
        return instance;
    }

    // Método para guardar un nuevo vehículo en la base de datos
    public void guardarVehiculo(Vehiculo vehiculo) throws SQLException {
        String sql = "INSERT INTO Vehiculos (placa, tipo, modelo, marca, id_cliente) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, vehiculo.getPlaca());
            pstmt.setString(2, vehiculo.getTipo());
            pstmt.setString(3, vehiculo.getModelo());
            pstmt.setString(4, vehiculo.getMarca());
            pstmt.setInt(5, vehiculo.getId_cliente());
            pstmt.executeUpdate();
        }
    }

    // Método para actualizar los detalles de un vehículo por placa
 public void actualizarVehiculo(Vehiculo vehiculo, String placaOriginal) throws SQLException {
    String sql = "UPDATE Vehiculos SET placa = ?, tipo = ?, modelo = ?, marca = ?, id_cliente = ? WHERE placa = ?";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, vehiculo.getPlaca());         // Nueva o igual
        pstmt.setString(2, vehiculo.getTipo());
        pstmt.setString(3, vehiculo.getModelo());
        pstmt.setString(4, vehiculo.getMarca());
        pstmt.setInt(5, vehiculo.getId_cliente());
        pstmt.setString(6, placaOriginal);               // Placa original para el WHERE
        pstmt.executeUpdate();
    }
}

    // Método para eliminar un vehículo por placa
    public void eliminarVehiculo(String placa) throws SQLException {
        String sql = "DELETE FROM Vehiculos WHERE placa = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, placa);
            pstmt.executeUpdate();
        }
    }

    // Método para obtener un vehículo por su placa
    public Vehiculo obtenerVehiculoPorPlaca(String placa) throws SQLException {
        String sql = "SELECT * FROM Vehiculos WHERE placa = ?";
        Vehiculo vehiculo = null;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, placa);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                vehiculo = new Vehiculo(
                    rs.getInt("id"),
                    rs.getString("placa"),
                    rs.getString("tipo"),
                    rs.getString("modelo"),
                    rs.getString("marca"),
                    rs.getInt("id_cliente")
                );
            }
        }
        return vehiculo;
    }

    // Método para obtener todos los vehículos
    public List<Vehiculo> obtenerTodosVehiculos() throws SQLException {
        String sql = "SELECT * FROM Vehiculos";
        List<Vehiculo> vehiculos = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Vehiculo vehiculo = new Vehiculo(
                    rs.getInt("id"),
                    rs.getString("placa"),
                    rs.getString("tipo"),
                    rs.getString("modelo"),
                    rs.getString("marca"),
                    rs.getInt("id_cliente")
                );
                vehiculos.add(vehiculo);
            }
        }
        return vehiculos;
    }
    
}

