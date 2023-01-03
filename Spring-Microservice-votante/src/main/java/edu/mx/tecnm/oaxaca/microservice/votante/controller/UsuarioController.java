package edu.mx.tecnm.oaxaca.microservice.votante.controller;

import edu.mx.tecnm.oaxaca.microservice.votante.model.RolModel;
import edu.mx.tecnm.oaxaca.microservice.votante.model.UsuarioModel;
import edu.mx.tecnm.oaxaca.microservice.votante.service.RolService;
import edu.mx.tecnm.oaxaca.microservice.votante.service.UsuarioService;
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
@RequestMapping("/autenticacion/usuario")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private RolService rolService;

    @PostMapping("/registrar")
    public ResponseEntity<Object> registroUsuario(@RequestBody UsuarioModel usuarioModel) {
        ResponseEntity<Object> responseEntity = null;
        CustomResponse customResponse = new CustomResponse();
        try {
            RolModel rolModel = rolService.getRol(usuarioModel.getRolModel().getIdRol());
            if (rolModel == null) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(
                        new CustomResponse(HttpStatus.NO_CONTENT, "Not found with id = " + usuarioModel.getRolModel().getIdRol(), 204));
            }
            usuarioModel.setRolModel(rolModel);
            usuarioService.registrarUsuario(usuarioModel);
            customResponse.setHttpCode(HttpStatus.CREATED);
            customResponse.setCode(201);
            customResponse.setMensaje("Success");
            customResponse.setData(usuarioModel);
            responseEntity = ResponseEntity.status(HttpStatus.CREATED).body(customResponse);

        } catch (Exception e) {
            customResponse.setMensaje(e.getMessage());
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(
                    new CustomResponse(HttpStatus.NO_CONTENT, "CAN NOT PROCESS THE ENTITY: " + e, 422));
        }
        return responseEntity;
    }

    @GetMapping("/viewUser")
    public CustomResponse getUsuarios() {
        CustomResponse customResponse = new CustomResponse();

        customResponse.setData(usuarioService.getUsuarios());
        customResponse.setHttpCode(HttpStatus.OK);
        customResponse.setCode(200);
        customResponse.setMensaje("Todos los registros existentes:");

        return customResponse;
    }

    @GetMapping("/viewUser/{idUsuario}")
    public CustomResponse getUsuario(@PathVariable int idUsuario) {
        CustomResponse customResponse = new CustomResponse();

        customResponse.setData(usuarioService.getUsuario(idUsuario));
        customResponse.setHttpCode(HttpStatus.OK);
        customResponse.setCode(200);
        customResponse.setMensaje("Exitoso: " + idUsuario);
        return customResponse;
    }

    @PutMapping("/edit/{idUsuario}")
    public CustomResponse updateUsuario(@RequestBody UsuarioModel usuario, @PathVariable int idUsuario) {
        CustomResponse customResponse = new CustomResponse();

        usuarioService.updateUsuario(usuario, idUsuario);
        customResponse.setHttpCode(HttpStatus.CREATED);
        customResponse.setCode(201);
        customResponse.setMensaje("Successful update");

        return customResponse;
    }

    @DeleteMapping("/delete/{idUsuario}")
    public ResponseEntity<Object> deleteUsuario(@PathVariable int idUsuario) {
        ResponseEntity<Object> responseEntity = null;
        CustomResponse customResponse = new CustomResponse();
        try {
            usuarioService.deleteUsuario(idUsuario);
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
