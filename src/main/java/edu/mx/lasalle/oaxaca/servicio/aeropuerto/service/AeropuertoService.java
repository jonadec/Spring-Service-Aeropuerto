/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.mx.lasalle.oaxaca.servicio.aeropuerto.service;

import edu.mx.lasalle.oaxaca.servicio.aeropuerto.model.AeropuertoModel;

import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author jonag
 */
@Service
public interface AeropuertoService {
    public void registrarAeropuerto(AeropuertoModel aeropuertoomodel);
    public List obtenerAeropuerto();
    public AeropuertoModel getAeropuerto(int id);
    public void actualizarDatosAeropuerto(AeropuertoModel aeropuertoomodel, int id);
    public void borrarAeropuerto(int id);
    public void borrarTodosLosAeropuertos();
}
