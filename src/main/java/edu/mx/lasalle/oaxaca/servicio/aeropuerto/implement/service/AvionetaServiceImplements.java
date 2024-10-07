package edu.mx.lasalle.oaxaca.servicio.aeropuerto.implement.service;

import edu.mx.lasalle.oaxaca.servicio.aeropuerto.model.AvionetaModel;
import edu.mx.lasalle.oaxaca.servicio.aeropuerto.repository.AvionetaRepository;
import edu.mx.lasalle.oaxaca.servicio.aeropuerto.service.AvionetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvionetaServiceImplements implements AvionetaService {
    @Autowired
    private AvionetaRepository avionetaRepository;

    @Override
    public void registrarAvioneta(AvionetaModel avionetaModel) {
        avionetaRepository.save(avionetaModel);
    }

    @Override
    public List<AvionetaModel> obtenerAvionetas() {
        return avionetaRepository.findAll();
    }

    @Override
    public AvionetaModel getAvioneta(int id) {
        return avionetaRepository.findById(id); // Cambiado para devolver null si no se encuentra
    }

    @Override
    public void actualizarDatosAvioneta(AvionetaModel avionetaModel, int id) {
        avionetaModel.setId(id);
        avionetaRepository.save(avionetaModel);
    }

    @Override
    public void borrarAvioneta(int id) {
        avionetaRepository.deleteById(id);
    }

    @Override
    public void borrarTodasLasAvionetas() {
        avionetaRepository.deleteAll();
    }
}
