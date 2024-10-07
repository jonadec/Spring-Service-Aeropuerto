package edu.mx.lasalle.oaxaca.servicio.aeropuerto.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import java.util.Date;

/**
 *
 * @author jonag
 */
@Entity
@DiscriminatorValue("Piloto")
public class PilotoModel extends TripulacionModel {
    private String rango;
    private String licencia;
    private String tipoVehiculoAereo;
    private String saludMental;

    public PilotoModel() {
        super();
    }

    public PilotoModel(int id, double antiguedad, String turno, double horasVuelo, String nombre, String apellido, Date fechaNacimiento, String genero, String rango, String licencia, String tipoVehiculoAereo, String saludMental) {
        super(id, antiguedad, turno, horasVuelo, nombre, apellido, fechaNacimiento, genero);
        this.rango = rango;
        this.licencia = licencia;
        this.tipoVehiculoAereo = tipoVehiculoAereo;
        this.saludMental = saludMental;
    }

    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    public String getTipoVehiculoAereo() {
        return tipoVehiculoAereo;
    }

    public void setTipoVehiculoAereo(String tipoVehiculoAereo) {
        this.tipoVehiculoAereo = tipoVehiculoAereo;
    }

    public String getSaludMental() {
        return saludMental;
    }

    public void setSaludMental(String saludMental) {
        this.saludMental = saludMental;
    }

    @Override
    public String toString() {
        return "PilotoModel{" + "rango=" + rango + ", licencia=" + licencia + ", tipoVehiculoAereo=" + tipoVehiculoAereo + ", saludMental=" + saludMental + ", " + super.toString() + "}";
    }
}
