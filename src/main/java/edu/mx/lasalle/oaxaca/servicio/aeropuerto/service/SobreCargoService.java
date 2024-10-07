/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.mx.lasalle.oaxaca.servicio.aeropuerto.service;


import edu.mx.lasalle.oaxaca.servicio.aeropuerto.model.SobreCargoModel;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author jonag
 */
@Service
public interface SobreCargoService {
    public void registrarSobreCargo(SobreCargoModel sobrecargomodel);
    public List obtenerSobreCargo();
    public SobreCargoModel getSobreCargo(int id);
    public void actualizarDatosSobreCargo(SobreCargoModel sobrecargomodel, int id);
    public void borrarSobreCargo(int id);
    public void borrarTodosLosSobreCargo();
}
