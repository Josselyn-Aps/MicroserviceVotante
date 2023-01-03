package edu.mx.tecnm.oaxaca.microservice.votante.implement.service;

import edu.mx.tecnm.oaxaca.microservice.votante.model.UsuarioModel;
import edu.mx.tecnm.oaxaca.microservice.votante.repository.UsuarioRepository;
import edu.mx.tecnm.oaxaca.microservice.votante.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author macbookair
 */
@Service
public class UsuarioImplementService implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void registrarUsuario(UsuarioModel usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public List getUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public UsuarioModel getUsuario(Integer idUsuario) {
        return usuarioRepository.findByidUsuario(idUsuario);
    }

    @Override
    public void updateUsuario(UsuarioModel usuarioModel, Integer idUsuario) {
        usuarioModel.setIdUsuario(idUsuario);
        usuarioRepository.save(usuarioModel);
    }

    @Override
    public void deleteUsuario(Integer idUsuario) {
        usuarioRepository.deleteById(idUsuario);
    }

}
