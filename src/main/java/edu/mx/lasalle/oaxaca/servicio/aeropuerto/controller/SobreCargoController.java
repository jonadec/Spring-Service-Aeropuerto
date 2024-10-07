package edu.mx.lasalle.oaxaca.servicio.aeropuerto.controller;

import edu.mx.lasalle.oaxaca.servicio.aeropuerto.model.SobreCargoModel;
import edu.mx.lasalle.oaxaca.servicio.aeropuerto.service.SobreCargoService;
import edu.mx.lasalle.oaxaca.servicio.aeropuerto.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sobrecargo")
public class SobreCargoController {

    @Autowired
    private SobreCargoService sobreCargoService;

    @PostMapping("/registro")
    public CustomResponse registrarSobreCargo(@RequestBody SobreCargoModel sobreCargoModel) {
        CustomResponse customResponse = new CustomResponse();
        sobreCargoService.registrarSobreCargo(sobreCargoModel);
        customResponse.setHttpCode(HttpStatus.CREATED);
        customResponse.setCode(201);
        customResponse.setMessage("SOBRECARGO REGISTRADO EXITOSAMENTE");
        return customResponse;
    }

    @GetMapping("/registros")
    public ResponseEntity<List<SobreCargoModel>> getAllSobreCargos() {
        List<SobreCargoModel> sobreCargos = sobreCargoService.obtenerSobreCargo();
        if (sobreCargos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(sobreCargos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getSobreCargo(@PathVariable int id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new CustomResponse(HttpStatus.OK,
                            sobreCargoService.getSobreCargo(id),
                            "Mostrar detalles del sobrecargo",
                            200
                    )
            );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(
                    new CustomResponse(HttpStatus.UNPROCESSABLE_ENTITY,
                            null,
                            "ERROR: " + e,
                            422
                    )
            );
        }
    }

    @PutMapping("/{id}/actualizar")
    public ResponseEntity<Object> updateSobreCargo(
            @RequestBody SobreCargoModel sobreCargoModel,
            @PathVariable(value = "id") int id) {
        CustomResponse customResponse = new CustomResponse();
        try {
            if (sobreCargoService.getSobreCargo(id) == null) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(
                        new CustomResponse(HttpStatus.NO_CONTENT,
                                "", "No se puede ejecutar esta acción, no encontrado con id= " + id,
                                204
                        )
                );
            }

            sobreCargoService.actualizarDatosSobreCargo(sobreCargoModel, id);
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
    public ResponseEntity<Object> deleteSobreCargo(@PathVariable int id) {
        CustomResponse customResponse = new CustomResponse();
        try {
            sobreCargoService.borrarSobreCargo(id);
            customResponse.setHttpCode(HttpStatus.OK);
            customResponse.setCode(200);
            customResponse.setMessage("ELIMINACIÓN EXITOSA");
            return ResponseEntity.status(HttpStatus.OK).body(customResponse);
        } catch (Exception e) {
            customResponse.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(customResponse);
        }
    }
}
