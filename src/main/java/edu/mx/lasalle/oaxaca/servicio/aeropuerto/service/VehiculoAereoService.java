package edu.mx.lasalle.oaxaca.servicio.aeropuerto.service;

import edu.mx.lasalle.oaxaca.servicio.aeropuerto.model.VehiculoAereoModel;
import java.util.List;
import org.springframework.stereotype.Service;


@Service
public interface VehiculoAereoService {
    void registrarVehiculoAereo(VehiculoAereoModel vehiculoAereoModel);
    List<VehiculoAereoModel> obtenerVehiculosAereos();
    VehiculoAereoModel getVehiculoAereo(int id);
    void actualizarDatosVehiculoAereo(VehiculoAereoModel vehiculoAereoModel, int id);
    void borrarVehiculoAereo(int id);
}
