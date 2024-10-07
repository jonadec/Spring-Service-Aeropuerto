/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.mx.lasalle.oaxaca.servicio.aeropuerto.service;

import edu.mx.lasalle.oaxaca.servicio.aeropuerto.model.CopilotoModel;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author jonag
 */
@Service
public interface CopilotoService {
    public void registrarCopiloto(CopilotoModel copilotomodel);
    public List obtenerCopiloto();
    public CopilotoModel getCopiloto(int id);
    public void actualizarDatosCopiloto(CopilotoModel copilotomodel, int id);
    public void borrarCopiloto(int id);
    public void borrarTodosLosCopilotos();
}
