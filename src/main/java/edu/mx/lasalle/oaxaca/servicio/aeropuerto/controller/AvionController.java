package edu.mx.lasalle.oaxaca.servicio.aeropuerto.controller;

import edu.mx.lasalle.oaxaca.servicio.aeropuerto.model.AvionModel;
import edu.mx.lasalle.oaxaca.servicio.aeropuerto.service.AvionService;
import edu.mx.lasalle.oaxaca.servicio.aeropuerto.utils.CustomResponse;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/avion")
public class AvionController {
    @Autowired
    private AvionService avionService;

    @PostMapping("/registro")
    public CustomResponse registrarAvion(@RequestBody AvionModel avionModel) {
        CustomResponse customResponse = new CustomResponse();
        avionService.registrarAvion(avionModel);
        customResponse.setHttpCode(HttpStatus.CREATED);
        customResponse.setCode(201);
        customResponse.setMessage("AVIÓN REGISTRADO EXITOSAMENTE");
        return customResponse;
    }

    @GetMapping("/registros")
    public ResponseEntity<List<AvionModel>> getAllAviones() {
        List<AvionModel> aviones = avionService.obtenerAviones();
        if (aviones.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(aviones, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getAvion(@PathVariable int id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new CustomResponse(HttpStatus.OK,
                            avionService.getAvion(id),
                            "Mostrar detalles", 200
                    )
            );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(
                    new CustomResponse(HttpStatus.UNPROCESSABLE_ENTITY,
                            avionService.getAvion(id),
                            "ERROR: " + e, 422
                    )
            );
        }
    }

    @PutMapping("/{id}/actualizar")
    public ResponseEntity<Object> updateAvion(
            @RequestBody AvionModel avionModel,
            @PathVariable(value = "id") int id) {
        ResponseEntity<Object> responseEntity = null;
        CustomResponse customResponse = new CustomResponse();

        try {
            if (avionService.getAvion(id) == null) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(
                        new CustomResponse(HttpStatus.NO_CONTENT,
                                "", "Esta acción no se puede ejecutar, no se encontró con id= " + id,
                                204
                        )
                );
            }

            avionService.actualizarDatosAvion(avionModel, id);
            customResponse.setHttpCode(HttpStatus.OK);
            customResponse.setCode(200);
            customResponse.setMessage("Actualización exitosa");
            return ResponseEntity.status(HttpStatus.OK).body(customResponse);

        } catch (Exception e) {
            customResponse.setMessage("Error: " + e);
            return ResponseEntity.status(HttpStatus.OK).body(customResponse);
        }
    }

    @DeleteMapping("/{id}/borrar")
    public ResponseEntity<Object> deleteAvion(@PathVariable int id) {
        ResponseEntity<Object> responseEntity = null;
        CustomResponse customResponse = new CustomResponse();
        try {
            avionService.borrarAvion(id);
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
