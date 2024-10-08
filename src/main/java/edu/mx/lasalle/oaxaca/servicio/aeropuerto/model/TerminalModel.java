package edu.mx.lasalle.oaxaca.servicio.aeropuerto.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "terminal")
public class TerminalModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int claveTerminal;
    private int capacidad;
    private boolean disponible;

    @ManyToOne
    @JoinColumn(name = "aeropuerto_id", nullable = false)
    @JsonBackReference
    private AeropuertoModel aeropuerto;

    // Getters y Setters
    public int getClaveTerminal() {
        return claveTerminal;
    }

    public void setClaveTerminal(int claveTerminal) {
        this.claveTerminal = claveTerminal;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public AeropuertoModel getAeropuerto() {
        return aeropuerto;
    }

    public void setAeropuerto(AeropuertoModel aeropuerto) {
        this.aeropuerto = aeropuerto;
    }
}
