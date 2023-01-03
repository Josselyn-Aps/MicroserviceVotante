/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mx.tecnm.oaxaca.microservice.votante.service;

import edu.mx.tecnm.oaxaca.microservice.votante.model.VotanteModel;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author macbookair
 */
@Service
public interface VotanteService {
    public void registrarVotantes(VotanteModel votanteModel);
    public List getVotantes();
    public VotanteModel getVotante(String curp);
    public void updateVotante(VotanteModel votanteModel, String curp);
    public void deleteVotante(String curp);
    public VotanteModel getCVotantefindByCurp(String curp);
}
