package edu.mx.tecnm.oaxaca.microservice.votante.model;

import com.sun.istack.NotNull;
import javax.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "direcciones")
public class DireccionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idDireccion;

    @NotNull
    @Column(name = "calle")
    private String calle;

    @Column(name = "numero")
    private Integer numero;

    @Column(name = "colonia")
    private String colonia;
    
    @Column(name = "cp")
    private Integer cp;
    
    @Column(name = "estado")
    private String estado;
    
    @Column(name = "municipio")
    private String municipio;

    
    @OneToOne
    @JoinColumn(name = "curp")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private VotanteModel votanteModel;
     
    public DireccionModel() {
    }

    public DireccionModel(Integer idDireccion, String calle, Integer numero, String colonia, Integer cp, String estado, String municipio, VotanteModel votanteModel) {
        this.idDireccion = idDireccion;
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
        this.cp = cp;
        this.estado = estado;
        this.municipio = municipio;
        this.votanteModel = votanteModel;
    }

    public Integer getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(Integer idDireccion) {
        this.idDireccion = idDireccion;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public Integer getCp() {
        return cp;
    }

    public void setCp(Integer cp) {
        this.cp = cp;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public VotanteModel getVotanteModel() {
        return votanteModel;
    }

    public void setVotanteModel(VotanteModel votanteModel) {
        this.votanteModel = votanteModel;
    }

    @Override
    public String toString() {
        return "DireccionModel{" + "idDireccion=" + idDireccion + ", calle=" + calle + ", numero=" + numero + ", colonia=" + colonia + ", cp=" + cp + ", estado=" + estado + ", municipio=" + municipio + ", votanteModel=" + votanteModel + '}';
    }
    
    
    
    
}
