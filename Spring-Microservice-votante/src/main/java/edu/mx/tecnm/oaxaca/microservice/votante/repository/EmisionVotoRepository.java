package edu.mx.tecnm.oaxaca.microservice.votante.repository;

import edu.mx.tecnm.oaxaca.microservice.votante.model.EmisionVotoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author macbookair
 */
@Repository
public interface EmisionVotoRepository extends JpaRepository<EmisionVotoModel, String> {

    public EmisionVotoModel findByIdEmisionVoto(String idEmisionVoto);

}
