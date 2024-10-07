/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.mx.lasalle.oaxaca.servicio.aeropuerto.implement.service;

import edu.mx.lasalle.oaxaca.servicio.aeropuerto.model.EquipajeModel;
import edu.mx.lasalle.oaxaca.servicio.aeropuerto.model.PasajeroModel;
import edu.mx.lasalle.oaxaca.servicio.aeropuerto.repository.EquipajeRepository;
import edu.mx.lasalle.oaxaca.servicio.aeropuerto.service.EquipajeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jonag
 */

@Service
public class EquipajeServiceImplements implements EquipajeService {
    @Autowired
    private EquipajeRepository equipajeRepository;

    @Override
    public void registrarEquipaje(EquipajeModel equipajemodel) {
        equipajeRepository.save(equipajemodel);
    }

    @Override
    public List obtenerEquipajes() {
        return equipajeRepository.findAll();
    }

    @Override
    public void actualizarDatosEquipaje(EquipajeModel equipajemodel, int id) {
        equipajemodel.setId(id);
        equipajeRepository.save(equipajemodel);
    }

    @Override
    public void borrarEquipaje(int id) {
        equipajeRepository.deleteById(id);
    }

    @Override
    public void borrarTodoEquipaje() {
        equipajeRepository.deleteAll();
    }

    @Override
    public PasajeroModel getEquipaje(int id) {
         return null;
    }

   
    
   
    
}
