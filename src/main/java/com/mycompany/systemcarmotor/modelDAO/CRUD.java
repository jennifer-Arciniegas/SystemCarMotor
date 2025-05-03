/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.systemcarmotor.modelDAO;

import java.util.List;

/**
 *
 * @author camper
 */
public interface CRUD<T> {
  
    List<T> listar();
    void registrar(T entity);
    boolean actualizar(T entity);
}

