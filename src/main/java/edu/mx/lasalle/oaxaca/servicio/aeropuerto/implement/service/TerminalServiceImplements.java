package edu.mx.lasalle.oaxaca.servicio.aeropuerto.implement.service;

import edu.mx.lasalle.oaxaca.servicio.aeropuerto.model.TerminalModel;
import edu.mx.lasalle.oaxaca.servicio.aeropuerto.repository.TerminalRepository;
import edu.mx.lasalle.oaxaca.servicio.aeropuerto.service.TerminalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TerminalServiceImplements implements TerminalService {
    @Autowired
    private TerminalRepository terminalRepository;

    @Override
    public void registrarTerminal(TerminalModel terminalModel) {
        terminalRepository.save(terminalModel);
    }

    @Override
    public List<TerminalModel> obtenerTerminales() {
        return terminalRepository.findAll();
    }

    @Override
    public TerminalModel getTerminal(int claveTerminal) {
        return terminalRepository.findById(claveTerminal);
    }

    @Override
    public void actualizarDatosTerminal(TerminalModel terminalModel, int claveTerminal) {
        terminalModel.setClaveTerminal(claveTerminal);
        terminalRepository.save(terminalModel);
    }

    @Override
    public void borrarTerminal(int claveTerminal) {
        terminalRepository.deleteById(claveTerminal);
    }
}
