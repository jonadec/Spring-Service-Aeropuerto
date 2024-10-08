package edu.mx.lasalle.oaxaca.servicio.aeropuerto.service;

import edu.mx.lasalle.oaxaca.servicio.aeropuerto.model.PasajeroDTO;
import edu.mx.lasalle.oaxaca.servicio.aeropuerto.model.VueloModel;
import edu.mx.lasalle.oaxaca.servicio.aeropuerto.repository.VueloRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface VueloService {
    void registrarVuelo(VueloModel vueloModel);
    List<VueloModel> obtenerVuelos();
    VueloModel getVuelo(int id);
    void actualizarDatosVuelo(VueloModel vueloModel, int id);
    void borrarVuelo(int id);
    List<PasajeroDTO> obtenerNombresPasajerosPorVuelo(int id);
    
}
