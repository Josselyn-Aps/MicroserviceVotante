package edu.mx.tecnm.oaxaca.microservice.votante.model;

/**
 *
 * @author macbookair
 */
import java.util.Date;
import javax.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
@Entity
@Table(name = "votantes")
public class VotanteModel {
    
    @Id
    @Column
    private String curp;
    private String apellidoPVotante;
    private String apellidoMVotante;
    private String nombreVotante;
    private String correoVotante;
    private Integer telefonoVotante;
    private Date fechaNacimiento;
    private String entidad;
    private String genero;
    
    
    @ManyToOne
    @JoinColumn(name = "idDireccion", unique=true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private DireccionModel direccionModel;
 
    @OneToOne
    @JoinColumn(name = "idEmisionVoto")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private EmisionVotoModel emisionVotoModel;
    
    @OneToOne
    @JoinColumn(name = "claveElector")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private CredencialModel credencialModel;

    public VotanteModel() {
    }

    public VotanteModel(String curp, String apellidoPVotante, String apellidoMVotante, String nombreVotante, String correoVotante, Integer telefonoVotante, Date fechaNacimiento, String entidad, String genero, DireccionModel direccionModel, EmisionVotoModel emisionVotoModel, CredencialModel credencialModel) {
        this.curp = curp;
        this.apellidoPVotante = apellidoPVotante;
        this.apellidoMVotante = apellidoMVotante;
        this.nombreVotante = nombreVotante;
        this.correoVotante = correoVotante;
        this.telefonoVotante = telefonoVotante;
        this.fechaNacimiento = fechaNacimiento;
        this.entidad = entidad;
        this.genero = genero;
        this.direccionModel = direccionModel;
        this.emisionVotoModel = emisionVotoModel;
        this.credencialModel = credencialModel;
    }


    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getApellidoPVotante() {
        return apellidoPVotante;
    }

    public void setApellidoPVotante(String apellidoPVotante) {
        this.apellidoPVotante = apellidoPVotante;
    }

    public String getApellidoMVotante() {
        return apellidoMVotante;
    }

    public void setApellidoMVotante(String apellidoMVotante) {
        this.apellidoMVotante = apellidoMVotante;
    }

    public String getNombreVotante() {
        return nombreVotante;
    }

    public void setNombreVotante(String nombreVotante) {
        this.nombreVotante = nombreVotante;
    }

    public String getCorreoVotante() {
        return correoVotante;
    }

    public void setCorreoVotante(String correoVotante) {
        this.correoVotante = correoVotante;
    }

    public Integer getTelefonoVotante() {
        return telefonoVotante;
    }

    public void setTelefonoVotante(Integer telefonoVotante) {
        this.telefonoVotante = telefonoVotante;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public DireccionModel getDireccionModel() {
        return direccionModel;
    }

    public void setDireccionModel(DireccionModel direccionModel) {
        this.direccionModel = direccionModel;
    }

    public EmisionVotoModel getEmisionVotoModel() {
        return emisionVotoModel;
    }

    public void setEmisionVotoModel(EmisionVotoModel emisionVotoModel) {
        this.emisionVotoModel = emisionVotoModel;
    }

    public CredencialModel getCredencialModel() {
        return credencialModel;
    }

    public void setCredencialModel(CredencialModel credencialModel) {
        this.credencialModel = credencialModel;
    }

    @Override
    public String toString() {
        return "VotanteModel{" + "curp=" + curp + ", apellidoPVotante=" + apellidoPVotante + ", apellidoMVotante=" + apellidoMVotante + ", nombreVotante=" + nombreVotante + ", correoVotante=" + correoVotante + ", telefonoVotante=" + telefonoVotante + ", fechaNacimiento=" + fechaNacimiento + ", entidad=" + entidad + ", genero=" + genero + ", direccionModel=" + direccionModel + ", emisionVotoModel=" + emisionVotoModel + ", credencialModel=" + credencialModel + '}';
    }



}
