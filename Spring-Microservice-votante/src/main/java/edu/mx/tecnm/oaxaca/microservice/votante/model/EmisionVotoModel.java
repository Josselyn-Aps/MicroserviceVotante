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
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "emisionesVoto")
public class EmisionVotoModel {

    @Id
    private String idEmisionVoto;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTimeCreation;

    public EmisionVotoModel() {
    }

    public EmisionVotoModel(String idEmisionVoto, Date dateTimeCreation) {
        this.idEmisionVoto = idEmisionVoto;
        this.dateTimeCreation = dateTimeCreation;
    }

    public String getIdEmisionVoto() {
        return idEmisionVoto;
    }

    public void setIdEmisionVoto(String idEmisionVoto) {
        this.idEmisionVoto = idEmisionVoto;
    }

    public Date getDateTimeCreation() {
        return dateTimeCreation;
    }

    public void setDateTimeCreation(Date dateTimeCreation) {
        this.dateTimeCreation = dateTimeCreation;
    }

    @Override
    public String toString() {
        return "EmisionVotoModel{" + 
                "idEmisionVoto=" + idEmisionVoto + 
                ", dateTimeCreation=" + dateTimeCreation + '}';
    }
}
