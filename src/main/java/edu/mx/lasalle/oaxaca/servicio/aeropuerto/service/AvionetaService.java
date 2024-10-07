package edu.mx.lasalle.oaxaca.servicio.aeropuerto.service;

import edu.mx.lasalle.oaxaca.servicio.aeropuerto.model.AvionetaModel;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface AvionetaService {
    void registrarAvioneta(AvionetaModel avionetaModel);
    List<AvionetaModel> obtenerAvionetas();
    AvionetaModel getAvioneta(int id);
    void actualizarDatosAvioneta(AvionetaModel avionetaModel, int id);
    void borrarAvioneta(int id);
    void borrarTodasLasAvionetas();
}
