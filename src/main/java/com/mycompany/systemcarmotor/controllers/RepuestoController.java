/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.systemcarmotor.controllers;

import com.mycompany.systemcarmotor.builder.RepuestoBuilder;
import com.mycompany.systemcarmotor.model.Repuesto;
import com.mycompany.systemcarmotor.service.RepuestoService;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author camper
 */
public class RepuestoController {
    private RepuestoService repuestoService;

    public RepuestoController() {
        this.repuestoService = new RepuestoService();
    }

    public void registrarRepuesto(String nombre, String tipo, String marca, String modelo,
                                  int cantidad, Date fechaIngreso, int vidaUtil, int idProveedor) throws SQLException {

        // El estado por defecto es 1 (Disponible)
        Repuesto repuesto = new RepuestoBuilder()
                .setNombre(nombre)
                .setTipo(tipo)
                .setMarca(marca)
                .setModelo(modelo)
                .setCantidad(cantidad)
                .setFechaIngreso(fechaIngreso)
                .setVidaUtilEstimada(vidaUtil)
                .setIdEstado(1) // Disponible
                .setIdProveedor(idProveedor)
                .build();

        repuestoService.registrarRepuesto(repuesto);
    }
}
