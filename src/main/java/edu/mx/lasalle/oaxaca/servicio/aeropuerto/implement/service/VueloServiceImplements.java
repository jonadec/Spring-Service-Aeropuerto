package edu.mx.lasalle.oaxaca.servicio.aeropuerto.implement.service;

import edu.mx.lasalle.oaxaca.servicio.aeropuerto.model.PasajeroDTO;
import edu.mx.lasalle.oaxaca.servicio.aeropuerto.model.VueloModel;
import edu.mx.lasalle.oaxaca.servicio.aeropuerto.repository.VueloRepository;
import edu.mx.lasalle.oaxaca.servicio.aeropuerto.service.VueloService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VueloServiceImplements implements VueloService {
    @Autowired
    private VueloRepository vueloRepository;
    
    public List<PasajeroDTO> obtenerNombresPasajerosPorVuelo(int vueloId) {
        VueloModel vuelo = vueloRepository.findById(vueloId);
        // Convertir los pasajeros a PasajeroDTO
        return vuelo.getBoletos().stream()
            .map(boleto -> new PasajeroDTO(boleto.getPasajero().getNombre()+" "+boleto.getPasajero().getApellido()))
            .collect(Collectors.toList());
    }

    @Override
    public void registrarVuelo(VueloModel vueloModel) {
        vueloRepository.save(vueloModel);
    }

    @Override
    public List<VueloModel> obtenerVuelos() {
        return vueloRepository.findAll();
    }

    @Override
    public VueloModel getVuelo(int id) {
        return vueloRepository.findById(id);
    }

    @Override
    public void actualizarDatosVuelo(VueloModel vueloModel, int id) {
        vueloModel.setId(id);
        vueloRepository.save(vueloModel);
    }

    @Override
    public void borrarVuelo(int id) {
        vueloRepository.deleteById(id);
    }
}
