package edu.mx.lasalle.oaxaca.servicio.aeropuerto.controller;

import edu.mx.lasalle.oaxaca.servicio.aeropuerto.model.PilotoModel;
import edu.mx.lasalle.oaxaca.servicio.aeropuerto.service.PilotoService;
import edu.mx.lasalle.oaxaca.servicio.aeropuerto.utils.CustomResponse;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jonag
 */

@RestController
@RequestMapping("/api/v1/piloto")
public class PilotoController {
    
    @Autowired
    private PilotoService pilotoService;

    @PostMapping("/registro")
    public CustomResponse registrarPiloto(@RequestBody PilotoModel pilotoModel) {
        CustomResponse customResponse = new CustomResponse();
        pilotoService.registrarPiloto(pilotoModel);
        customResponse.setHttpCode(HttpStatus.CREATED);
        customResponse.setCode(201);
        customResponse.setMessage("PILOTO REGISTRADO EXITOSAMENTE");
        return customResponse;
    }
    
    @GetMapping("/registros")
    public ResponseEntity<List<PilotoModel>> getAllPilotos() {
        List<PilotoModel> pilotos = pilotoService.obtenerPiloto();
        if (pilotos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(pilotos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getPiloto(@PathVariable int id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(
                new CustomResponse(HttpStatus.OK,
                    pilotoService.getPiloto(id),
                    "Detalles del Piloto", 200
                )
            );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(
                new CustomResponse(HttpStatus.UNPROCESSABLE_ENTITY,
                    null,
                    "ERROR: " + e.getMessage(), 422
                )
            );
        }
    }

    @PutMapping("/{id}/actualizar")
    public ResponseEntity<Object> updatePiloto(@RequestBody PilotoModel pilotoModel, @PathVariable int id) {
        CustomResponse customResponse = new CustomResponse();
        try {
            if (pilotoService.getPiloto(id) == null) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(
                    new CustomResponse(HttpStatus.NO_CONTENT,
                        "", "No se encontró el piloto con id= " + id, 204
                    )
                );
            }

            pilotoService.actualizarDatosPiloto(pilotoModel, id);
            customResponse.setHttpCode(HttpStatus.OK);
            customResponse.setCode(200);
            customResponse.setMessage("Actualización exitosa");
            return ResponseEntity.status(HttpStatus.OK).body(customResponse);

        } catch (Exception e) {
            customResponse.setMessage("Error: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(customResponse);
        }
    }

    @DeleteMapping("/{id}/borrar")
    public ResponseEntity<Object> deletePiloto(@PathVariable int id) {
        CustomResponse customResponse = new CustomResponse();
        try {
            pilotoService.borrarPiloto(id);
            customResponse.setHttpCode(HttpStatus.OK);
            customResponse.setCode(200);
            customResponse.setMessage("Piloto eliminado con éxito");
            return ResponseEntity.status(HttpStatus.OK).body(customResponse);
        } catch (Exception e) {
            customResponse.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(customResponse);
        }
    }
}
