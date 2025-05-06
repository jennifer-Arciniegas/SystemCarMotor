/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.systemcarmotor.service;

import com.mycompany.systemcarmotor.model.ManoObra;
import com.mycompany.systemcarmotor.model.Tecnico;
import com.mycompany.systemcarmotor.model.UsoRepuesto;
import com.mycompany.systemcarmotor.modelDAO.ManoObraDAO;
import com.mycompany.systemcarmotor.modelDAO.TecnicoDAO;
import com.mycompany.systemcarmotor.modelDAO.UsoRepuestoDAO;
import com.mycompany.systemcarmotor.util.DatabaseConnection;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author camper
 */
public class TomarServicioFacade {

    private final TecnicoDAO tecnicoDAO = new TecnicoDAO();
    private final ManoObraDAO manoObraDAO = new ManoObraDAO();
    private final UsoRepuestoDAO usoRepuestoDAO = new UsoRepuestoDAO();

    public void tomarServicio(
            Tecnico tecnico,
            ManoObra manoObra,
            UsoRepuesto usoRepuesto
    ) throws SQLException {

        try {
            // 1. Registrar o verificar técnico
            int tecnicoId = tecnicoDAO.guardarSiNoExiste(tecnico);

            // 2. Asociar mano de obra al técnico y servicio
            manoObra.setIdTecnico(tecnicoId);
            manoObraDAO.guardar(manoObra);

            // 3. Registrar uso del repuesto en el servicio
            usoRepuestoDAO.guardar(usoRepuesto);
            

        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("❌ Error al tomar el servicio: " + e.getMessage());
        }
    }

    public void procesarTomaDeServicio(
            Tecnico tecnico,
            ManoObra manoObra,
            UsoRepuesto usoRepuesto
    ) throws SQLException {

        try {
            // 1. Registrar o verificar técnico
            int tecnicoId = tecnicoDAO.guardarSiNoExiste(tecnico);

            // 2. Asociar técnico a mano de obra
            manoObra.setIdTecnico(tecnicoId);
            manoObraDAO.guardar(manoObra);

            // 3. Registrar uso del repuesto
            usoRepuestoDAO.guardar(usoRepuesto);

            System.out.println("✔ Servicio procesado correctamente.");
        } catch (SQLException e) {
            System.err.println("❌ Error al procesar el servicio: " + e.getMessage());
            throw e;
        }
    }

}
