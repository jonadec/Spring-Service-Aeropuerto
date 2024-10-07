package edu.mx.lasalle.oaxaca.servicio.aeropuerto.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import java.util.Date;

/**
 *
 * @author jonag
 */
@Entity
@DiscriminatorValue("Copiloto")
public class CopilotoModel extends TripulacionModel {
    private String rango;
    private double tiempoRestantePiloto;

    public CopilotoModel(int id, double antiguedad, String turno, double horasVuelo, String nombre, String apellido, Date fechaNacimiento, String genero, String rango, double tiempoRestantePiloto) {
        super(id, antiguedad, turno, horasVuelo, nombre, apellido, fechaNacimiento, genero);
        this.rango = rango;
        this.tiempoRestantePiloto = tiempoRestantePiloto;
    }

    public CopilotoModel() {
    }

    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }

    public double getTiempoRestantePiloto() {
        return tiempoRestantePiloto;
    }

    public void setTiempoRestantePiloto(double tiempoRestantePiloto) {
        this.tiempoRestantePiloto = tiempoRestantePiloto;
    }
    
    @Override
    public String toString() {
        return "CopilotoModel{" + "id=" + getId() + ", antiguedad=" + getAntiguedad() + ", turno=" + getTurno() + ", horasVuelo=" + getHorasVuelo() + ", nombre=" + getNombre() + ", apellido=" + getApellido() + ", fechaNacimiento=" + getFechaNacimiento() + ", genero=" + getGenero() + ", rango=" + rango + ", tiempoRestantePiloto=" + tiempoRestantePiloto + '}';
    }
}
