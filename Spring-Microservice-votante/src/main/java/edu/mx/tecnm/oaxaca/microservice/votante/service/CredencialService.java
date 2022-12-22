/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mx.tecnm.oaxaca.microservice.votante.service;

import edu.mx.tecnm.oaxaca.microservice.votante.model.CredencialModel;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author macbookair
 */
@Service
public interface CredencialService {
    
    public void registrarCredencial(CredencialModel credencial);
    public List getCredenciales();
    public CredencialModel getCredencial(String claveElector);
    public void updateCredencial(CredencialModel credencialModel, String claveElecto);
    public void deleteCredencial(String claveElecto);
    public CredencialModel getCoalicionfindByClaveElector(String claveElector);
}
