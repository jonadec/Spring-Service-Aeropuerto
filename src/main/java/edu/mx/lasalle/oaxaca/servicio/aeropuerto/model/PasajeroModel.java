/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.mx.lasalle.oaxaca.servicio.aeropuerto.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.util.Date;


/**
 *
 * @author jonag
 */
@Entity
@Table(name="pasajero")

public class PasajeroModel {
    private int id;
    private String nombre;
    private String direccion;
    private Date fechaNacimiento;
    private Boolean discapacidad;
    private String nacionalidad;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Boolean getDiscapacidad() {
        return discapacidad;
    }

    public void setDiscapacidad(Boolean discapacidad) {
        this.discapacidad = discapacidad;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    @Override
    public String toString() {
        return "PasajeroModel{" + "id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", fechaNacimiento=" + fechaNacimiento + ", discapacidad=" + discapacidad + ", nacionalidad=" + nacionalidad + '}';
    }
    
    
    
    
}
