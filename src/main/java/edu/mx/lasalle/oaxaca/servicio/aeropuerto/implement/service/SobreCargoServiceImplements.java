package edu.mx.lasalle.oaxaca.servicio.aeropuerto.implement.service;

import edu.mx.lasalle.oaxaca.servicio.aeropuerto.model.SobreCargoModel;
import edu.mx.lasalle.oaxaca.servicio.aeropuerto.repository.SobreCargoRepository;
import edu.mx.lasalle.oaxaca.servicio.aeropuerto.service.SobreCargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SobreCargoServiceImplements implements SobreCargoService {

    @Autowired
    private SobreCargoRepository sobreCargoRepository;

    @Override
    public void registrarSobreCargo(SobreCargoModel sobreCargoModel) {
        sobreCargoRepository.save(sobreCargoModel);
    }

    @Override
    public List<SobreCargoModel> obtenerSobreCargo() {
        return sobreCargoRepository.findAll();
    }

    @Override
    public SobreCargoModel getSobreCargo(int id) {
        return sobreCargoRepository.findById(id);
    }

    @Override
    public void actualizarDatosSobreCargo(SobreCargoModel sobreCargoModel, int id) {
        sobreCargoModel.setId(id);
        sobreCargoRepository.save(sobreCargoModel);
    }

    @Override
    public void borrarSobreCargo(int id) {
        sobreCargoRepository.deleteById(id);
    }

    @Override
    public void borrarTodosLosSobreCargo() {
        sobreCargoRepository.deleteAll();
    }
}
