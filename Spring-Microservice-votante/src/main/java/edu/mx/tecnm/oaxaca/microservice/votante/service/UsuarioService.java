/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mx.tecnm.oaxaca.microservice.votante.service;

import edu.mx.tecnm.oaxaca.microservice.votante.model.UsuarioModel;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author macbookair
 */
@Service
public interface UsuarioService {
    
    public void registrarUsuario(UsuarioModel usuario);
    public List getUsuarios();
    public UsuarioModel getUsuario(Integer idUsuario);
    public void updateUsuario(UsuarioModel usuarioModel, Integer idUsuario);
    public void deleteUsuario(Integer idUsuario);
}
