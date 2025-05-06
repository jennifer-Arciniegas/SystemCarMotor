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
import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;

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

   public void generarFactura(int idServicio, int idCliente) throws SQLException, Exception {
    // 1. Obtener datos necesarios
    Cliente cliente = new ClienteDAO().obtenerPorId(idCliente);
    Servicio servicio = new ServicioDAO().obtenerPorId(idServicio);
    TallerInformacion taller = new TallerInformacionDAO().obtenerUnico();

    // 2. Crear y configurar la factura
    Factura factura = new Factura();
    factura.setNumero((int) (Math.random() * 100000)); // Generar número aleatorio
    factura.setFecha(new java.sql.Date(System.currentTimeMillis()));
    
    // Suponiendo subtotal es fijo o se calcula de algún modo
    factura.setSubtotal(new BigDecimal("150000")); 
    factura.setImpuestos(new BigDecimal("28500")); // Por ejemplo 19% IVA
    factura.setTotal(factura.getSubtotal().add(factura.getImpuestos()));

    // 3. Generar factura en PDF
    InvoiceGenerator generator = new InvoiceGenerator();
    generator.generarFacturaPDF(factura, cliente, servicio, taller);
}

}
