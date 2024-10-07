/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.mx.lasalle.oaxaca.servicio.aeropuerto.controller;

import edu.mx.lasalle.oaxaca.servicio.aeropuerto.model.EquipajeModel;
import edu.mx.lasalle.oaxaca.servicio.aeropuerto.model.PasajeroModel;
import edu.mx.lasalle.oaxaca.servicio.aeropuerto.service.EquipajeService;
import edu.mx.lasalle.oaxaca.servicio.aeropuerto.service.PasajeroService;
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
@RequestMapping("/api/v1/equipaje")
public class EquipajeController {
    @Autowired
    private EquipajeService equipajeservice;
    @PostMapping("/registro")
    public CustomResponse registrarEquipaje(@RequestBody EquipajeModel equipajemodel){
        CustomResponse customResponse=new CustomResponse();
        equipajeservice.registrarEquipaje(equipajemodel);
        customResponse.setHttpCode(HttpStatus.CREATED);
        customResponse.setCode(201);
        customResponse.setMessage("EQUIPAJE REGISTRADO EXITOSAMENTE");
        return customResponse;
    }
    
    @GetMapping("/registros")
    public ResponseEntity<List<EquipajeModel>> getAllEquipaje(){
        List<EquipajeModel> equipaje=equipajeservice.obtenerEquipajes();
        if(equipaje.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(equipaje, HttpStatus.OK);
    }
    @GetMapping("/(id)")
    
    public ResponseEntity<Object> getEquipaje (@PathVariable int id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(
                    new CustomResponse(HttpStatus.OK,
                            equipajeservice.getEquipaje(id),
                            "Show all matches",200
        
                    )
            );
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(
                    new CustomResponse(HttpStatus.UNPROCESSABLE_ENTITY,
                            equipajeservice.getEquipaje(id),
                            "ERROR: "+e,422
                    )
            );
        }
    }
    
    @PutMapping("/(id)/actualizar")
    public ResponseEntity<Object>updateEquipaje(
    
            @RequestBody EquipajeModel equipajemodel,
            @PathVariable (value="id") int id){
        ResponseEntity<Object> responseEntity=null;
        CustomResponse customResponse = new CustomResponse();
        
        try {
            if(equipajeservice.getEquipaje(id)==null){
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(
                        new CustomResponse(HttpStatus.NO_CONTENT,
                        "", "This action can´t execute, not found with id= "+id,
                         204
                        )
                );
            }
            
            equipajeservice.actualizarDatosEquipaje(equipajemodel, id);
            customResponse.setHttpCode(HttpStatus.OK);
            customResponse.setCode(200);
            customResponse.setMessage("Update success");
            return ResponseEntity.status(HttpStatus.OK).body(customResponse);
            
        } catch (Exception e) {
            customResponse.setMessage("Error: "+e);
            return ResponseEntity.status(HttpStatus.OK).body(customResponse);
            
        }
    }
    
    
    @DeleteMapping("/(id)/borrar")
    public ResponseEntity<Object> deleteEquipaje(@PathVariable int id){
        ResponseEntity<Object> responseEntity=null;
        CustomResponse customResponse=new CustomResponse();
        try {
            equipajeservice.borrarEquipaje(id);
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
