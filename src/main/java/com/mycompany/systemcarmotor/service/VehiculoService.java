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
    public void guardarVehiculo(String placa, String tipo, String modelo, String marca, int idCliente) throws SQLException {
        // Validaciones (por ejemplo, asegurarse de que la placa no esté vacía)
        if (placa == null || placa.isEmpty()) {
            throw new IllegalArgumentException("La placa es obligatoria.");
        }

        Vehiculo vehiculo = new Vehiculo(placa, tipo, modelo, marca, idCliente);
        vehiculoDAO.guardarVehiculo(vehiculo); // Llama al DAO para guardar el vehículo
    }

    public void actualizarVehiculo(String nuevaPlaca, String tipo, String modelo, String marca, int idCliente, String placaOriginal) throws SQLException {
        if (nuevaPlaca == null || nuevaPlaca.isEmpty() || placaOriginal == null || placaOriginal.isEmpty()) {
            throw new IllegalArgumentException("La placa actual y la original no pueden estar vacías.");
        }

        Vehiculo vehiculo = new Vehiculo(nuevaPlaca, tipo, modelo, marca, idCliente);
        vehiculoDAO.actualizarVehiculo(vehiculo, placaOriginal);
    }


    // Método para eliminar un vehículo por placa
    public void eliminarVehiculo(String placa) throws SQLException {
        // Validaciones
        if (placa == null || placa.isEmpty()) {
            throw new IllegalArgumentException("La placa es obligatoria para eliminar.");
        }

        vehiculoDAO.eliminarVehiculo(placa); // Llama al DAO para eliminar el vehículo
    }

    // Método para obtener un vehículo por su placa
    public Vehiculo obtenerVehiculoPorPlaca(String placa) throws SQLException {
        // Validaciones
        if (placa == null || placa.isEmpty()) {
            throw new IllegalArgumentException("La placa es obligatoria para la búsqueda.");
        }

        return vehiculoDAO.obtenerVehiculoPorPlaca(placa); // Llama al DAO para obtener el vehículo
    }

    // Método para obtener todos los vehículos
    public List<Vehiculo> obtenerTodosVehiculos() throws SQLException {
        return vehiculoDAO.obtenerTodosVehiculos(); // Llama al DAO para obtener todos los vehículos
    }
}
