/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.systemcarmotor.controllers;

import com.mycompany.systemcarmotor.model.Cliente;
import com.mycompany.systemcarmotor.modelDAO.ClienteDAO;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author camper
 */
public class ClienteController {
    private ClienteDAO clienteDAO;

    public ClienteController() {
        this.clienteDAO = new ClienteDAO();
    }

    public List<Cliente> obtenerTodosLosClientes() {
        return clienteDAO.listar();
    }

    public void registrarCliente(Cliente cliente) {
        clienteDAO.registrar(cliente);
    }

   public boolean actualizarCliente(Cliente cliente) {
        boolean exito = clienteDAO.actualizar(cliente);  // Llama al DAO para actualizar el cliente
        if (exito) {
            // El cliente se actualizó correctamente
            return true;
        } else {
            // Hubo un error al actualizar
            return false;
        }
    }



    public Cliente buscarClientePorId(int id) {
        return clienteDAO.buscar(id);
    }

    public boolean eliminarCliente(int id) {
    // Llamar al DAO para eliminar al cliente
        ClienteDAO clienteDAO = new ClienteDAO();
        return clienteDAO.eliminar(id);  // Devuelve el resultado de la eliminación
    }

    
}
