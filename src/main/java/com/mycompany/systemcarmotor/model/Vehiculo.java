package com.mycompany.systemcarmotor.model;



public class Vehiculo {
    private int id;
    private String placa;
    private String tipo;
    private String modelo;
    private String marca;
    private int id_cliente;

    public Vehiculo() {
    }

    public Vehiculo(int id, String placa, String tipo, String modelo, String marca, int id_cliente) {
        this.id = id;
        this.placa = placa;
        this.tipo = tipo;
        this.modelo = modelo;
        this.marca = marca;
        this.id_cliente = id_cliente;
    }

    public Vehiculo(String placa, String tipo, String modelo, String marca, int id_cliente) {
        this.placa = placa;
        this.tipo = tipo;
        this.modelo = modelo;
        this.marca = marca;
        this.id_cliente = id_cliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }
    
    
}