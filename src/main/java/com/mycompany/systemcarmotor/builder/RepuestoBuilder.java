/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.systemcarmotor.builder;

import com.mycompany.systemcarmotor.model.Repuesto;
import java.util.Date;

/**
 *
 * @author camper
 */
public class RepuestoBuilder {
     private String nombre;
    private String tipo;
    private String marca;
    private String modelo;
    private int cantidad;
    private Date fechaIngreso;
    private int vidaUtilEstimada;
    private int idEstado = 1; // Por defecto: "Disponible"
    private int idProveedor;

    public RepuestoBuilder setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public RepuestoBuilder setTipo(String tipo) {
        this.tipo = tipo;
        return this;
    }

    public RepuestoBuilder setMarca(String marca) {
        this.marca = marca;
        return this;
    }

    public RepuestoBuilder setModelo(String modelo) {
        this.modelo = modelo;
        return this;
    }

    public RepuestoBuilder setCantidad(int cantidad) {
        this.cantidad = cantidad;
        return this;
    }

    public RepuestoBuilder setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
        return this;
    }

    public RepuestoBuilder setVidaUtilEstimada(int vidaUtilEstimada) {
        this.vidaUtilEstimada = vidaUtilEstimada;
        return this;
    }

    public RepuestoBuilder setIdEstado(int idEstado) {
        this.idEstado = idEstado;
        return this;
    }

    public RepuestoBuilder setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
        return this;
    }
    
    public Repuesto build(){
        return new Repuesto(
        nombre, tipo, marca, modelo, cantidad, fechaIngreso, vidaUtilEstimada, idEstado, idProveedor
        );
    }
    
}
