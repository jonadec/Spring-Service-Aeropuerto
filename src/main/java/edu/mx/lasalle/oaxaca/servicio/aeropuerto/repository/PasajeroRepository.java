/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.mx.lasalle.oaxaca.servicio.aeropuerto.repository;

import edu.mx.lasalle.oaxaca.servicio.aeropuerto.model.PasajeroModel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author jonag
 */
public interface PasajeroRepository extends JpaRepository<PasajeroModel, Integer> {
    public PasajeroModel findById(int id);
    
}
