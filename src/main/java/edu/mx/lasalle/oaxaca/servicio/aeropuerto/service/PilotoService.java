/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.mx.lasalle.oaxaca.servicio.aeropuerto.service;

import edu.mx.lasalle.oaxaca.servicio.aeropuerto.model.PilotoModel;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author jonag
 */
@Service
public interface PilotoService {
    public void registrarPiloto(PilotoModel pilotomodel);
    public List obtenerPiloto();
    public PilotoModel getPiloto(int id);
    public void actualizarDatosPiloto(PilotoModel pilotomodel, int id);
    public void borrarPiloto(int id);
    public void borrarTodosLosPilotos();
}


