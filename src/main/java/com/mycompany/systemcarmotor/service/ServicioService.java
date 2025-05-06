/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.systemcarmotor.service;

import com.mycompany.systemcarmotor.model.Servicio;
import com.mycompany.systemcarmotor.modelDAO.ServicioDAO;
import java.sql.SQLException;

/**
 *
 * @author camper
 */
public class ServicioService {

       public void registrarServicio(Servicio servicio) throws SQLException {
        ServicioDAO dao = new ServicioDAO();
        dao.guardar(servicio);
    }
}
