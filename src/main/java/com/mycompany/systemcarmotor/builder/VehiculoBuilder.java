/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.systemcarmotor.builder;

import com.mycompany.systemcarmotor.model.Vehiculo;

/**
 *dsdc
 * @author camper
 */
public class VehiculoBuilder {
  
    private String placa;
    private String tipo;
    private String modelo;
    private String marca;
    private int id_cliente;

    // Constructor vacío
    public VehiculoBuilder() {
    }

    // Método para establecer la placa
    public VehiculoBuilder setPlaca(String placa) {
        this.placa = placa;
        return this;
    }

    // Método para establecer el tipo de vehículo
    public VehiculoBuilder setTipo(String tipo) {
        this.tipo = tipo;
        return this;
    }

    // Método para establecer el modelo del vehículo
    public VehiculoBuilder setModelo(String modelo) {
        this.modelo = modelo;
        return this;
    }

    // Método para establecer la marca del vehículo
    public VehiculoBuilder setMarca(String marca) {
        this.marca = marca;
        return this;
    }

    // Método para establecer el id del cliente (propietario del vehículo)
    public VehiculoBuilder setIdCliente(int id_cliente) {
        this.id_cliente = id_cliente;
        return this;
    }

    // Método para construir el objeto Vehiculo con los valores proporcionados
    public Vehiculo build() {
        // Se puede agregar validaciones si es necesario (por ejemplo, que los campos no estén vacíos)
        return new Vehiculo(placa, tipo, modelo, marca, id_cliente);
    }
    
    
}
