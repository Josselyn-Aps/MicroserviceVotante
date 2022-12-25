/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mx.tecnm.oaxaca.microservice.votante.model;

import com.sun.istack.NotNull;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author macbookair
 */
@Entity
@Table(name = "usuario")
public class UsuarioModel {

    @Id
    @Column(name = "idUsuario")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idUsuario;

    @NotNull
    @Column(name = "correo")
    private String correo;
    
    @NotNull
    @Column(name = "password")
    private String password;
    
    @NotNull
    @Column(name = "estado")
    private String estado;
    
    @ManyToOne
    @JoinColumn(name = "idRol")
    private RolModel rolModel;

    public UsuarioModel() {
    }

    public UsuarioModel(Integer idUsuario, String correo, String password, String estado, RolModel rolModel) {
        this.idUsuario = idUsuario;
        this.correo = correo;
        this.password = password;
        this.estado = estado;
        this.rolModel = rolModel;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public RolModel getRolModel() {
        return rolModel;
    }

    public void setRolModel(RolModel rolModel) {
        this.rolModel = rolModel;
    }

    @Override
    public String toString() {
        return "UsuarioModel{" + "idUsuario=" + idUsuario + ", correo=" + correo + ", password=" + password + ", estado=" + estado + ", rolModel=" + rolModel + '}';
    }
    
    
}
