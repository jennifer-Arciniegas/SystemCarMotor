/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.systemcarmotor.builder;

import com.mycompany.systemcarmotor.model.Servicio;
import java.time.LocalTime;

/**
 *
 * @author camper
 */
public class ServicioBuilder {
    private String descripcion;
    private LocalTime tiempoEstimado;
    private int idVehiculo;
    private int idEstado;
    private String ordenEntrega;
    private int idMantenimiento;
    private String TipoMantenimiento;
    private String SubTipoMantenimiento;

    public ServicioBuilder setDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public ServicioBuilder setTiempoEstimado(LocalTime tiempoEstimado) {
        this.tiempoEstimado = tiempoEstimado;
        return this;
    }

    public ServicioBuilder setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
        return this;
    }

    public ServicioBuilder setIdEstado(int idEstado) {
        this.idEstado = idEstado;
        return this;
    }

    public ServicioBuilder setOrdenEntrega(String ordenEntrega) {
        this.ordenEntrega = ordenEntrega;
         return this;
    }

    
    public ServicioBuilder setIdMantenimiento(int idMantenimiento) {
        this.idMantenimiento = idMantenimiento;
        return this;
    }


    public ServicioBuilder setTipoMantenimiento(String TipoMantenimiento) {
        this.TipoMantenimiento = TipoMantenimiento;
        return this;
    }

    public ServicioBuilder setSubTipoMantenimiento(String SubTipoMantenimiento) {
        this.SubTipoMantenimiento = SubTipoMantenimiento;
        return this;
    }

   
    
    public Servicio build(){
        Servicio servicio = new Servicio();
        servicio.setDescripcion(descripcion);
        servicio.setTiempoEstimado(tiempoEstimado);
        servicio.setIdVehiculo(idVehiculo);
        servicio.setIdEstado(idEstado);
        servicio.setOrdenEntrega(ordenEntrega);
        servicio.setTipoMantenimiento(TipoMantenimiento);
        servicio.setSubTipoMantenimiento(SubTipoMantenimiento);
        return servicio;
    }
    
    
}
