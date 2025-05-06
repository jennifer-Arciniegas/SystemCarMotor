/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.systemcarmotor.controllers;

import com.mycompany.systemcarmotor.model.Servicio;
import com.mycompany.systemcarmotor.service.ServicioService;
import java.sql.SQLException;



/**
 *
 * @author camper
 */
public class ServicioController {
    private ServicioService servicioService = new ServicioService();

    public void registrarServicio(
            String descripcion,
            java.time.LocalTime tiempoEstimado,
            int idVehiculo,
            int idEstado,
            String ordenEntrega,
            String tipoMantenimiento,
            String subTipoMantenimiento
            
    ) throws SQLException {
        Servicio servicio = new Servicio();
        servicio.setDescripcion(descripcion);
        servicio.setTiempoEstimado(tiempoEstimado);
        servicio.setIdVehiculo(idVehiculo);
        servicio.setIdEstado(idEstado); // se recomienda usar 1 (Pendiente) por defecto
        servicio.setOrdenEntrega(ordenEntrega);
        servicio.setTipoMantenimiento(tipoMantenimiento);
        servicio.setSubTipoMantenimiento(subTipoMantenimiento);
       

        servicioService.registrarServicio(servicio);
    }
    
}
