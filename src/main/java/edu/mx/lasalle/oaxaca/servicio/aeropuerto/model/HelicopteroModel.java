package edu.mx.lasalle.oaxaca.servicio.aeropuerto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "helicoptero")
public class HelicopteroModel extends VehiculoAereoModel {
    
    private int helices;
    private String tipo;

    // Constructor vacío
    public HelicopteroModel() {
    }

    // Constructor con parámetros
    public HelicopteroModel(int helices, String tipo) {
        this.helices = helices;
        this.tipo = tipo;
    }

    public int getHelices() {
        return helices;
    }

    public void setHelices(int helices) {
        this.helices = helices;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "HelicopteroModel{" + "helices=" + helices + ", tipo='" + tipo + '\'' + super.toString() + '}';
    }
}
