/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.mx.lasalle.oaxaca.servicio.aeropuerto.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author tokay
 */
@Entity
@Table(name="estudiante")
public class Estudiante {
    @Id
    @Column(name="curp")
    private String curp;
    
    @Column(name="apellidos")
    private String apellidos;
    
    @NotNull
    @Column(name="nombre")
    private String nombre;
    
    @ManyToMany(fetch=FetchType.LAZY,
            cascade={
                CascadeType.PERSIST,
                CascadeType.MERGE
            })
    @JoinTable(name="estudiante_curso",
            joinColumns={@JoinColumn(name="curp")},
            inverseJoinColumns={@JoinColumn(name="clave_curso")})
    private Set<Curso> estudiante_curso = new HashSet<>();
}