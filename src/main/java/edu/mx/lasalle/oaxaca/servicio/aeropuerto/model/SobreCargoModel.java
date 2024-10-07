package edu.mx.lasalle.oaxaca.servicio.aeropuerto.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import java.util.Date;

@Entity
@DiscriminatorValue("Sobrecargo")
public class SobreCargoModel extends TripulacionModel {
    private String idiomas;
    private String certificados;

    public SobreCargoModel(int id, double antiguedad, String turno, double horasVuelo, String nombre, String apellido, Date fechaNacimiento, String genero, String idiomas, String certificados) {
        super(id, antiguedad, turno, horasVuelo, nombre, apellido, fechaNacimiento, genero);
        this.idiomas = idiomas;
        this.certificados = certificados;
    }

    public SobreCargoModel() {
        // Constructor vacío
    }

    public String getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(String idiomas) {
        this.idiomas = idiomas;
    }

    public String getCertificados() {
        return certificados;
    }

    public void setCertificados(String certificados) {
        this.certificados = certificados;
    }

    @Override
    public String toString() {
        return "SobreCargoModel{" +
                "idiomas='" + idiomas + '\'' +
                ", certificados='" + certificados + '\'' +
                "} " + super.toString();
    }
}
