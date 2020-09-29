/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resencia.backoffice.app.AccesoPersonal.Dominio;

import com.resencia.backoffice.app.Personal.Dominio.PersonalResencia;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author bunn3
 */
@Entity
@Table(name = "acceso_personal_resencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccesoPersonalResencia.findAll", query = "SELECT a FROM AccesoPersonalResencia a"),
    @NamedQuery(name = "AccesoPersonalResencia.findByIdacceso", query = "SELECT a FROM AccesoPersonalResencia a WHERE a.idacceso = :idacceso"),
    @NamedQuery(name = "AccesoPersonalResencia.findByUsername", query = "SELECT a FROM AccesoPersonalResencia a WHERE a.username = :username"),
    @NamedQuery(name = "AccesoPersonalResencia.findByPasswordPersonal", query = "SELECT a FROM AccesoPersonalResencia a WHERE a.passwordPersonal = :passwordPersonal")})
public class AccesoPersonalResencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idacceso")
    private Integer idacceso;
    @Column(name = "username")
    private String username;
    @Column(name = "password_personal")
    private String passwordPersonal;
    @JoinColumn(name = "idpersonal", referencedColumnName = "idpersonal")
    @ManyToOne()
    private PersonalResencia idpersonal;

    public AccesoPersonalResencia() {
    }

    public AccesoPersonalResencia(String username, String passwordPersonal, PersonalResencia idpersonal) {
        this.username = username;
        this.passwordPersonal = passwordPersonal;
        this.idpersonal = idpersonal;
    }
    
    

    public AccesoPersonalResencia(Integer idacceso) {
        this.idacceso = idacceso;
    }

    public Integer getIdacceso() {
        return idacceso;
    }

    public void setIdacceso(Integer idacceso) {
        this.idacceso = idacceso;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordPersonal() {
        return passwordPersonal;
    }

    public void setPasswordPersonal(String passwordPersonal) {
        this.passwordPersonal = passwordPersonal;
    }

    public PersonalResencia getIdpersonal() {
        return idpersonal;
    }

    public void setIdpersonal(PersonalResencia idpersonal) {
        this.idpersonal = idpersonal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idacceso != null ? idacceso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccesoPersonalResencia)) {
            return false;
        }
        AccesoPersonalResencia other = (AccesoPersonalResencia) object;
        if ((this.idacceso == null && other.idacceso != null) || (this.idacceso != null && !this.idacceso.equals(other.idacceso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.resencia.backoffice.app.Personal.AccesoPersonalResencia[ idacceso=" + idacceso + " ]";
    }
    
}
