package edu.mx.tecnm.oaxaca.microservice.votante.implement.service;

import edu.mx.tecnm.oaxaca.microservice.votante.model.RolModel;
import edu.mx.tecnm.oaxaca.microservice.votante.repository.RolRepository;
import edu.mx.tecnm.oaxaca.microservice.votante.service.RolService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author macbookair
 */
@Service
public class RolImplementService implements RolService {

    @Autowired
    private RolRepository rolRepository;

    @Override
    public void registrarRol(RolModel rol) {
        rolRepository.save(rol);
    }

    @Override
    public List getRols() {
        return rolRepository.findAll();
    }

    @Override
    public RolModel getRol(int idRol) {
        return rolRepository.findByidRol(idRol);
    }

    @Override
    public void updateRol(RolModel rolModel, Integer idRol) {
        rolModel.setIdRol(idRol);
        rolRepository.save(rolModel);
    }

    @Override
    public void deleteRol(Integer idRol) {
        rolRepository.deleteById(idRol);
    }

}
