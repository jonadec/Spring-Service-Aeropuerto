/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.mx.lasalle.oaxaca.servicio.aeropuerto.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.antlr.v4.runtime.misc.NotNull;


/**
 *
 * @author jonag
 */

@Entity
@Table(name="direccion")

public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id")
    private int id;
    
    @Column(name="calle")
    @NotNull
    private String calle;
    
    @Column(name="numero")
    @NotNull
    private String numero;
    
    @Column(name="municipio")
    @NotNull
    private String mubnicipio;

    public Direccion() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getMubnicipio() {
        return mubnicipio;
    }

    public void setMubnicipio(String mubnicipio) {
        this.mubnicipio = mubnicipio;
    }
    
    
    
}
