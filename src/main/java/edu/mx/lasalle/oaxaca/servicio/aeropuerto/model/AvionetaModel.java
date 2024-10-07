package edu.mx.lasalle.oaxaca.servicio.aeropuerto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="avioneta")
public class AvionetaModel extends VehiculoAereoModel {
    private int numeroMotores;
    private String tipoPista;
    private String clasificacion;

    public AvionetaModel() {
        super(); // Llama al constructor de la clase padre
    }

    public int getNumeroMotores() {
        return numeroMotores;
    }

    public void setNumeroMotores(int numeroMotores) {
        this.numeroMotores = numeroMotores;
    }

    public String getTipoPista() {
        return tipoPista;
    }

    public void setTipoPista(String tipoPista) {
        this.tipoPista = tipoPista;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    @Override
    public String toString() {
        return "AvionetaModel{" +
                "numeroMotores=" + numeroMotores +
                ", tipoPista='" + tipoPista + '\'' +
                ", clasificacion='" + clasificacion + '\'' +
                "} " + super.toString(); // Llama al método toString() de la clase padre
    }
}
