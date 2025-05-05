/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.systemcarmotor.model;

/**
 *
 * @author camper
 */
public class Calificacion {
    private int id;
    private int puntualidad;
    private String calidad;
    private String costo;

    public Calificacion() {
    }

    public Calificacion(int id, int puntualidad, String calidad, String costo) {
        this.id = id;
        this.puntualidad = puntualidad;
        this.calidad = calidad;
        this.costo = costo;
    }

    public Calificacion(int puntualidad, String calidad, String costo) {
        this.puntualidad = puntualidad;
        this.calidad = calidad;
        this.costo = costo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPuntualidad() {
        return puntualidad;
    }

    public void setPuntualidad(int puntualidad) {
        this.puntualidad = puntualidad;
    }

    public String getCalidad() {
        return calidad;
    }

    public void setCalidad(String calidad) {
        this.calidad = calidad;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }
    
    
}
