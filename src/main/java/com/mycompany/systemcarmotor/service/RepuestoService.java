/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.systemcarmotor.service;

import com.mycompany.systemcarmotor.model.Repuesto;
import com.mycompany.systemcarmotor.modelDAO.RepuestoDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author camper
 */
public class RepuestoService {
      public void registrarRepuesto(Repuesto repuesto) throws SQLException {
        RepuestoDAO.getInstance().guardar(repuesto);
    }
      
     public List<Repuesto> obtenerTodosLosRepuestos() throws SQLException {
        return RepuestoDAO.getInstance().obtenerTodos();
    }
}



