/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.systemcarmotor.controllers;

import com.mycompany.systemcarmotor.model.Cliente;
import com.mycompany.systemcarmotor.modelDAO.ClienteDAO;
import java.util.List;

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

    public void actualizarCliente(Cliente cliente) {
        clienteDAO.actualizar(cliente);
    }

    public Cliente buscarClientePorId(int id) {
        return clienteDAO.buscar(id);
    }

    public void eliminarCliente(int id) {
        clienteDAO.eliminar(id);
    }

    
}
