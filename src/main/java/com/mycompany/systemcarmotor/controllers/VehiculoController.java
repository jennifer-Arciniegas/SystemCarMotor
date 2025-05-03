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

    // Método para registrar un vehículo
    public void guardarVehiculo(String placa, String tipo, String modelo, String marca, int idCliente) {
        try {
            vehiculoService.guardarVehiculo(placa, tipo, modelo, marca, idCliente);
            System.out.println("Vehículo registrado exitosamente.");
        } catch (SQLException e) {
            System.err.println("Error al registrar vehículo: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    // Método para actualizar un vehículo
    public void actualizarVehiculo(String placa, String tipo, String modelo, String marca, int idCliente) {
        try {
            vehiculoService.actualizarVehiculo(placa, tipo, modelo, marca, idCliente);
            System.out.println("Vehículo actualizado exitosamente.");
        } catch (SQLException e) {
            System.err.println("Error al actualizar vehículo: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    // Método para eliminar un vehículo
    public void eliminarVehiculo(String placa) {
        try {
            vehiculoService.eliminarVehiculo(placa);
            System.out.println("Vehículo eliminado exitosamente.");
        } catch (SQLException e) {
            System.err.println("Error al eliminar vehículo: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    // Método para obtener un vehículo por placa
    public Vehiculo obtenerVehiculoPorPlaca(String placa) {
        try {
            return vehiculoService.obtenerVehiculoPorPlaca(placa);
        } catch (SQLException e) {
            System.err.println("Error al obtener vehículo: " + e.getMessage());
        }
        return null; // Si no se encuentra el vehículo
    }

    // Método para obtener todos los vehículos
    public List<Vehiculo> obtenerTodosVehiculos() {
        try {
            return vehiculoService.obtenerTodosVehiculos();
        } catch (SQLException e) {
            System.err.println("Error al obtener todos los vehículos: " + e.getMessage());
        }
        return null;
    }
   
}
