package edu.mx.lasalle.oaxaca.servicio.aeropuerto.controller;

import edu.mx.lasalle.oaxaca.servicio.aeropuerto.model.TerminalModel;
import edu.mx.lasalle.oaxaca.servicio.aeropuerto.service.TerminalService;
import edu.mx.lasalle.oaxaca.servicio.aeropuerto.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/terminal")
public class TerminalController {
    @Autowired
    private TerminalService terminalService;

    @PostMapping("/registro")
    public CustomResponse registrarTerminal(@RequestBody TerminalModel terminalModel) {
        CustomResponse customResponse = new CustomResponse();
        terminalService.registrarTerminal(terminalModel);
        customResponse.setHttpCode(HttpStatus.CREATED);
        customResponse.setCode(201);
        customResponse.setMessage("TERMINAL REGISTRADA EXITOSAMENTE");
        return customResponse;
    }

    @GetMapping("/registros")
    public ResponseEntity<List<TerminalModel>> getAllTerminales() {
        List<TerminalModel> terminales = terminalService.obtenerTerminales();
        if (terminales.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(terminales, HttpStatus.OK);
    }

    @GetMapping("/{claveTerminal}")
    public ResponseEntity<Object> getTerminal(@PathVariable int claveTerminal) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new CustomResponse(HttpStatus.OK,
                            terminalService.getTerminal(claveTerminal),
                            "Show all matches", 200
                    )
            );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(
                    new CustomResponse(HttpStatus.UNPROCESSABLE_ENTITY,
                            terminalService.getTerminal(claveTerminal),
                            "ERROR: " + e, 422
                    )
            );
        }
    }

    @PutMapping("/{claveTerminal}/actualizar")
    public ResponseEntity<Object> updateTerminal(
            @RequestBody TerminalModel terminalModel,
            @PathVariable(value = "claveTerminal") int claveTerminal) {
        ResponseEntity<Object> responseEntity = null;
        CustomResponse customResponse = new CustomResponse();

        try {
            if (terminalService.getTerminal(claveTerminal) == null) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(
                        new CustomResponse(HttpStatus.NO_CONTENT,
                                "", "This action can´t execute, not found with claveTerminal= " + claveTerminal,
                                204
                        )
                );
            }

            terminalService.actualizarDatosTerminal(terminalModel, claveTerminal);
            customResponse.setHttpCode(HttpStatus.OK);
            customResponse.setCode(200);
            customResponse.setMessage("Update success");
            return ResponseEntity.status(HttpStatus.OK).body(customResponse);

        } catch (Exception e) {
            customResponse.setMessage("Error: " + e);
            return ResponseEntity.status(HttpStatus.OK).body(customResponse);
        }
    }

    @DeleteMapping("/{claveTerminal}/borrar")
    public ResponseEntity<Object> deleteTerminal(@PathVariable int claveTerminal) {
        ResponseEntity<Object> responseEntity = null;
        CustomResponse customResponse = new CustomResponse();
        try {
            terminalService.borrarTerminal(claveTerminal);
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
