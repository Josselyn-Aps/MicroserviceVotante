/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mx.tecnm.oaxaca.microservice.votante.implement.service;

import edu.mx.tecnm.oaxaca.microservice.votante.model.CredencialModel;
import edu.mx.tecnm.oaxaca.microservice.votante.repository.CredencialRepository;
import edu.mx.tecnm.oaxaca.microservice.votante.service.CredencialService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author macbookair
 */
@Service
public class CredencialImplementService implements CredencialService{
    @Autowired
    private CredencialRepository credencialRepository;
    
    @Override
    public void registrarCredencial(CredencialModel credencial) {
            credencialRepository.save(credencial);
    }

    @Override
    public List getCredenciales() {
    return credencialRepository.findAll();
    }

    @Override
    public CredencialModel getCredencial(String claveElector) {
    return credencialRepository.findByClaveElector(claveElector);
    }

    @Override
    public void updateCredencial(CredencialModel credencialModel, String claveElecto) {
            credencialModel.setClaveElector(claveElecto);
        credencialRepository.save(credencialModel);
    }

    @Override
    public void deleteCredencial(String claveElector) {
     credencialRepository.deleteById(claveElector);
    }

    @Override
    public CredencialModel getCoalicionfindByClaveElector(String claveElector) {
       return credencialRepository.findByClaveElector(claveElector);
    }
    
}