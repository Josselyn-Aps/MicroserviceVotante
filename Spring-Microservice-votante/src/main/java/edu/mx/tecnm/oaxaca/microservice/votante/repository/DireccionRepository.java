package edu.mx.tecnm.oaxaca.microservice.votante.repository;

import edu.mx.tecnm.oaxaca.microservice.votante.model.DireccionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author macbookair
 */
@Repository
public interface DireccionRepository extends JpaRepository<DireccionModel, Integer> {

    public DireccionModel findById(int idDireccion);
    //public DireccionModel findByNombre(String nombre);

}
