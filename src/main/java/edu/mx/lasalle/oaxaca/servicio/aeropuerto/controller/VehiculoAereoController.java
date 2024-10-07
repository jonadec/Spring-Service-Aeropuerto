package edu.mx.lasalle.oaxaca.servicio.aeropuerto.controller;

import edu.mx.lasalle.oaxaca.servicio.aeropuerto.model.VehiculoAereoModel;
import edu.mx.lasalle.oaxaca.servicio.aeropuerto.service.VehiculoAereoService;
import edu.mx.lasalle.oaxaca.servicio.aeropuerto.utils.CustomResponse;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/vehiculo-aereo")
public class VehiculoAereoController {
    @Autowired
    private VehiculoAereoService vehiculoAereoService;

    @PostMapping("/registro")
    public CustomResponse registrarVehiculoAereo(@RequestBody VehiculoAereoModel vehiculoAereoModel) {
        CustomResponse customResponse = new CustomResponse();
        vehiculoAereoService.registrarVehiculoAereo(vehiculoAereoModel);
        customResponse.setHttpCode(HttpStatus.CREATED);
        customResponse.setCode(201);
        customResponse.setMessage("VEHÍCULO AÉREO REGISTRADO EXITOSAMENTE");
        return customResponse;
    }

    @GetMapping("/registros")
    public ResponseEntity<List<VehiculoAereoModel>> getAllVehiculosAereos() {
        List<VehiculoAereoModel> vehiculos = vehiculoAereoService.obtenerVehiculosAereos();
        if (vehiculos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(vehiculos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getVehiculoAereo(@PathVariable int id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new CustomResponse(HttpStatus.OK,
                            vehiculoAereoService.getVehiculoAereo(id),
                            "Mostrar detalles", 200
                    )
            );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(
                    new CustomResponse(HttpStatus.UNPROCESSABLE_ENTITY,
                            vehiculoAereoService.getVehiculoAereo(id),
                            "ERROR: " + e, 422
                    )
            );
        }
    }

    @PutMapping("/{id}/actualizar")
    public ResponseEntity<Object> updateVehiculoAereo(
            @RequestBody VehiculoAereoModel vehiculoAereoModel,
            @PathVariable(value = "id") int id) {
        ResponseEntity<Object> responseEntity = null;
        CustomResponse customResponse = new CustomResponse();

        try {
            if (vehiculoAereoService.getVehiculoAereo(id) == null) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(
                        new CustomResponse(HttpStatus.NO_CONTENT,
                                "", "Esta acción no se puede ejecutar, no se encontró con id= " + id,
                                204
                        )
                );
            }

            vehiculoAereoService.actualizarDatosVehiculoAereo(vehiculoAereoModel, id);
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
    public ResponseEntity<Object> deleteVehiculoAereo(@PathVariable int id) {
        ResponseEntity<Object> responseEntity = null;
        CustomResponse customResponse = new CustomResponse();
        try {
            vehiculoAereoService.borrarVehiculoAereo(id);
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
