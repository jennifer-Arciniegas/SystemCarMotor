/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.systemcarmotor.service;

import com.mycompany.systemcarmotor.model.Vehiculo;
import com.mycompany.systemcarmotor.modelDAO.VehiculoDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author camper
 */
public class VehiculoService {
      private final VehiculoDAO vehiculoDAO;

    // Constructor que inicializa el VehiculoDAO
    public VehiculoService() {
        this.vehiculoDAO = VehiculoDAO.getInstance();
    }

    // Método para guardar un nuevo vehículo
    public void guardarVehiculo(Vehiculo vehiculo) throws SQLException {
        // Se puede agregar validaciones si es necesario antes de guardar el vehículo
        if (vehiculo.getPlaca() == null || vehiculo.getPlaca().isEmpty()) {
            throw new IllegalArgumentException("La placa del vehículo es obligatoria.");
        }

        // Llamada al DAO para guardar el vehículo
        vehiculoDAO.guardarVehiculo(vehiculo);
    }

    // Método para actualizar un vehículo
    public void actualizarVehiculo(Vehiculo vehiculo) throws SQLException {
        // Validación del vehículo antes de actualizar
        if (vehiculo.getId() <= 0) {
            throw new IllegalArgumentException("El ID del vehículo es inválido.");
        }

        // Llamada al DAO para actualizar el vehículo
        vehiculoDAO.actualizarVehiculo(vehiculo);
    }

    // Método para eliminar un vehículo por su ID
    public void eliminarVehiculo(int id) throws SQLException {
        // Validación del ID
        if (id <= 0) {
            throw new IllegalArgumentException("El ID del vehículo es inválido.");
        }

        // Llamada al DAO para eliminar el vehículo
        vehiculoDAO.eliminarVehiculo(id);
    }

    // Método para obtener un vehículo por su ID
    public Vehiculo obtenerVehiculoPorId(int id) throws SQLException {
        // Validación del ID
        if (id <= 0) {
            throw new IllegalArgumentException("El ID del vehículo es inválido.");
        }

        // Llamada al DAO para obtener el vehículo
        return vehiculoDAO.obtenerVehiculoPorId(id);
    }

    // Método para obtener todos los vehículos
    public List<Vehiculo> obtenerTodosVehiculos() throws SQLException {
        // Llamada al DAO para obtener todos los vehículos
        return vehiculoDAO.obtenerTodosVehiculos();
    }
}
