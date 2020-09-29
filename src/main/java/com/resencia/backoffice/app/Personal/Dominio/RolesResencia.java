/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resencia.backoffice.app.Personal.Dominio;

import java.io.Serializable;
import javax.persistence.Basic;
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
@Table(name = "roles_resencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RolesResencia.findAll", query = "SELECT r FROM RolesResencia r"),
    @NamedQuery(name = "RolesResencia.findByIdrol", query = "SELECT r FROM RolesResencia r WHERE r.idrol = :idrol"),
    @NamedQuery(name = "RolesResencia.findByAuthority", query = "SELECT r FROM RolesResencia r WHERE r.authority = :authority")})
public class RolesResencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idrol")
    private Integer idrol;
    @Column(name = "authority")
    private String authority;
    @JoinColumn(name = "userid", referencedColumnName = "idpersonal")
    @ManyToOne
    private PersonalResencia userid;

    public RolesResencia() {
    }

    public RolesResencia(Integer idrol) {
        this.idrol = idrol;
    }

    public Integer getIdrol() {
        return idrol;
    }

    public void setIdrol(Integer idrol) {
        this.idrol = idrol;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public PersonalResencia getUserid() {
        return userid;
    }

    public void setUserid(PersonalResencia userid) {
        this.userid = userid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrol != null ? idrol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RolesResencia)) {
            return false;
        }
        RolesResencia other = (RolesResencia) object;
        if ((this.idrol == null && other.idrol != null) || (this.idrol != null && !this.idrol.equals(other.idrol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.resencia.backoffice.app.Personal.RolesResencia[ idrol=" + idrol + " ]";
    }
    
}
