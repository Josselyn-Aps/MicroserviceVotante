/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mx.tecnm.oaxaca.microservice.votante.service;

import edu.mx.tecnm.oaxaca.microservice.votante.model.RolModel;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author macbookair
 */
@Service
public interface RolService {
    public void registrarRol(RolModel rol);
    public List getRols();
    public RolModel getRol(int idRol);
    public void updateRol(RolModel rolModel, Integer idRol);
    public void deleteRol(Integer idRol);
    
}
