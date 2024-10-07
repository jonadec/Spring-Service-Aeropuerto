package edu.mx.lasalle.oaxaca.servicio.aeropuerto.model;

import edu.mx.lasalle.oaxaca.servicio.aeropuerto.implement.service.Persona;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pasajero")
public class PasajeroModel implements Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    
    private String nombre;
    private String direccion;
    private Date fechaNacimiento;
    private Boolean discapacidad;
    private String nacionalidad;

    @OneToMany(mappedBy = "pasajero", cascade = CascadeType.ALL)
    private List<EquipajeModel> equipajes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Boolean getDiscapacidad() {
        return discapacidad;
    }

    public void setDiscapacidad(Boolean discapacidad) {
        this.discapacidad = discapacidad;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public List<EquipajeModel> getEquipajes() {
        return equipajes;
    }

    public void setEquipajes(List<EquipajeModel> equipajes) {
        this.equipajes = equipajes;
    }

    @Override
    public String toString() {
        return "PasajeroModel{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", discapacidad=" + discapacidad +
                ", nacionalidad='" + nacionalidad + '\'' +
                '}';
    }

    @Override
    public void viajar() {}
    @Override
    public void abordar() {}
    @Override
    public void checkin() {}

    @Override
    public void comer() {}
        

    @Override
    public void dormir() {}
       

    @Override
    public void irBanio() {}
       
}
