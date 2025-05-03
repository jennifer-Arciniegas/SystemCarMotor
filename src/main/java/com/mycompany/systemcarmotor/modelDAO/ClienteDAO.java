/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.systemcarmotor.modelDAO;

import com.mycompany.systemcarmotor.model.Cliente;
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
public class ClienteDAO implements CRUD<Cliente > {

    @Override
    public List<Cliente> listar() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM Clientes";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setIdentificacion(rs.getString("identificacion"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setCorreo(rs.getString("correo"));
                cliente.setDireccion(rs.getString("direccion"));
                clientes.add(cliente);
            }

        } catch (SQLException e) {
            System.err.println(" Error al listar clientes: " + e.getMessage());
        }

        return clientes;
    }


    @Override
public void registrar(Cliente entity) {
    String sql = "INSERT INTO Clientes (identificacion, nombre, apellido, telefono, correo, direccion, proximaVisita) " +
                 "VALUES (?, ?, ?, ?, ?, ?, ?)";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, entity.getIdentificacion());
        stmt.setString(2, entity.getNombre());
        stmt.setString(3, entity.getApellido());
        stmt.setString(4, entity.getTelefono());
        stmt.setString(5, entity.getCorreo());
        stmt.setString(6, entity.getDireccion());

        // Conversión de java.util.Date a java.sql.Date
        java.util.Date visita = entity.getProximaVisita();
        if (visita != null) {
            stmt.setDate(7, new java.sql.Date(visita.getTime()));
        } else {
            stmt.setNull(7, java.sql.Types.DATE);
        }

        stmt.executeUpdate();
        System.out.println(" Cliente registrado exitosamente.");

    } catch (SQLException e) {
        System.err.println(" Error al registrar cliente: " + e.getMessage());
    }
}

@Override
public void actualizar(Cliente entity) {
    String sql = "UPDATE Clientes SET identificacion = ?, nombre = ?, apellido = ?, telefono = ?, correo = ?, direccion = ?, proximaVisita = ? " +
                 "WHERE id = ?";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, entity.getIdentificacion());
        stmt.setString(2, entity.getNombre());
        stmt.setString(3, entity.getApellido());
        stmt.setString(4, entity.getTelefono());
        stmt.setString(5, entity.getCorreo());
        stmt.setString(6, entity.getDireccion());

        // proximaVisita puede ser null
        java.util.Date visita = entity.getProximaVisita();
        if (visita != null) {
            stmt.setDate(7, new java.sql.Date(visita.getTime()));
        } else {
            stmt.setNull(7, java.sql.Types.DATE);
        }

        stmt.setInt(8, entity.getId()); // el ID del cliente que se va a actualizar

        int rowsAffected = stmt.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println(" Cliente actualizado correctamente.");
        } else {
            System.out.println("️ No se encontró el cliente con ID: " + entity.getId());
        }

    } catch (SQLException e) {
        System.err.println(" Error al actualizar cliente: " + e.getMessage());
    }
}


public Cliente buscar(Integer id) {
    String sql = "SELECT * FROM Clientes WHERE identificacion = ?";
    Cliente cliente = null;

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            cliente = new Cliente();
            cliente.setId(rs.getInt("id"));
            cliente.setIdentificacion(rs.getString("identificacion"));
            cliente.setNombre(rs.getString("nombre"));
            cliente.setApellido(rs.getString("apellido"));
            cliente.setTelefono(rs.getString("telefono"));
            cliente.setCorreo(rs.getString("correo"));
            cliente.setDireccion(rs.getString("direccion"));
            cliente.setProximaVisita(rs.getDate("proximaVisita")); // java.sql.Date se asigna directo a java.util.Date
        }

    } catch (SQLException e) {
        System.err.println(" Error al buscar cliente: " + e.getMessage());
    }

    return cliente;
}

  public void eliminar(Integer id) {
    String sql = "DELETE FROM Clientes WHERE id = ?";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, id);
        int rowsAffected = stmt.executeUpdate();

        if (rowsAffected > 0) {
            System.out.println("🗑️ Cliente eliminado correctamente.");
        } else {
            System.out.println("️ No se encontró ningún cliente con ID: " + id);
        }

    } catch (SQLException e) {
        System.err.println(" Error al eliminar cliente: " + e.getMessage());
    }
}
    
    
}
