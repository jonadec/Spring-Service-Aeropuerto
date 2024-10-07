package edu.mx.lasalle.oaxaca.servicio.aeropuerto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="avion")
public class AvionModel extends VehiculoAereoModel {
    private String aerolinea;
    private String tipoMotor;
    private int puertas;
    private String tipo;

    // Constructor
    public AvionModel() {
        super(); // Llamada al constructor de la clase padre
    }

    // Getters and Setters
    public String getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
    }

    public String getTipoMotor() {
        return tipoMotor;
    }

    public void setTipoMotor(String tipoMotor) {
        this.tipoMotor = tipoMotor;
    }

    public int getPuertas() {
        return puertas;
    }

    public void setPuertas(int puertas) {
        this.puertas = puertas;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "AvionModel{" +
                "aerolinea='" + aerolinea + '\'' +
                ", tipoMotor='" + tipoMotor + '\'' +
                ", puertas=" + puertas +
                ", tipo='" + tipo + '\'' +
                "} " + super.toString();
    }
}
