package edu.mx.lasalle.oaxaca.servicio.aeropuerto.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "vuelo")
public class VueloModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @ManyToOne
    @JoinColumn(name = "terminal_id", nullable = false)
    private TerminalModel terminal;
    @ManyToOne
    @JoinColumn(name = "vehiculo_aereo_id", nullable = false)
    private VehiculoAereoModel vehiculoAereo;
    private String origen;
    private String destino;

    @ManyToOne
    @JoinColumn(name = "tripulacion_id", nullable = false)
    private TripulacionModel tripulacion;
    private int duracion; // en minutos
    private String horaSalida; // en formato HH:mm
    private String horaLlegada; // en formato HH:mm

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TerminalModel getTerminal() {
        return terminal;
    }

    public void setTerminal(TerminalModel terminal) {
        this.terminal = terminal;
    }

    public VehiculoAereoModel getVehiculoAereo() {
        return vehiculoAereo;
    }

    public void setVehiculoAereo(VehiculoAereoModel vehiculoAereo) {
        this.vehiculoAereo = vehiculoAereo;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public TripulacionModel getTripulacion() {
        return tripulacion;
    }

    public void setTripulacion(TripulacionModel tripulacion) {
        this.tripulacion = tripulacion;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(String horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    @Override
    public String toString() {
        return "VueloModel{" +
                "id=" + id +
                ", terminal=" + terminal +
                ", vehiculoAereo=" + vehiculoAereo +
                ", origen='" + origen + '\'' +
                ", destino='" + destino + '\'' +
                ", tripulacion=" + tripulacion +
                ", duracion=" + duracion +
                ", horaSalida='" + horaSalida + '\'' +
                ", horaLlegada='" + horaLlegada + '\'' +
                '}';
    }
}
