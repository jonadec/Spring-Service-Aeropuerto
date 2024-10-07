/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.mx.lasalle.oaxaca.servicio.aeropuerto.service;

import edu.mx.lasalle.oaxaca.servicio.aeropuerto.model.EquipajeModel;
import edu.mx.lasalle.oaxaca.servicio.aeropuerto.model.PasajeroModel;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author jonag
 */
@Service
public interface EquipajeService {
    public void registrarEquipaje(EquipajeModel equipajemodel);
    public List obtenerEquipajes();
    public PasajeroModel getEquipaje(int id);
    public void actualizarDatosEquipaje(EquipajeModel equipajemodel, int id);
    public void borrarEquipaje(int id);
    public void borrarTodoEquipaje();
}
