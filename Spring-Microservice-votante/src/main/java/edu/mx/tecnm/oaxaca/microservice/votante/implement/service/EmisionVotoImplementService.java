/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mx.tecnm.oaxaca.microservice.votante.implement.service;

import edu.mx.tecnm.oaxaca.microservice.votante.model.EmisionVotoModel;
import edu.mx.tecnm.oaxaca.microservice.votante.repository.EmisionVotoRepository;
import edu.mx.tecnm.oaxaca.microservice.votante.service.EmisionVotoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author macbookair
 */
@Service
public class EmisionVotoImplementService implements EmisionVotoService {

    @Autowired
    private EmisionVotoRepository emisionVotoRepository;

    
    @Override
    public void registrarEmisionVoto(EmisionVotoModel emisionVoto) {
      emisionVotoRepository.save(emisionVoto);
    }

    @Override
    public List getEmisionVotos() {
         return emisionVotoRepository.findAll();
    }

    @Override
    public EmisionVotoModel getEmisionVoto(String idEmisionVoto) {
       return emisionVotoRepository.findByIdEmisionVoto(idEmisionVoto);
    }

    @Override
    public void updateEmisionVoto(EmisionVotoModel emisionVoto, String idEmisionVoto) {
              emisionVoto.setIdEmisionVoto(idEmisionVoto);
        emisionVotoRepository.save(emisionVoto);
    }

    @Override
    public void deleteEmisionVoto(String idEmisionVoto) {
         emisionVotoRepository.deleteById(idEmisionVoto);
    }

 

}
