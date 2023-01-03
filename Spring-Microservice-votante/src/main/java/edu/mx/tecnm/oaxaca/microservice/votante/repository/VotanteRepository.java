package edu.mx.tecnm.oaxaca.microservice.votante.repository;

import edu.mx.tecnm.oaxaca.microservice.votante.model.VotanteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author macbookair
 */
@Repository
public interface VotanteRepository extends JpaRepository<VotanteModel, String>{
    public VotanteModel findByCurp(String curp);

}
