/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.systemcarmotor.model;

import java.time.LocalTime;

/**
 *
 * @author camper
 */
public class Servicio {
    private int id;
    private String descripcion;
    private LocalTime tiempoEstimado;
    private int idVehiculo;
    private int idEstado;
    private String ordenEntrega;
    private int idMantenimiento;
    private String TipoMantenimiento;
    private String SubTipoMantenimiento;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalTime getTiempoEstimado() {
        return tiempoEstimado;
    }

    public void setTiempoEstimado(LocalTime tiempoEstimado) {
        this.tiempoEstimado = tiempoEstimado;
    }

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getOrdenEntrega() {
        return ordenEntrega;
    }

    public void setOrdenEntrega(String ordenEntrega) {
        this.ordenEntrega = ordenEntrega;
    }

    
    public int getIdMantenimiento() {
        return idMantenimiento;
    }

    public void setIdMantenimiento(int idMantenimiento) {
        this.idMantenimiento = idMantenimiento;
    }

    
    public String getTipoMantenimiento() {
        return TipoMantenimiento;
    }

    public void setTipoMantenimiento(String TipoMantenimiento) {
        this.TipoMantenimiento = TipoMantenimiento;
    }

    public String getSubTipoMantenimiento() {
        return SubTipoMantenimiento;
    }

    public void setSubTipoMantenimiento(String SubTipoMantenimiento) {
        this.SubTipoMantenimiento = SubTipoMantenimiento;
    }




    
}
