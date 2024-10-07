/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.mx.lasalle.oaxaca.servicio.aeropuerto.repository;

import edu.mx.lasalle.oaxaca.servicio.aeropuerto.model.BoletoModel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author jonag
 */
public interface BoletoRepository extends JpaRepository<BoletoModel, Integer> {
    public BoletoModel findById(int id);
    
}