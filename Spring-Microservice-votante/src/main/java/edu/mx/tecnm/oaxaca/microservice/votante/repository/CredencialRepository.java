/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mx.tecnm.oaxaca.microservice.votante.repository;

import edu.mx.tecnm.oaxaca.microservice.votante.model.CredencialModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author macbookair
 */
@Repository
public interface CredencialRepository extends JpaRepository<CredencialModel, String>{
    public CredencialModel findByClaveElector(String claveElector);

}