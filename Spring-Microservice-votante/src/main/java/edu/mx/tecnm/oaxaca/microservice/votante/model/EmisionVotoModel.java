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
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "emisionesVoto")
public class EmisionVotoModel {

    @Id
    private String idEmisionVoto;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fecha;

    @Temporal(TemporalType.TIME)
    @DateTimeFormat(style = "HH")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH")
    private Date hora;
    
    private String idEstructuraBoleta;
    
    @OneToOne
    @JoinColumn(name = "curp")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private VotanteModel votanteModel;

    public EmisionVotoModel() {
    }

    public EmisionVotoModel(String idEmisionVoto, Date fecha, Date hora, String idEstructuraBoleta, VotanteModel votanteModel) {
        this.idEmisionVoto = idEmisionVoto;
        this.fecha = fecha;
        this.hora = hora;
        this.idEstructuraBoleta = idEstructuraBoleta;
        this.votanteModel = votanteModel;
    }

   

    public String getIdEmisionVoto() {
        return idEmisionVoto;
    }

    public void setIdEmisionVoto(String idEmisionVoto) {
        this.idEmisionVoto = idEmisionVoto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "EmisionVotoModel{" + "idEmisionVoto=" + idEmisionVoto + ", fecha=" + fecha + ", hora=" + hora + ", idEstructuraBoleta=" + idEstructuraBoleta + ", votanteModel=" + votanteModel + '}';
    }


    public String getIdEstructuraBoleta() {
        return idEstructuraBoleta;
    }

    public void setIdEstructuraBoleta(String idEstructuraBoleta) {
        this.idEstructuraBoleta = idEstructuraBoleta;
    }

    public VotanteModel getVotanteModel() {
        return votanteModel;
    }

    public void setVotanteModel(VotanteModel votanteModel) {
        this.votanteModel = votanteModel;
    }

   

   
}
