/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.systemcarmotor.controllers;

import com.mycompany.systemcarmotor.model.Vehiculo;
import com.mycompany.systemcarmotor.service.VehiculoService;
import java.sql.SQLException;
import java.util.List;



/**
 *
 * @author camper
 */
public class VehiculoController {
      private final VehiculoService vehiculoService;

    // Constructor que inicializa el VehiculoService
    public VehiculoController() {
        this.vehiculoService = new VehiculoService();
    }

    // Método para registrar un nuevo vehículo
    public void registrarVehiculo(String placa, String tipo, String modelo, String marca, int id_cliente) {
        Vehiculo vehiculo = new Vehiculo(placa, tipo, modelo, marca, id_cliente);

        try {
            // Llamada al servicio para guardar el vehículo
            vehiculoService.guardarVehiculo(vehiculo);
            System.out.println("Vehículo registrado exitosamente.");
        } catch (SQLException e) {
            System.err.println("Error al registrar el vehículo: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    // Método para actualizar los detalles de un vehículo
    public void actualizarVehiculo(int id, String placa, String tipo, String modelo, String marca, int id_cliente) {
        Vehiculo vehiculo = new Vehiculo(id, placa, tipo, modelo, marca, id_cliente);

        try {
            // Llamada al servicio para actualizar el vehículo
            vehiculoService.actualizarVehiculo(vehiculo);
            System.out.println("Vehículo actualizado exitosamente.");
        } catch (SQLException e) {
            System.err.println("Error al actualizar el vehículo: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    // Método para eliminar un vehículo
    public void eliminarVehiculo(int id) {
        try {
            // Llamada al servicio para eliminar el vehículo
            vehiculoService.eliminarVehiculo(id);
            System.out.println("Vehículo eliminado exitosamente.");
        } catch (SQLException e) {
            System.err.println("Error al eliminar el vehículo: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    // Método para obtener un vehículo por su ID
    public void obtenerVehiculoPorId(int id) {
        try {
            Vehiculo vehiculo = vehiculoService.obtenerVehiculoPorId(id);
            if (vehiculo != null) {
                System.out.println("Vehículo encontrado: " + vehiculo);
            } else {
                System.out.println("Vehículo no encontrado.");
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener el vehículo: " + e.getMessage());
        }
    }

    // Método para obtener todos los vehículos
    public void obtenerTodosVehiculos() {
        try {
            List<Vehiculo> vehiculos = vehiculoService.obtenerTodosVehiculos();
            if (!vehiculos.isEmpty()) {
                for (Vehiculo vehiculo : vehiculos) {
                    System.out.println(vehiculo);
                }
            } else {
                System.out.println("No hay vehículos registrados.");
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener los vehículos: " + e.getMessage());
        }
    }
    
   
}
