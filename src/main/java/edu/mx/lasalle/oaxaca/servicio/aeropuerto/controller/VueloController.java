package edu.mx.lasalle.oaxaca.servicio.aeropuerto.controller;

import edu.mx.lasalle.oaxaca.servicio.aeropuerto.model.VueloModel;
import edu.mx.lasalle.oaxaca.servicio.aeropuerto.service.VueloService;
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

@RestController
@RequestMapping("/api/v1/vuelo")
public class VueloController {
    @Autowired
    private VueloService vueloService;

    @PostMapping("/registro")
    public CustomResponse registrarVuelo(@RequestBody VueloModel vueloModel) {
        CustomResponse customResponse = new CustomResponse();
        vueloService.registrarVuelo(vueloModel);
        customResponse.setHttpCode(HttpStatus.CREATED);
        customResponse.setCode(201);
        customResponse.setMessage("VUELO REGISTRADO EXITOSAMENTE");
        return customResponse;
    }

    @GetMapping("/registros")
    public ResponseEntity<List<VueloModel>> getAllVuelos() {
        List<VueloModel> vuelos = vueloService.obtenerVuelos();
        if (vuelos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(vuelos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getVuelo(@PathVariable int id) {
        try {
            VueloModel vuelo = vueloService.getVuelo(id);
            if (vuelo == null) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new CustomResponse(HttpStatus.NO_CONTENT, "", "Vuelo no encontrado con ID=" + id, 204));
            }
            return ResponseEntity.status(HttpStatus.OK).body(new CustomResponse(HttpStatus.OK, vuelo, "Vuelo encontrado", 200));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(new CustomResponse(HttpStatus.UNPROCESSABLE_ENTITY, null, "ERROR: " + e.getMessage(), 422));
        }
    }

    @PutMapping("/{id}/actualizar")
    public ResponseEntity<Object> updateVuelo(@RequestBody VueloModel vueloModel, @PathVariable int id) {
        CustomResponse customResponse = new CustomResponse();
        try {
            if (vueloService.getVuelo(id) == null) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new CustomResponse(HttpStatus.NO_CONTENT, "", "No se puede ejecutar la acción, no se encontró con ID= " + id, 204));
            }

            vueloService.actualizarDatosVuelo(vueloModel, id);
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
    public ResponseEntity<Object> deleteVuelo(@PathVariable int id) {
        CustomResponse customResponse = new CustomResponse();
        try {
            vueloService.borrarVuelo(id);
            customResponse.setHttpCode(HttpStatus.OK);
            customResponse.setCode(200);
            customResponse.setMessage("ELIMINACIÓN EXITOSA");
            return ResponseEntity.status(HttpStatus.OK).body(customResponse);
        } catch (Exception e) {
            customResponse.setMessage("Error: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(customResponse);
        }
    }
}
