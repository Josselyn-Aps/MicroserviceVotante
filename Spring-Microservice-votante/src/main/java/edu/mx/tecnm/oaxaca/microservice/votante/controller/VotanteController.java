/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mx.tecnm.oaxaca.microservice.votante.controller;

import edu.mx.tecnm.oaxaca.microservice.votante.model.DireccionModel;
import edu.mx.tecnm.oaxaca.microservice.votante.model.VotanteModel;
import edu.mx.tecnm.oaxaca.microservice.votante.service.DireccionService;
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
public class VotanteController {

    @Autowired
    private VotanteService votanteService;

    @Autowired
    private DireccionService direccionService;

    @PostMapping("/registrar")
    public ResponseEntity<Object> resgistrarVotante(@RequestBody VotanteModel votanteModel) {
        ResponseEntity<Object> responseEntity = null;
        CustomResponse customResponse = new CustomResponse();
        try {
            DireccionModel direccionModel = direccionService.getDireccion(
                    votanteModel.getDireccionModel().getIdDireccion());
            if (direccionModel == null) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(
                        new CustomResponse(HttpStatus.NO_CONTENT, "Not found VOTANTE with id = " + votanteModel.getDireccionModel().getIdDireccion(), 204));
            }

            votanteModel.setDireccionModel(direccionModel);
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
    
      @GetMapping("/all")
    public CustomResponse getVotantes() {
        CustomResponse customResponse = new CustomResponse();

        customResponse.setData(votanteService.getVotantes());
        customResponse.setHttpCode(HttpStatus.OK);
        customResponse.setCode(200);
        customResponse.setMensaje("Todos los registros existentes:");

        return customResponse;
    }
    
      @GetMapping("/votante/{curp}")
    public CustomResponse getVotante(@PathVariable String curp) {
        CustomResponse customResponse = new CustomResponse();

        customResponse.setData(votanteService.getVotante(curp));
        customResponse.setHttpCode(HttpStatus.OK);
        customResponse.setCode(200);
        customResponse.setMensaje("Exitoso: " + curp);
        return customResponse;
    }
  

   
    
        @DeleteMapping("/delete/{curp}")
    public ResponseEntity<Object> deleteEmisionVoto(@PathVariable String curp) {
        ResponseEntity<Object> responseEntity = null;
        CustomResponse customResponse = new CustomResponse();
        try {
            if (votanteService.getVotante(curp) == null) {
                return ResponseEntity.status(HttpStatus.OK).body(
                        new CustomResponse(HttpStatus.NO_CONTENT,
                                "This acction can't execute, Not found votante with curp = " + curp, 204));
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
