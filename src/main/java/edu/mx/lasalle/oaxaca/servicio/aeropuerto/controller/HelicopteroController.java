package edu.mx.lasalle.oaxaca.servicio.aeropuerto.controller;

import edu.mx.lasalle.oaxaca.servicio.aeropuerto.model.HelicopteroModel;
import edu.mx.lasalle.oaxaca.servicio.aeropuerto.service.HelicopteroService;
import edu.mx.lasalle.oaxaca.servicio.aeropuerto.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/helicoptero")
public class HelicopteroController {
    @Autowired
    private HelicopteroService helicopteroService;

    @PostMapping("/registro")
    public CustomResponse registrarHelicoptero(@RequestBody HelicopteroModel helicopteroModel) {
        CustomResponse customResponse = new CustomResponse();
        helicopteroService.registrarHelicoptero(helicopteroModel);
        customResponse.setHttpCode(HttpStatus.CREATED);
        customResponse.setCode(201);
        customResponse.setMessage("HELICÓPTERO REGISTRADO EXITOSAMENTE");
        return customResponse;
    }

    @GetMapping("/registros")
    public ResponseEntity<List<HelicopteroModel>> getAllHelicopteros() {
        List<HelicopteroModel> helicopteros = helicopteroService.obtenerHelicopteros();
        if (helicopteros.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(helicopteros, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getHelicoptero(@PathVariable int id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new CustomResponse(HttpStatus.OK,
                            helicopteroService.getHelicoptero(id),
                            "Show all matches", 200
                    )
            );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(
                    new CustomResponse(HttpStatus.UNPROCESSABLE_ENTITY,
                            helicopteroService.getHelicoptero(id),
                            "ERROR: " + e, 422
                    )
            );
        }
    }

    @PutMapping("/{id}/actualizar")
    public ResponseEntity<Object> updateHelicoptero(
            @RequestBody HelicopteroModel helicopteroModel,
            @PathVariable(value = "id") int id) {
        ResponseEntity<Object> responseEntity = null;
        CustomResponse customResponse = new CustomResponse();

        try {
            if (helicopteroService.getHelicoptero(id) == null) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(
                        new CustomResponse(HttpStatus.NO_CONTENT,
                                "", "This action can't execute, not found with id= " + id,
                                204
                        )
                );
            }

            helicopteroService.actualizarDatosHelicoptero(helicopteroModel, id);
            customResponse.setHttpCode(HttpStatus.OK);
            customResponse.setCode(200);
            customResponse.setMessage("Update success");
            return ResponseEntity.status(HttpStatus.OK).body(customResponse);

        } catch (Exception e) {
            customResponse.setMessage("Error: " + e);
            return ResponseEntity.status(HttpStatus.OK).body(customResponse);
        }
    }

    @DeleteMapping("/{id}/borrar")
    public ResponseEntity<Object> deleteHelicoptero(@PathVariable int id) {
        ResponseEntity<Object> responseEntity = null;
        CustomResponse customResponse = new CustomResponse();
        try {
            helicopteroService.borrarHelicoptero(id);
            customResponse.setHttpCode(HttpStatus.OK);
            customResponse.setCode(200);
            customResponse.setMessage("DELETE SUCCESS");
            return ResponseEntity.status(HttpStatus.OK).body(customResponse);
        } catch (Exception e) {
            customResponse.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                    .body(customResponse);
        }
    }
}
