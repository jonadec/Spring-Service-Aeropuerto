package edu.mx.lasalle.oaxaca.servicio.aeropuerto.service;

import edu.mx.lasalle.oaxaca.servicio.aeropuerto.model.VueloModel;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface VueloService {
    void registrarVuelo(VueloModel vueloModel);
    List<VueloModel> obtenerVuelos();
    VueloModel getVuelo(int id);
    void actualizarDatosVuelo(VueloModel vueloModel, int id);
    void borrarVuelo(int id);
}
