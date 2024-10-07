/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.mx.lasalle.oaxaca.servicio.aeropuerto.implement.service;

import edu.mx.lasalle.oaxaca.servicio.aeropuerto.model.AeropuertoModel;
import edu.mx.lasalle.oaxaca.servicio.aeropuerto.repository.AeropuertoRepository;
import edu.mx.lasalle.oaxaca.servicio.aeropuerto.service.AeropuertoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jonag
 */

@Service
public class AeropuertoServiceImplements implements AeropuertoService {
    @Autowired
    private AeropuertoRepository aeropuertoRepository;

    @Override
    public void registrarAeropuerto(AeropuertoModel aeropuertoModel){
        aeropuertoRepository.save(aeropuertoModel);
    }

    @Override
    public List<AeropuertoModel> obtenerAeropuerto() {
        return aeropuertoRepository.findAll();
    }

    @Override
    public AeropuertoModel getAeropuerto(int id) {
        return aeropuertoRepository.findById(id);
    }

    @Override
    public void actualizarDatosAeropuerto(AeropuertoModel aeropuertoModel, int id) {
        aeropuertoModel.setClaveAeropuerto(id);
        aeropuertoRepository.save(aeropuertoModel);
    }

    @Override
    public void borrarAeropuerto(int id) {
        aeropuertoRepository.deleteById(id);
    }

    @Override
    public void borrarTodosLosAeropuertos() {
        aeropuertoRepository.deleteAll();
    }
}
