/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.mx.lasalle.oaxaca.servicio.aeropuerto.service;

import edu.mx.lasalle.oaxaca.servicio.aeropuerto.model.PasajeroModel;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author jonag
 */
@Service
public interface PasajeroService {
    public void registrarPasajero(PasajeroModel pasajeromodel);
    public List obtenerPasajeros();
    public PasajeroModel getPasajero(int id);
    public void actualizarDatosPasajero(PasajeroModel pasajeromodel, int id);
    public void borrarPasajero(int id);
    public void borrarTodosLosPasajeros();
}
