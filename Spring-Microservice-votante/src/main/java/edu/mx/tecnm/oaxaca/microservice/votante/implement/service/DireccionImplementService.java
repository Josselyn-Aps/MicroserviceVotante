/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mx.tecnm.oaxaca.microservice.votante.implement.service;

import edu.mx.tecnm.oaxaca.microservice.votante.model.DireccionModel;
import edu.mx.tecnm.oaxaca.microservice.votante.repository.DireccionRepository;
import edu.mx.tecnm.oaxaca.microservice.votante.service.DireccionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author macbookair
 */
@Service
public class DireccionImplementService implements DireccionService {
    @Autowired
    private DireccionRepository direccionRepository;
    @Override
    public void registrarDireccion(DireccionModel direccion) {
         direccionRepository.save(direccion);
    }

    @Override
    public List getDirecciones() {
    return direccionRepository.findAll();
    }

    @Override
    public DireccionModel getDireccion(int idDireccion) {
      return direccionRepository.findById(idDireccion);
    }

    @Override
    public void updateDireccion(DireccionModel direccion, Integer idDireccion) {
     direccion.setIdDireccion(idDireccion);
        direccionRepository.save(direccion);

    }

    @Override
    public void deleteDireccion(Integer idDireccion) {
         direccionRepository.deleteById(idDireccion);
    }
    
   /* @Override
    public CoalicionModel getCoalicionfindByNombre(String nombreEleccion) {
        return coalicionRepository.findByNombre(nombreEleccion);
    }*/
    
}
