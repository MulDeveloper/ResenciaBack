/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resencia.backoffice.app.Cliente.Dominio;

import com.resencia.backoffice.app.Servicios.Dominio.ServiciosResencia;
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
@Table(name = "clientes_resencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClientesResencia.findAll", query = "SELECT c FROM ClientesResencia c"),
    @NamedQuery(name = "ClientesResencia.findByIdcliente", query = "SELECT c FROM ClientesResencia c WHERE c.idcliente = :idcliente"),
    @NamedQuery(name = "ClientesResencia.findByNifCliente", query = "SELECT c FROM ClientesResencia c WHERE c.nifCliente = :nifCliente"),
    @NamedQuery(name = "ClientesResencia.findByNombreCliente", query = "SELECT c FROM ClientesResencia c WHERE c.nombreCliente = :nombreCliente"),
    @NamedQuery(name = "ClientesResencia.findByApellidoCliente", query = "SELECT c FROM ClientesResencia c WHERE c.apellidoCliente = :apellidoCliente"),
    @NamedQuery(name = "ClientesResencia.findByEmailCliente", query = "SELECT c FROM ClientesResencia c WHERE c.emailCliente = :emailCliente"),
    @NamedQuery(name = "ClientesResencia.findByTelefonoCliente", query = "SELECT c FROM ClientesResencia c WHERE c.telefonoCliente = :telefonoCliente"),
    @NamedQuery(name = "ClientesResencia.findByDireccionCliente", query = "SELECT c FROM ClientesResencia c WHERE c.direccionCliente = :direccionCliente"),
    @NamedQuery(name = "ClientesResencia.findByPoblacionCliente", query = "SELECT c FROM ClientesResencia c WHERE c.poblacionCliente = :poblacionCliente")})
public class ClientesResencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcliente")
    private Integer idcliente;
    @Column(name = "nif_cliente")
    private String nifCliente;
    @Column(name = "nombre_cliente")
    private String nombreCliente;
    @Column(name = "apellido_cliente")
    private String apellidoCliente;
    @Column(name = "email_cliente")
    private String emailCliente;
    @Column(name = "telefono_cliente")
    private String telefonoCliente;
    @Column(name = "direccion_cliente")
    private String direccionCliente;
    @Column(name = "poblacion_cliente")
    private String poblacionCliente;
    @OneToMany(mappedBy = "idcliente")
    private List<ServiciosResencia> serviciosResenciaList;

    public ClientesResencia() {
    }

    public ClientesResencia(Integer idcliente) {
        this.idcliente = idcliente;
    }

    public Integer getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Integer idcliente) {
        this.idcliente = idcliente;
    }

    public String getNifCliente() {
        return nifCliente;
    }

    public void setNifCliente(String nifCliente) {
        this.nifCliente = nifCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public String getPoblacionCliente() {
        return poblacionCliente;
    }

    public void setPoblacionCliente(String poblacionCliente) {
        this.poblacionCliente = poblacionCliente;
    }

    @XmlTransient
    public List<ServiciosResencia> getServiciosResenciaList() {
        return serviciosResenciaList;
    }

    public void setServiciosResenciaList(List<ServiciosResencia> serviciosResenciaList) {
        this.serviciosResenciaList = serviciosResenciaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcliente != null ? idcliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClientesResencia)) {
            return false;
        }
        ClientesResencia other = (ClientesResencia) object;
        if ((this.idcliente == null && other.idcliente != null) || (this.idcliente != null && !this.idcliente.equals(other.idcliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.resencia.backoffice.app.Servicios.Dominio.ClientesResencia[ idcliente=" + idcliente + " ]";
    }
    
}
