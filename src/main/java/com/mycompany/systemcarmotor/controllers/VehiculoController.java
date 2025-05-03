/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.systemcarmotor.controllers;

import com.mycompany.systemcarmotor.model.Vehiculo;
import com.mycompany.systemcarmotor.modelDAO.VehiculoDAO;
import java.sql.Connection;


/**
 *
 * @author camper
 */
public class VehiculoController {
    private VehiculoDAO vehiculoDAO;
   
    public VehiculoController(Connection connection) {
        this.vehiculoDAO = new VehiculoDAO(connection);
    }
    
    public boolean registrarVehiculo(Vehiculo vehiculo) {
        return vehiculoDAO.registrarVehiculo(vehiculo);
    }
     
    public Vehiculo obtenerVehiculo(String placa) {
        return vehiculoDAO.obtenerVehiculoPorPlaca(placa);
    }
    
    public boolean actualizarVehiculo(Vehiculo vehiculo) {
        if (vehiculo != null && vehiculo.getPlaca() != null) {
            return vehiculoDAO.actualizarVehiculo(vehiculo); 
        }
        return false;
    }
         
    public boolean eliminarVehiculo(String placa) {
        if (placa != null && !placa.isEmpty()) {
            return vehiculoDAO.eliminarVehiculo(placa); 
        }
        return false;
    }
}
