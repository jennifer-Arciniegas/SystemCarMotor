/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.systemcarmotor.util;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.mycompany.systemcarmotor.model.Cliente;
import com.mycompany.systemcarmotor.model.Servicio;
import com.mycompany.systemcarmotor.model.TallerInformacion;
import com.mycompany.systemcarmotor.model.Factura;
import java.io.FileOutputStream;

/**
 *
 * @author camper
 */
public class InvoiceGenerator {
    public static void generarFacturaPDF(Factura factura, Cliente cliente, Servicio servicio, TallerInformacion taller) throws Exception {
        Document doc = new Document();
        PdfWriter.getInstance(doc, new FileOutputStream("factura_" + factura.getNumero() + ".pdf"));
        doc.open();

        doc.add(new Paragraph("Factura N° " + factura.getNumero()));
        doc.add(new Paragraph("Taller: " + taller.getNombre()));
        doc.add(new Paragraph("Cliente: " + cliente.getNombre() + " " + cliente.getApellido()));
        doc.add(new Paragraph("Correo: " + cliente.getCorreo()));
        doc.add(new Paragraph("Servicio: " + servicio.getDescripcion()));
        doc.add(new Paragraph("Orden de Entrega: " + servicio.getOrdenEntrega()));
        doc.add(new Paragraph("Subtotal: $" + factura.getSubtotal()));
        doc.add(new Paragraph("Impuestos: $" + factura.getImpuestos()));
        doc.add(new Paragraph("Total: $" + factura.getTotal()));

        doc.close();
    }
}
