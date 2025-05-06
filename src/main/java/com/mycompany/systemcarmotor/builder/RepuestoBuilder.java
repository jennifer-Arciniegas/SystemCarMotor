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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public void setVidaUtilEstimada(int vidaUtilEstimada) {
        this.vidaUtilEstimada = vidaUtilEstimada;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }
    
    public Repuesto build(){
        return new Repuesto(
        nombre, tipo, marca, modelo, cantidad, fechaIngreso, vidaUtilEstimada, idEstado, idProveedor
        );
    }
    
}
