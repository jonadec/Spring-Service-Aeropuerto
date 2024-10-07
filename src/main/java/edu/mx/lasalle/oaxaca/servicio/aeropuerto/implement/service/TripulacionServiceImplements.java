/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.mx.lasalle.oaxaca.servicio.aeropuerto.implement.service;

import edu.mx.lasalle.oaxaca.servicio.aeropuerto.model.TripulacionModel;
import edu.mx.lasalle.oaxaca.servicio.aeropuerto.repository.TripulacionRepository;
import edu.mx.lasalle.oaxaca.servicio.aeropuerto.service.TripulacionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jonag
 */
@Service
public class TripulacionServiceImplements implements TripulacionService{
    @Autowired
    private TripulacionRepository tripulacionRepository;

    @Override
    public void registrarTripulacion(TripulacionModel tripulacionModel) {
       tripulacionRepository.save(tripulacionModel); 
    }

    @Override
    public List obtenerTripulacion() {
        return tripulacionRepository.findAll();
    }

    @Override
    public TripulacionModel getTripulacion(int id) {
         return tripulacionRepository.findById(id);
    }

    @Override
    public void actualizarDatosTripulacion(TripulacionModel tripulacionmodel, int id) {
      tripulacionmodel.setId(id);
      tripulacionRepository.save(tripulacionmodel);
    }

    @Override
    public void borrarTripulacion(int id) {
        tripulacionRepository.deleteById(id);
    }

    @Override
    public void borrarTodaLaTripulacion() {
        tripulacionRepository.deleteAll();
    }
    
}
