package edu.mx.tecnm.oaxaca.microservice.votante.controller;

import edu.mx.tecnm.oaxaca.microservice.votante.model.RolModel;
import edu.mx.tecnm.oaxaca.microservice.votante.service.RolService;
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
@RequestMapping("/autenticacion/rol")
@CrossOrigin(origins = "*")
public class RolController {

    @Autowired
    private RolService rolService;

    @PostMapping("/registrar")
    public ResponseEntity<Object> registroRol(@RequestBody RolModel rolModel) {
        ResponseEntity<Object> responseEntity = null;
        CustomResponse customResponse = new CustomResponse();
        try {
            rolService.registrarRol(rolModel);
            customResponse.setHttpCode(HttpStatus.CREATED);
            customResponse.setCode(201);
            customResponse.setMensaje("Success");
            customResponse.setData(rolModel);
            responseEntity = ResponseEntity.status(HttpStatus.CREATED).body(customResponse);
        } catch (Exception e) {
            customResponse.setHttpCode(HttpStatus.UNPROCESSABLE_ENTITY);
            customResponse.setCode(422);
            customResponse.setMensaje("UNPROCESSABLE_ENTITY" + e);
            responseEntity = ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(customResponse);
        }
        return responseEntity;
    }

    @GetMapping("/view")
    public CustomResponse getRols() {
        CustomResponse customResponse = new CustomResponse();
        if (rolService.getRols().isEmpty()) {
            customResponse.setHttpCode(HttpStatus.NO_CONTENT);
            customResponse.setMensaje("No hay Roles registrados");
        } else {
            customResponse.setData(rolService.getRols());
            customResponse.setHttpCode(HttpStatus.OK);
            customResponse.setCode(200);
            customResponse.setMensaje("Todos los registros existentes:");
        }
        return customResponse;
    }

    @GetMapping("/view/{idRol}")
    public CustomResponse getRol(@PathVariable int idRol) {
        CustomResponse customResponse = new CustomResponse();
        if (rolService.getRol(idRol) == null) {
            customResponse.setHttpCode(HttpStatus.NOT_FOUND);
            customResponse.setMensaje("No hay roles con este id:= " + idRol);
        } else {
            customResponse.setData(rolService.getRol(idRol));
            customResponse.setHttpCode(HttpStatus.OK);
            customResponse.setCode(200);
            customResponse.setMensaje("Exitoso, si hay Rol con este id:" + idRol);
        }
        return customResponse;
    }

    @PutMapping("/edit/{idRol}")
    public CustomResponse updateRol(@RequestBody RolModel rol, @PathVariable Integer idRol) {
        CustomResponse customResponse = new CustomResponse();

        rolService.updateRol(rol, idRol);
        customResponse.setHttpCode(HttpStatus.CREATED);
        customResponse.setCode(201);
        customResponse.setMensaje("Successful update");

        return customResponse;
    }

    @DeleteMapping("/delete/{idRol}")
    public CustomResponse deleteRol(@PathVariable Integer idRol) {
        CustomResponse customResponse = new CustomResponse();

        if (rolService.getRol(idRol) == null) {
            customResponse.setHttpCode(HttpStatus.NOT_FOUND);
            customResponse.setMensaje("No hay direcciones " + idRol);
        } else {
            rolService.deleteRol(idRol);
            customResponse.setHttpCode(HttpStatus.OK);
            customResponse.setCode(204);
            customResponse.setMensaje(" delete Successful");
        }
        return customResponse;
    }

}
