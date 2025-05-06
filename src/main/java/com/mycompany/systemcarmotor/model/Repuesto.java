/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.systemcarmotor.model;

import java.util.Date;

/**
 *
 * @author camper
 */
public class Repuesto {
    private int id;
    private String nombre;
    private String tipo;
    private String marca;
    private String modelo;
    private int cantidad;
    private Date fechaIngreso;
    private int vidaUtilEstimada;
    private int idEstado;
    private int idProveedor;

    public Repuesto(String nombre, String tipo, String marca, String modelo, int cantidad, Date fechaIngreso, int vidaUtilEstimada, int idEstado, int idProveedor) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.marca = marca;
        this.modelo = modelo;
        this.cantidad = cantidad;
        this.fechaIngreso = fechaIngreso;
        this.vidaUtilEstimada = vidaUtilEstimada;
        this.idEstado = idEstado;
        this.idProveedor = idProveedor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public int getVidaUtilEstimada() {
        return vidaUtilEstimada;
    }

    public void setVidaUtilEstimada(int vidaUtilEstimada) {
        this.vidaUtilEstimada = vidaUtilEstimada;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }
    
    
}
