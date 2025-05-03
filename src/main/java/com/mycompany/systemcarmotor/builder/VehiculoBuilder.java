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

    public VehiculoBuilder  setPlaca(String placa) {
        this.placa = placa;
        return this;
    }

    public VehiculoBuilder setTipo(String tipo) {
        this.tipo = tipo;
        return this;
    }

    public VehiculoBuilder setModelo(String modelo) {
        this.modelo = modelo;
        return this;
    }

    public VehiculoBuilder setMarca(String marca) {
        this.marca = marca;
        return this;
    }

    public VehiculoBuilder setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
        return this;
    }
    
    public Vehiculo build(){
        return new Vehiculo (placa, tipo, modelo, marca, id_cliente);
    }
    
    
}
