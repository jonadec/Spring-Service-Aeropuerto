/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.mx.lasalle.oaxaca.servicio.aeropuerto.service;


import edu.mx.lasalle.oaxaca.servicio.aeropuerto.model.TripulacionModel;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author jonag
 */
@Service
public interface TripulacionService {
    public void registrarTripulacion(TripulacionModel tripulacionmodel);
    public List obtenerTripulacion();
    public TripulacionModel getTripulacion(int id);
    public void actualizarDatosTripulacion(TripulacionModel tripulacionmodel, int id);
    public void borrarTripulacion(int id);
    public void borrarTodaLaTripulacion();
}
