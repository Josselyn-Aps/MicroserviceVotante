package edu.mx.tecnm.oaxaca.microservice.votante.service;

import edu.mx.tecnm.oaxaca.microservice.votante.model.DireccionModel;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author macbookair
 */
@Service
public interface DireccionService {

    public void registrarDireccion(DireccionModel direccion);

    public List getDirecciones();

    public DireccionModel getDireccion(int idDireccion);

    public void updateDireccion(DireccionModel direccion, Integer idDireccion);

    public void deleteDireccion(Integer idDireccion);
    // public DireccionModel getDireccionfindByCP(int cp);
}
