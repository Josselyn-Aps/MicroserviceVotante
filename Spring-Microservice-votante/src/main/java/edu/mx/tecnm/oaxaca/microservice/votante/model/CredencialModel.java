/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mx.tecnm.oaxaca.microservice.votante.model;

/**
 *
 * @author macbookair
 */
import com.sun.istack.NotNull;
import javax.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "credenciales")
public class CredencialModel {

    @Id
    @Column(name = "ClaveElector")
    private String claveElector;

    @NotNull
    @Column(name = "seccion")
    private Integer seccion;

    @Column(name = "localidad")
    private Integer localidad;

    @Column(name = "emision")
    private Integer emision;

    @Column(name = "vigencia")
    private Integer vigencia;

    @Column(name = "añoRegistro")
    private Integer añoRegistro;

    @Column(name = "foto")
    private String foto;

    @OneToOne
    @JoinColumn(name = "curp")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private VotanteModel votanteModel;
    
    public CredencialModel() {
    }

    public CredencialModel(String claveElector, Integer seccion, Integer localidad, Integer emision, Integer vigencia, Integer añoRegistro, String foto, VotanteModel votanteModel) {
        this.claveElector = claveElector;
        this.seccion = seccion;
        this.localidad = localidad;
        this.emision = emision;
        this.vigencia = vigencia;
        this.añoRegistro = añoRegistro;
        this.foto = foto;
        this.votanteModel = votanteModel;
    }

    

    public String getClaveElector() {
        return claveElector;
    }

    public void setClaveElector(String claveElector) {
        this.claveElector = claveElector;
    }

    public Integer getSeccion() {
        return seccion;
    }

    public void setSeccion(Integer seccion) {
        this.seccion = seccion;
    }

    public Integer getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Integer localidad) {
        this.localidad = localidad;
    }

    public Integer getEmision() {
        return emision;
    }

    public void setEmision(Integer emision) {
        this.emision = emision;
    }

    public Integer getVigencia() {
        return vigencia;
    }

    public void setVigencia(Integer vigencia) {
        this.vigencia = vigencia;
    }

    public Integer getAñoRegistro() {
        return añoRegistro;
    }

    public void setAñoRegistro(Integer añoRegistro) {
        this.añoRegistro = añoRegistro;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public VotanteModel getVotanteModel() {
        return votanteModel;
    }

    public void setVotanteModel(VotanteModel votanteModel) {
        this.votanteModel = votanteModel;
    }

    @Override
    public String toString() {
        return "CredencialModel{" + "claveElector=" + claveElector + ", seccion=" + seccion + ", localidad=" + localidad + ", emision=" + emision + ", vigencia=" + vigencia + ", a\u00f1oRegistro=" + añoRegistro + ", foto=" + foto + ", votanteModel=" + votanteModel + '}';
    }

    
    
}
