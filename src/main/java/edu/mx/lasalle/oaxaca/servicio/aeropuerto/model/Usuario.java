/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.mx.lasalle.oaxaca.servicio.aeropuerto.model;

import static com.fasterxml.jackson.databind.util.ClassUtil.name;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 *
 * @author jonag
 */

@Entity
@Table(name="usuario")

public class Usuario {
    @Id
    @Column(name ="curp")
    private String curp;
    
    @NotNull
    @Column(name="apellidos")
    private String apellidos;
    
    @NotNull
    @Column(name="nombre")
    private String nombre;
    
    @OneToOne
    @JoinColumn(name="id")
    @OnDelete(action=OnDeleteAction.CASCADE)
    private Direccion direccion;

    public Usuario() {
    }

    public Usuario( String curp, String apellidos, String nombre, Direccion direccion) {
        this.curp = curp;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
    
    
    
}
