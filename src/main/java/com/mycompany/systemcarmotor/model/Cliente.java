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
public class Cliente {
    private int id;
    private String identificacion;
    private String nombre;
    private String apellido;
    private String telefono;
    private String correo;
    private String direccion;
    private Date proximaVisita;

    public Cliente() {
    }

    public Cliente(int id, String identificacion, String nombre, String apellido, String telefono, String correo, String direccion, Date proximaVisita) {
        this.id = id;
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
        this.proximaVisita = proximaVisita;
    }

    public Cliente(String identificacion, String nombre, String apellido, String telefono, String correo, String direccion, Date proximaVisita) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
        this.proximaVisita = proximaVisita;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getProximaVisita() {
        return proximaVisita;
    }

    public void setProximaVisita(Date proximaVisita) {
        this.proximaVisita = proximaVisita;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", identificacion=" + identificacion + ", nombre=" + nombre + ", apellido=" + apellido + ", telefono=" + telefono + ", correo=" + correo + ", direccion=" + direccion + ", proximaVisita=" + proximaVisita + '}';
    }
    
    
}
