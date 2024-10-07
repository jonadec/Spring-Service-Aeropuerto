package edu.mx.lasalle.oaxaca.servicio.aeropuerto.service;

import edu.mx.lasalle.oaxaca.servicio.aeropuerto.model.TerminalModel;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface TerminalService {
    void registrarTerminal(TerminalModel terminalModel);
    List<TerminalModel> obtenerTerminales();
    TerminalModel getTerminal(int claveTerminal);
    void actualizarDatosTerminal(TerminalModel terminalModel, int claveTerminal);
    void borrarTerminal(int claveTerminal);
}
