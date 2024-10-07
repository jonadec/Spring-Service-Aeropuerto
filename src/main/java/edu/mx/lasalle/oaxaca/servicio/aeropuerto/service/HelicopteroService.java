package edu.mx.lasalle.oaxaca.servicio.aeropuerto.service;

import edu.mx.lasalle.oaxaca.servicio.aeropuerto.model.HelicopteroModel;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface HelicopteroService {
    void registrarHelicoptero(HelicopteroModel helicopteroModel);
    List<HelicopteroModel> obtenerHelicopteros();
    HelicopteroModel getHelicoptero(int id);
    void actualizarDatosHelicoptero(HelicopteroModel helicopteroModel, int id);
    void borrarHelicoptero(int id);
    void borrarTodosLosHelicopteros();
}
