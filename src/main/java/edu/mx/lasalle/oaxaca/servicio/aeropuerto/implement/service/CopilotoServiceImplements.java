package edu.mx.lasalle.oaxaca.servicio.aeropuerto.implement.service;

import edu.mx.lasalle.oaxaca.servicio.aeropuerto.model.CopilotoModel;
import edu.mx.lasalle.oaxaca.servicio.aeropuerto.repository.CopilotoRepository;
import edu.mx.lasalle.oaxaca.servicio.aeropuerto.service.CopilotoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jonag
 */
@Service
public class CopilotoServiceImplements implements CopilotoService {
    @Autowired
    private CopilotoRepository copilotoRepository;

    @Override
    public void registrarCopiloto(CopilotoModel copilotoModel) {
        copilotoRepository.save(copilotoModel);
    }

    @Override
    public List<CopilotoModel> obtenerCopiloto() {
        return copilotoRepository.findAll();
    }

    @Override
    public CopilotoModel getCopiloto(int id) {
        return copilotoRepository.findById(id);
    }

    @Override
    public void actualizarDatosCopiloto(CopilotoModel copilotoModel, int id) {
        copilotoModel.setId(id);
        copilotoRepository.save(copilotoModel);
    }

    @Override
    public void borrarCopiloto(int id) {
        copilotoRepository.deleteById(id);
    }

    @Override
    public void borrarTodosLosCopilotos() {
        copilotoRepository.deleteAll();
    }
}
