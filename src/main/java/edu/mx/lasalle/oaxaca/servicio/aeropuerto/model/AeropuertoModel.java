/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.mx.lasalle.oaxaca.servicio.aeropuerto.model;
import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "aeropuerto")
public class AeropuertoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "aeropuerto_seq")
    @SequenceGenerator(name = "aeropuerto_seq", sequenceName = "aeropuerto_seq", allocationSize = 1)
    private int claveAeropuerto;

    private String nombre;
    private int numeroPistas;
    private String tipoAvion;

    @OneToMany(mappedBy = "aeropuerto", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<TerminalModel> terminales;

    // Getters y Setters

    public int getClaveAeropuerto() {
        return claveAeropuerto;
    }

    public void setClaveAeropuerto(int claveAeropuerto) {
        this.claveAeropuerto = claveAeropuerto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroPistas() {
        return numeroPistas;
    }

    public void setNumeroPistas(int numeroPistas) {
        this.numeroPistas = numeroPistas;
    }

    public String getTipoAvion() {
        return tipoAvion;
    }

    public void setTipoAvion(String tipoAvion) {
        this.tipoAvion = tipoAvion;
    }

    public List<TerminalModel> getTerminales() {
        return terminales;
    }

    public void setTerminales(List<TerminalModel> terminales) {
        this.terminales = terminales;
    }

    @Override
    public String toString() {
        return "AeropuertoModel{" +
                "claveAeropuerto=" + claveAeropuerto +
                ", nombre='" + nombre + '\'' +
                ", numeroPistas=" + numeroPistas +
                ", tipoAvion='" + tipoAvion + '\'' +
                ", terminales=" + terminales +
                '}';
    }
}
