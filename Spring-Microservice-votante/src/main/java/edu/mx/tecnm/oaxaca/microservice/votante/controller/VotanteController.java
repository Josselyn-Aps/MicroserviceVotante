/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mx.tecnm.oaxaca.microservice.votante.controller;

import edu.mx.tecnm.oaxaca.microservice.votante.model.CredencialModel;
import edu.mx.tecnm.oaxaca.microservice.votante.model.DireccionModel;
import edu.mx.tecnm.oaxaca.microservice.votante.model.EmisionVotoModel;
import edu.mx.tecnm.oaxaca.microservice.votante.model.VotanteModel;
import edu.mx.tecnm.oaxaca.microservice.votante.service.CredencialService;
import edu.mx.tecnm.oaxaca.microservice.votante.service.DireccionService;
import edu.mx.tecnm.oaxaca.microservice.votante.service.EmisionVotoService;
import edu.mx.tecnm.oaxaca.microservice.votante.service.VotanteService;
import edu.mx.tecnm.oaxaca.microservice.votante.utils.CustomResponse;
import javax.validation.Valid;
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
import org.springframework.web.client.HttpClientErrorException;

/**
 *
 * @author macbookair
 */
@RestController
@RequestMapping("/votante")
//@RequestMapping(path = "/productos")
@CrossOrigin(origins = "*")
public class VotanteController {

    @Autowired
    private VotanteService votanteService;

    @Autowired
    private DireccionService direccionService;
    
    @Autowired
    private EmisionVotoService emisionVotoService;
    
    @Autowired
    private CredencialService credencialService;

    @PostMapping("/registrar")
    public ResponseEntity<Object> resgistrarVotante(@RequestBody VotanteModel votanteModel) {
         ResponseEntity<Object> responseEntity = null;
        CustomResponse customResponse = new CustomResponse();
        try {
            DireccionModel direccionModel = direccionService.getDireccion(votanteModel.getDireccionModel().getIdDireccion());
            if (direccionModel == null) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(
                        new CustomResponse(HttpStatus.NO_CONTENT, "Not found direccion with id = " + votanteModel.getDireccionModel().getIdDireccion(), 204));
            }
            
             EmisionVotoModel emisionVotoModel = emisionVotoService.getEmisionVoto(votanteModel.getEmisionVotoModel().getIdEmisionVoto());
            if (emisionVotoModel == null) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(
                        new CustomResponse(HttpStatus.NO_CONTENT, "Not found emision voto with id = " + votanteModel.getEmisionVotoModel().getIdEmisionVoto(), 204));
            }
            
              CredencialModel credencialModel = credencialService.getCredencial(votanteModel.getCredencialModel().getClaveElector());
            if (credencialModel == null) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(
                        new CustomResponse(HttpStatus.NO_CONTENT, "Not found credencial with id = " + votanteModel.getCredencialModel().getClaveElector(), 204));
            }

            votanteModel.setDireccionModel(direccionModel);
            votanteModel.setEmisionVotoModel(emisionVotoModel);
            votanteModel.setCredencialModel(credencialModel);
            votanteService.registrarVotantes(votanteModel);
            customResponse.setHttpCode(HttpStatus.CREATED);
            customResponse.setCode(201);
            customResponse.setMensaje("Success");
            customResponse.setData(votanteModel);
            responseEntity = ResponseEntity.status(HttpStatus.CREATED).body(customResponse);
            
        } catch (Exception e) {
            customResponse.setMensaje(e.getMessage());
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(
                    new CustomResponse(HttpStatus.NO_CONTENT, "CAN NOT PROCESS THE ENTITY: " + e, 422));
        }
        return responseEntity;
    }
    
    @GetMapping("/")
    public ResponseEntity<Object> getVotantes() {
        ResponseEntity<Object> responseEntity = null;
        CustomResponse customResponse = new CustomResponse();
        try {
            if (votanteService.getVotantes().isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(
                        new CustomResponse(HttpStatus.NO_CONTENT,"Not found votante  in this table", 204));
            } else {
                return ResponseEntity.status(HttpStatus.OK).body(
                        new CustomResponse(HttpStatus.OK,votanteService.getVotantes(), "Showing all", 200));
            }
        } catch (HttpClientErrorException e) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(
                    new CustomResponse(HttpStatus.UNPROCESSABLE_ENTITY,"JWT invalid or expired", 422));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(
                    new CustomResponse(HttpStatus.UNPROCESSABLE_ENTITY,e.getMessage(), 422));
        }
    }
    
        @GetMapping("/votante/{curp}")
    public ResponseEntity<Object> getVotante(@PathVariable String curp) {
        try {
            if (votanteService.getVotante(curp) == null) {
                return ResponseEntity.status(HttpStatus.OK).body(
                        new CustomResponse(HttpStatus.NO_CONTENT,
                                "Not found votante with CURP = " + curp, 204));
            } else {
                return ResponseEntity.status(HttpStatus.OK).body(
                        new CustomResponse(HttpStatus.OK,
                                votanteService.getVotante(curp),"Showing all matches votante", 200));
            }

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(
                    new CustomResponse(HttpStatus.UNPROCESSABLE_ENTITY,
                            votanteService.getVotante(curp),"Error" + e, 422));
        }
    }
    
   
    @PutMapping("/votante/{curp}")
    public ResponseEntity<Object> updateVotante(@PathVariable(value = "curp") String curp,
            @Valid @RequestBody VotanteModel votanteModel) {

        ResponseEntity<Object> responseEntity = null;
        CustomResponse customResponse = new CustomResponse();

        if (votanteService.getVotante(curp) == null) {
            customResponse.setHttpCode(HttpStatus.NOT_FOUND);
            customResponse.setMensaje("No hay votante  con esta curo:= " + curp);

        } else {
            votanteService.updateVotante(votanteModel, curp);
            customResponse.setHttpCode(HttpStatus.CREATED);
            customResponse.setCode(201);
            customResponse.setMensaje("Successful update");
        }
        return responseEntity;

    }
    @DeleteMapping("/votante/{curp}")
    public ResponseEntity<Object> deleteVotante(@PathVariable String curp) {
        ResponseEntity<Object> responseEntity = null;
        CustomResponse customResponse = new CustomResponse();
        try {
            if (votanteService.getVotante(curp) == null) {
                return ResponseEntity.status(HttpStatus.OK).body(
                        new CustomResponse(HttpStatus.NO_CONTENT,
                                "This acction can't execute, Not found votante with id = " + curp, 204));
            }
            votanteService.deleteVotante(curp);
            customResponse.setHttpCode(HttpStatus.OK);
            customResponse.setCode(200);
            customResponse.setMensaje("Delete Success");
            return ResponseEntity.status(HttpStatus.OK).body(customResponse);
        } catch (Exception e) {
            customResponse.setMensaje(e.getMessage());
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(customResponse);
        }

    }
}
