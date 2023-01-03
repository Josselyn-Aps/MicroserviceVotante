/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mx.tecnm.oaxaca.microservice.votante.controller;

import edu.mx.tecnm.oaxaca.microservice.votante.model.CredencialModel;
import edu.mx.tecnm.oaxaca.microservice.votante.model.VotanteModel;
import edu.mx.tecnm.oaxaca.microservice.votante.service.CredencialService;
import edu.mx.tecnm.oaxaca.microservice.votante.service.VotanteService;
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
@RequestMapping("/votante/credencial")
//@RequestMapping(path = "/productos")
@CrossOrigin(origins = "*")
public class CredencialController {

    @Autowired
    private CredencialService credencialService;
    @Autowired
    private VotanteService votanteService;

    @PostMapping("/direccion/votante/registrar")
    public ResponseEntity<Object> registroCredencial(@RequestBody CredencialModel credencialModel) {
        ResponseEntity<Object> responseEntity = null;
        CustomResponse customResponse = new CustomResponse();
        try {

            credencialService.registrarCredencial(credencialModel);
            customResponse.setHttpCode(HttpStatus.CREATED);
            customResponse.setCode(201);
            customResponse.setMensaje("Success");
            customResponse.setData(credencialModel);
            responseEntity = ResponseEntity.status(HttpStatus.CREATED).body(customResponse);
        } catch (Exception e) {
            customResponse.setMensaje(e.getMessage());
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(
                    new CustomResponse(HttpStatus.NO_CONTENT, "CAN NOT PROCESS THE ENTITY: " + e, 422));
        }
        return responseEntity;
    }
    

    @GetMapping("/credencial")
    public CustomResponse getCredenciales() {
        CustomResponse customResponse = new CustomResponse();

        customResponse.setData(credencialService.getCredenciales());
        customResponse.setHttpCode(HttpStatus.OK);
        customResponse.setCode(200);
        customResponse.setMensaje("Todos los registros existentes:");

        return customResponse;
    }

    @GetMapping("/credencial/{claveElector}")
    public CustomResponse getCredencial(@PathVariable String claveElector) {
        CustomResponse customResponse = new CustomResponse();

        customResponse.setData(credencialService.getCredencial(claveElector));
        customResponse.setHttpCode(HttpStatus.OK);
        customResponse.setCode(200);
        customResponse.setMensaje("Exitoso: " + claveElector);
        return customResponse;
    }

    @PutMapping("/credencial/{claveElector}")
    public CustomResponse updateCredencial(@RequestBody CredencialModel credencial, @PathVariable String claveElector) {
        CustomResponse customResponse = new CustomResponse();

        credencialService.updateCredencial(credencial, claveElector);
        customResponse.setHttpCode(HttpStatus.CREATED);
        customResponse.setCode(201);
        customResponse.setMensaje("Successful update");

        return customResponse;
    }

    @DeleteMapping("/credencial/{claveElector}")
    public CustomResponse deleteCredencial(@PathVariable String claveElector) {
        CustomResponse customResponse = new CustomResponse();

        credencialService.deleteCredencial(claveElector);
        customResponse.setHttpCode(HttpStatus.OK);
        customResponse.setCode(204);
        customResponse.setMensaje(" delete Successful");
        return customResponse;
    }
}
