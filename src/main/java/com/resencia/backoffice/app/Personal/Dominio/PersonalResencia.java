/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resencia.backoffice.app.Personal.Dominio;

import com.resencia.backoffice.app.AccesoPersonal.Dominio.AccesoPersonalResencia;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author bunn3
 */
@Entity
@Table(name = "personal_resencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PersonalResencia.findAll", query = "SELECT p FROM PersonalResencia p"),
    @NamedQuery(name = "PersonalResencia.findByIdpersonal", query = "SELECT p FROM PersonalResencia p WHERE p.idpersonal = :idpersonal"),
    @NamedQuery(name = "PersonalResencia.findByNombrePersonal", query = "SELECT p FROM PersonalResencia p WHERE p.nombrePersonal = :nombrePersonal"),
    @NamedQuery(name = "PersonalResencia.findByApellidoPersonal", query = "SELECT p FROM PersonalResencia p WHERE p.apellidoPersonal = :apellidoPersonal"),
    @NamedQuery(name = "PersonalResencia.findByEmailPersonal", query = "SELECT p FROM PersonalResencia p WHERE p.emailPersonal = :emailPersonal"),
    @NamedQuery(name = "PersonalResencia.findByTelefono", query = "SELECT p FROM PersonalResencia p WHERE p.telefono = :telefono")})
public class PersonalResencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpersonal")
    private Integer idpersonal;
    @Column(name = "nombre_personal")
    private String nombrePersonal;
    @Column(name = "apellido_personal")
    private String apellidoPersonal;
    @Column(name = "email_personal")
    private String emailPersonal;
    @Column(name = "telefono")
    private String telefono;
    @OneToMany(mappedBy = "userid")
    private List<RolesResencia> rolesResenciaList;
    @OneToMany(mappedBy = "idpersonal")
    private List<AccesoPersonalResencia> accesoPersonalResenciaList;

    public PersonalResencia() {
    }

    public PersonalResencia(Integer idpersonal) {
        this.idpersonal = idpersonal;
    }

    public Integer getIdpersonal() {
        return idpersonal;
    }

    public void setIdpersonal(Integer idpersonal) {
        this.idpersonal = idpersonal;
    }

    public String getNombrePersonal() {
        return nombrePersonal;
    }

    public void setNombrePersonal(String nombrePersonal) {
        this.nombrePersonal = nombrePersonal;
    }

    public String getApellidoPersonal() {
        return apellidoPersonal;
    }

    public void setApellidoPersonal(String apellidoPersonal) {
        this.apellidoPersonal = apellidoPersonal;
    }

    public String getEmailPersonal() {
        return emailPersonal;
    }

    public void setEmailPersonal(String emailPersonal) {
        this.emailPersonal = emailPersonal;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @XmlTransient
    public List<RolesResencia> getRolesResenciaList() {
        return rolesResenciaList;
    }

    public void setRolesResenciaList(List<RolesResencia> rolesResenciaList) {
        this.rolesResenciaList = rolesResenciaList;
    }

    @XmlTransient
    public List<AccesoPersonalResencia> getAccesoPersonalResenciaList() {
        return accesoPersonalResenciaList;
    }

    public void setAccesoPersonalResenciaList(List<AccesoPersonalResencia> accesoPersonalResenciaList) {
        this.accesoPersonalResenciaList = accesoPersonalResenciaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpersonal != null ? idpersonal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonalResencia)) {
            return false;
        }
        PersonalResencia other = (PersonalResencia) object;
        if ((this.idpersonal == null && other.idpersonal != null) || (this.idpersonal != null && !this.idpersonal.equals(other.idpersonal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.resencia.backoffice.app.Personal.PersonalResencia[ idpersonal=" + idpersonal + " ]";
    }
    
}
