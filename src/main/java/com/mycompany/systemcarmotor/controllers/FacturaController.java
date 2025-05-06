/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.systemcarmotor.controllers;

import com.mycompany.systemcarmotor.model.Cliente;
import com.mycompany.systemcarmotor.model.Servicio;
import com.mycompany.systemcarmotor.model.TallerInformacion;
import com.mycompany.systemcarmotor.modelDAO.ClienteDAO;
import com.mycompany.systemcarmotor.modelDAO.ServicioDAO;
import com.mycompany.systemcarmotor.modelDAO.TallerInformacionDAO;
import com.mycompany.systemcarmotor.util.InvoiceGenerator;
import com.mycompany.systemcarmotor.model.Factura;

/**
 *
 * @author camper
 */
public class FacturaController {

    public void registrarFacturaConPDF(Factura factura, int idCliente, int idServicio) throws Exception {
        Cliente cliente = new ClienteDAO().obtenerPorId(idCliente);
        Servicio servicio = new ServicioDAO().obtenerPorId(idServicio);
        TallerInformacion taller = new TallerInformacionDAO().obtenerUnico();

        InvoiceGenerator.generarFacturaPDF(factura, cliente, servicio, taller);
    }
}
