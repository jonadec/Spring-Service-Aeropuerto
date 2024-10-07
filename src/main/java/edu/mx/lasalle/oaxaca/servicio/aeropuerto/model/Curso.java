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
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author jonag
 */

@Entity
@Table(name="curso")
public class Curso {
    @Id
    @Column(name="clave_curso")
    private String clave_curso;
    
    @Column (name="nombre")
    private String nombre;
    
    @ManyToMany(fetch=FetchType.LAZY,
            cascade={
                CascadeType.PERSIST,
                CascadeType.MERGE
            }, mappedBy="estudiante_curso")
    private Set<Estudiante> estudiantes=new HashSet<>();
            
            
         
}
