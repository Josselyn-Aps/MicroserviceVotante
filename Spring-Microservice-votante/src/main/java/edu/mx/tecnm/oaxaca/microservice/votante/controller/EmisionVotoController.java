/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mx.tecnm.oaxaca.microservice.votante.controller;

import edu.mx.tecnm.oaxaca.microservice.votante.model.EmisionVotoModel;
import edu.mx.tecnm.oaxaca.microservice.votante.model.VotanteModel;
import edu.mx.tecnm.oaxaca.microservice.votante.service.EmisionVotoService;
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
import org.springframework.web.client.HttpClientErrorException;

/**
 *
 * @author macbookair
 */
@RestController
@RequestMapping("/votante")
//@RequestMapping(path = "/productos")
@CrossOrigin(origins = "*")
public class EmisionVotoController {

    @Autowired
    private EmisionVotoService emisionVotoService;
    
     @Autowired
    private VotanteService votanteService;

    @PostMapping("/emisionVoto")
    public ResponseEntity<Object> registerJourney(@RequestBody EmisionVotoModel emisionVotoModel) {
        ResponseEntity<Object> responseEntity = null;
        CustomResponse customResponse = new CustomResponse();
        try {
            VotanteModel votanteModel = votanteService.getVotante(emisionVotoModel.getVotanteModel().getCurp());
            if (votanteModel == null) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(
                        new CustomResponse(HttpStatus.NO_CONTENT, "Not found direccion with id = " + emisionVotoModel.getVotanteModel().getCurp(), 204));
            }
            emisionVotoModel.setVotanteModel(votanteModel);
            emisionVotoService.registrarEmisionVoto(emisionVotoModel);
            customResponse.setHttpCode(HttpStatus.CREATED);
            customResponse.setCode(201);
            customResponse.setMensaje("Success");
            customResponse.setData(emisionVotoModel);
            responseEntity = ResponseEntity.status(HttpStatus.CREATED).body(customResponse);
        } catch (Exception e) {
            customResponse.setHttpCode(HttpStatus.UNPROCESSABLE_ENTITY);
            customResponse.setCode(422);
            customResponse.setMensaje("UNPROCESSABLE_ENTITY" + e);
            responseEntity = ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(customResponse);
        }
        return responseEntity;
    }

    @GetMapping("/emisionVoto")
    public ResponseEntity<Object> getEmisionVotos() {
        ResponseEntity<Object> responseEntity = null;
        CustomResponse customResponse = new CustomResponse();
        try {
            if (emisionVotoService.getEmisionVotos().isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(
                        new CustomResponse(HttpStatus.NO_CONTENT,
                                "Not found emision voto in this table", 204));
            } else {
                return ResponseEntity.status(HttpStatus.OK).body(
                        new CustomResponse(HttpStatus.OK,
                                emisionVotoService.getEmisionVotos(), "Showing all", 200));
            }
        } catch (HttpClientErrorException e) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(
                    new CustomResponse(HttpStatus.UNPROCESSABLE_ENTITY,
                            "JWT invalid or expired", 422));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(
                    new CustomResponse(HttpStatus.UNPROCESSABLE_ENTITY,
                            e.getMessage(), 422));
        }
    }

    @GetMapping("/emisionVoto/{idEmisionVoto}")
    public ResponseEntity<Object> getEmisionVoto(@PathVariable String idEmisionVoto) {
        try {
            if (emisionVotoService.getEmisionVoto(idEmisionVoto) == null) {
                return ResponseEntity.status(HttpStatus.OK).body(
                        new CustomResponse(HttpStatus.NO_CONTENT,
                                "Not found EmisionVoto with id = " + idEmisionVoto, 204));
            } else {
                return ResponseEntity.status(HttpStatus.OK).body(
                        new CustomResponse(HttpStatus.OK,
                                emisionVotoService.getEmisionVoto(idEmisionVoto),
                                "Showing all matches emision voto", 200));
            }

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(
                    new CustomResponse(HttpStatus.UNPROCESSABLE_ENTITY,
                            emisionVotoService.getEmisionVoto(idEmisionVoto),
                            "Error" + e, 422));
        }
    }

}
