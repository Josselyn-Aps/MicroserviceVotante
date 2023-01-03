/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mx.tecnm.oaxaca.microservice.votante.implement.service;

import edu.mx.tecnm.oaxaca.microservice.votante.model.VotanteModel;
import edu.mx.tecnm.oaxaca.microservice.votante.repository.VotanteRepository;
import edu.mx.tecnm.oaxaca.microservice.votante.service.VotanteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author macbookair
 */
@Service
public class VotanteImplementService implements VotanteService {

    @Autowired
    private VotanteRepository votanteRepository;

    @Override
    public void registrarVotantes(VotanteModel votanteModel) {
      votanteRepository.save(votanteModel);
    }

    @Override
    public List getVotantes() {
      return votanteRepository.findAll();
    }

    @Override
    public VotanteModel getVotante(String curp) {
    return votanteRepository.findByCurp(curp);
    }

    @Override
    public void updateVotante(VotanteModel votanteModel, String curp) {
       votanteModel.setCurp(curp);
        votanteRepository.save(votanteModel);
    }

    @Override
    public void deleteVotante(String curp) {
     votanteRepository.deleteById(curp);
    }

    @Override
    public VotanteModel getCVotantefindByCurp(String curp) {
      return votanteRepository.findByCurp(curp);
    }

}
