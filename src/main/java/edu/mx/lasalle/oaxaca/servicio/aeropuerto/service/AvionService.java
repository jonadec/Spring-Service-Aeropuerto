package edu.mx.lasalle.oaxaca.servicio.aeropuerto.service;

import edu.mx.lasalle.oaxaca.servicio.aeropuerto.model.AvionModel;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface AvionService {
    void registrarAvion(AvionModel avionModel);
    List<AvionModel> obtenerAviones();
    AvionModel getAvion(int id);
    void actualizarDatosAvion(AvionModel avionModel, int id);
    void borrarAvion(int id);
}
