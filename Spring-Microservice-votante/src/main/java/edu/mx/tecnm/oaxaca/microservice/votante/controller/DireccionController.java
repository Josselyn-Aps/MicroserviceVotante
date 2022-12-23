/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mx.tecnm.oaxaca.microservice.votante.controller;

import edu.mx.tecnm.oaxaca.microservice.votante.model.DireccionModel;
import edu.mx.tecnm.oaxaca.microservice.votante.service.DireccionService;
import edu.mx.tecnm.oaxaca.microservice.votante.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
 * @author macbookair
 */
@RestController
@RequestMapping("/votante")
//@RequestMapping(path = "/productos")
@CrossOrigin(origins = "*")
public class DireccionController {
    
    @Autowired
    private DireccionService direccionService;
    
    @PostMapping("/direccion")
    public ResponseEntity<Object> registroDirecciones(@RequestBody DireccionModel direccion) {
        ResponseEntity<Object> responseEntity = null;
        CustomResponse customResponse = new CustomResponse();
        try {
            direccionService.registrarDireccion(direccion);
            customResponse.setHttpCode(HttpStatus.CREATED);
            customResponse.setCode(201);
            customResponse.setMensaje("Success");
            customResponse.setData(direccion);
            responseEntity = ResponseEntity.status(HttpStatus.CREATED).body(customResponse);
        } catch (Exception e) {
            customResponse.setHttpCode(HttpStatus.UNPROCESSABLE_ENTITY);
            customResponse.setCode(422);
            customResponse.setMensaje("UNPROCESSABLE_ENTITY" + e);
            responseEntity = ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(customResponse);
        }
        return responseEntity;
    }

    
    @GetMapping("/direccion")
    public CustomResponse getDirecciones() {
        CustomResponse customResponse = new CustomResponse();
        if (direccionService.getDirecciones().isEmpty()) {
            customResponse.setHttpCode(HttpStatus.NO_CONTENT);
            customResponse.setMensaje("No hay direcciones registradas");
        } else {
            customResponse.setData(direccionService.getDirecciones());
            customResponse.setHttpCode(HttpStatus.OK);
            customResponse.setCode(200);
            customResponse.setMensaje("Todos los registros existentes:");
        }
        return customResponse;
    }
    
    
      @GetMapping("/direccion/{idDireccion}")
    public CustomResponse getDireccion(@PathVariable int idDireccion) {
        CustomResponse customResponse = new CustomResponse();
        if (direccionService.getDireccion(idDireccion) == null) {
            customResponse.setHttpCode(HttpStatus.NOT_FOUND);
            customResponse.setMensaje("No hay direcciones con este id:= " + idDireccion);
        } else {
            customResponse.setData(direccionService.getDireccion(idDireccion));
            customResponse.setHttpCode(HttpStatus.OK);
            customResponse.setCode(200);
            customResponse.setMensaje("Exitoso, si hay direccion con este id:" + idDireccion);
        }
        return customResponse;
    }
    
    
     @PutMapping("/direccion/{idDireccion}")
    public CustomResponse updateDirecciones(@RequestBody DireccionModel direccion, @PathVariable Integer idDireccion) {
        CustomResponse customResponse = new CustomResponse();

            direccionService.updateDireccion(direccion, idDireccion);
            customResponse.setHttpCode(HttpStatus.CREATED);
            customResponse.setCode(201);
            customResponse.setMensaje("Successful update");
        
        return customResponse;
    }
    
     @DeleteMapping("/direccion/{idDireccion}")
    public CustomResponse deleteDirecciones(@PathVariable Integer idDireccion) {
        CustomResponse customResponse = new CustomResponse();

        if (direccionService.getDireccion(idDireccion) == null) {
            customResponse.setHttpCode(HttpStatus.NOT_FOUND);
            customResponse.setMensaje("No hay direcciones " + idDireccion);
        } else {
            direccionService.deleteDireccion(idDireccion);
            customResponse.setHttpCode(HttpStatus.OK);
            customResponse.setCode(204);
            customResponse.setMensaje(" delete Successful");
        }
        return customResponse;
    }
}
