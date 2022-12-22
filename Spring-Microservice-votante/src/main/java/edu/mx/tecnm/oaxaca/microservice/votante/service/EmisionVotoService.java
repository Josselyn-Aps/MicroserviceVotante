/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mx.tecnm.oaxaca.microservice.votante.service;

import edu.mx.tecnm.oaxaca.microservice.votante.model.EmisionVotoModel;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author macbookair
 */
@Service
public interface EmisionVotoService {
    
    public void registrarEmisionVoto(EmisionVotoModel emisionVoto);
    public List getEmisionVotos();
    public EmisionVotoModel getEmisionVoto(String idEmisionVoto);
    public void updateEmisionVoto(EmisionVotoModel emisionVoto, String idEmisionVoto);
    public void deleteEmisionVoto(String idEmisionVoto);
}
