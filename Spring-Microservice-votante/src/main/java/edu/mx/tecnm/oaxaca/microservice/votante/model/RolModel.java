package edu.mx.tecnm.oaxaca.microservice.votante.model;

import com.sun.istack.NotNull;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author macbookair
 */
@Entity
@Table(name = "rol")
public class RolModel {

    @Id
    @Column(name = "idRol")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idRol;

    @NotNull
    @Column(name = "nombre")
    private String nombre;

    public RolModel() {
    }

    public RolModel(Integer idRol, String nombre) {
        this.idRol = idRol;
        this.nombre = nombre;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "RolModel{" + 
                "idRol=" + idRol + 
                ", nombre=" + nombre + '}';
    }
    
    
}
