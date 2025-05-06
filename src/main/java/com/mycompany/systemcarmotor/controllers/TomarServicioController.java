/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.systemcarmotor.controllers;

import com.mycompany.systemcarmotor.model.ManoObra;
import com.mycompany.systemcarmotor.model.Tecnico;
import com.mycompany.systemcarmotor.model.UsoRepuesto;
import com.mycompany.systemcarmotor.service.TomarServicioFacade;
import java.sql.SQLException;

/**
 *
 * @author camper
 */
public class TomarServicioController {
     private TomarServicioFacade facade = new TomarServicioFacade();

    public void tomarServicio(
        String nombreTecnico,
        String especialidadTecnico,
        String descripcionManoObra,
        double tarifaHora,
        int idServicio,
        int idRepuesto,
        int cantidadUsada
    ) throws SQLException {

        // 1. Crear modelo Tecnico
        Tecnico tecnico = new Tecnico();
        tecnico.setNombre(nombreTecnico);
        tecnico.setEspecialidad(especialidadTecnico);

        // 2. Crear modelo ManoObra
        ManoObra manoObra = new ManoObra();
        manoObra.setDescripcion(descripcionManoObra);
        manoObra.setTarifaHora(tarifaHora); // se convierte a BigDecimal en DAO
        manoObra.setIdServicio(idServicio); // se asigna después de obtener el técnico
        // idTecnico se asignará dentro del facade tras guardar técnico

        // 3. Crear modelo UsoRepuesto
        UsoRepuesto uso = new UsoRepuesto();
        uso.setIdServicio(idServicio);
        uso.setIdRepuesto(idRepuesto);
        
        uso.setCantidadUsada(cantidadUsada);

        // 4. Ejecutar operación transaccional
        facade.procesarTomaDeServicio(tecnico, manoObra, uso);
    }
}
