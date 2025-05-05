/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.systemcarmotor.model;

/**
 *
 * @author camper
 */
public class Proveedor {
    private int id;
    private String nombre;
    private String nit;
    private String telefono;
    private String frecuenciaSuministro;
    private int idCalificacion;

    public Proveedor() {
    }

    public Proveedor(String nombre, String nit, String telefono, String frecuenciaSuministro, int idCalificacion) {
        this.nombre = nombre;
        this.nit = nit;
        this.telefono = telefono;
        this.frecuenciaSuministro = frecuenciaSuministro;
        this.idCalificacion = idCalificacion;
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

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFrecuenciaSuministro() {
        return frecuenciaSuministro;
    }

    public void setFrecuenciaSuministro(String frecuenciaSuministro) {
        this.frecuenciaSuministro = frecuenciaSuministro;
    }

    public int getIdCalificacion() {
        return idCalificacion;
    }

    public void setIdCalificacion(int idCalificacion) {
        this.idCalificacion = idCalificacion;
    }
    
    
}
