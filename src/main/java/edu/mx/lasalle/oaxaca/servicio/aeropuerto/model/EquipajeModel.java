package edu.mx.lasalle.oaxaca.servicio.aeropuerto.model;

import jakarta.persistence.*;

@Entity
@Table(name = "equipaje")
public class EquipajeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    
    private float peso;
    private float altura;
    private float ancho;
    private String tipo;

    @ManyToOne
    @JoinColumn(name = "pasajero_id", nullable = false)
    private PasajeroModel pasajero;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getAncho() {
        return ancho;
    }

    public void setAncho(float ancho) {
        this.ancho = ancho;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public PasajeroModel getPasajero() {
        return pasajero;
    }

    public void setPasajero(PasajeroModel pasajero) {
        this.pasajero = pasajero;
    }

    @Override
    public String toString() {
        return "EquipajeModel{" +
                "id=" + id +
                ", peso=" + peso +
                ", altura=" + altura +
                ", ancho=" + ancho +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
