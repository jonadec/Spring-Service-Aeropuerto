package edu.mx.lasalle.oaxaca.servicio.aeropuerto.controller;

import edu.mx.lasalle.oaxaca.servicio.aeropuerto.model.AvionetaModel;
import edu.mx.lasalle.oaxaca.servicio.aeropuerto.service.AvionetaService;
import edu.mx.lasalle.oaxaca.servicio.aeropuerto.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * @author jonag
 */

@RestController
@RequestMapping("/api/v1/avioneta")
public class AvionetaController {
    @Autowired
    private AvionetaService avionetaService;

    @PostMapping("/registro")
    public CustomResponse registrarAvioneta(@RequestBody AvionetaModel avionetaModel) {
        CustomResponse customResponse = new CustomResponse();
        avionetaService.registrarAvioneta(avionetaModel);
        customResponse.setHttpCode(HttpStatus.CREATED);
        customResponse.setCode(201);
        customResponse.setMessage("AVIONETA REGISTRADA EXITOSAMENTE");
        return customResponse;
    }

    @GetMapping("/registros")
    public ResponseEntity<List<AvionetaModel>> getAllAvionetas() {
        List<AvionetaModel> avionetas = avionetaService.obtenerAvionetas();
        if (avionetas.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(avionetas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getAvioneta(@PathVariable int id) {
        try {
            AvionetaModel avioneta = avionetaService.getAvioneta(id);
            if (avioneta == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new CustomResponse(HttpStatus.NOT_FOUND, null, "AVIONETA NO ENCONTRADA", 404));
            }
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new CustomResponse(HttpStatus.OK, avioneta, "AVIONETA ENCONTRADA", 200));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                    .body(new CustomResponse(HttpStatus.UNPROCESSABLE_ENTITY, null, "ERROR: " + e.getMessage(), 422));
        }
    }

    @PutMapping("/{id}/actualizar")
    public ResponseEntity<Object> updateAvioneta(@RequestBody AvionetaModel avionetaModel,
                                                  @PathVariable(value = "id") int id) {
        CustomResponse customResponse = new CustomResponse();
        try {
            if (avionetaService.getAvioneta(id) == null) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(
                        new CustomResponse(HttpStatus.NO_CONTENT,
                                "", "Esta acción no se puede ejecutar, no se encontró con id= " + id, 204));
            }

            avionetaService.actualizarDatosAvioneta(avionetaModel, id);
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
    public ResponseEntity<Object> deleteAvioneta(@PathVariable int id) {
        CustomResponse customResponse = new CustomResponse();
        try {
            avionetaService.borrarAvioneta(id);
            customResponse.setHttpCode(HttpStatus.OK);
            customResponse.setCode(200);
            customResponse.setMessage("BORRADO EXITOSO");
            return ResponseEntity.status(HttpStatus.OK).body(customResponse);
        } catch (Exception e) {
            customResponse.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                    .body(customResponse);
        }
    }
}
