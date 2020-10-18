/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resencia.backoffice.app.Tickets.Dominio;

import com.resencia.backoffice.app.Cliente.Dominio.ClientesResencia;
import com.resencia.backoffice.app.Servicios.Dominio.ServiciosResencia;
import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author bunn3
 */
@Entity
@Table(name = "ticket_soporte")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TicketSoporte.findAll", query = "SELECT t FROM TicketSoporte t"),
    @NamedQuery(name = "TicketSoporte.findByIdticket", query = "SELECT t FROM TicketSoporte t WHERE t.idticket = :idticket"),
    @NamedQuery(name = "TicketSoporte.findByFechaAlta", query = "SELECT t FROM TicketSoporte t WHERE t.fechaAlta = :fechaAlta"),
    @NamedQuery(name = "TicketSoporte.findByDescripcion", query = "SELECT t FROM TicketSoporte t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "TicketSoporte.findByEstado", query = "SELECT t FROM TicketSoporte t WHERE t.estado = :estado")})
public class TicketSoporte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idticket")
    private Integer idticket;
    @Column(name = "fecha_alta")
    @Temporal(TemporalType.DATE)
    private Date fechaAlta;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "estado")
    private String estado;
    @JoinColumn(name = "idcliente", referencedColumnName = "idcliente")
    @ManyToOne
    private ClientesResencia idcliente;
    @JoinColumn(name = "idservicio", referencedColumnName = "idservicio")
    @ManyToOne
    private ServiciosResencia idservicio;

    public TicketSoporte() {
    }

    public TicketSoporte(Integer idticket) {
        this.idticket = idticket;
    }

    public Integer getIdticket() {
        return idticket;
    }

    public void setIdticket(Integer idticket) {
        this.idticket = idticket;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public ClientesResencia getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(ClientesResencia idcliente) {
        this.idcliente = idcliente;
    }

    public ServiciosResencia getIdservicio() {
        return idservicio;
    }

    public void setIdservicio(ServiciosResencia idservicio) {
        this.idservicio = idservicio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idticket != null ? idticket.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TicketSoporte)) {
            return false;
        }
        TicketSoporte other = (TicketSoporte) object;
        if ((this.idticket == null && other.idticket != null) || (this.idticket != null && !this.idticket.equals(other.idticket))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.resencia.backoffice.app.Tickets.Dominio.TicketSoporte[ idticket=" + idticket + " ]";
    }
    
}
