/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.mx.lasalle.oaxaca.servicio.aeropuerto.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


/**
 *
 * @author jonag
 */
@Entity
@Table(name="elemento")
public class Elemento {
    @Id
    @Column(name="clave")
    private int clave;
     
    @Column(name="nombre")
    private String nombre;
    
    @Column(name="precio")
    private String precio;
}
