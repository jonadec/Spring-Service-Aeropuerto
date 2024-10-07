package edu.mx.lasalle.oaxaca.servicio.aeropuerto.service;

import edu.mx.lasalle.oaxaca.servicio.aeropuerto.model.BoletoModel;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface BoletoService {
    void registrarBoleto(BoletoModel boletoModel);
    List<BoletoModel> obtenerBoletos();
    BoletoModel getBoleto(int id);
    void actualizarDatosBoleto(BoletoModel boletoModel, int id);
    void borrarBoleto(int id);
    void borrarTodosLosBoletos();
}
