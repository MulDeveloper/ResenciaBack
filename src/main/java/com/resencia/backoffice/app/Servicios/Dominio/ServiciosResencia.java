/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resencia.backoffice.app.Servicios.Dominio;

import com.resencia.backoffice.app.Cliente.Dominio.ClientesResencia;
import com.resencia.backoffice.app.Tickets.Dominio.TicketSoporte;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author bunn3
 */
@Entity
@Table(name = "servicios_resencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ServiciosResencia.findAll", query = "SELECT s FROM ServiciosResencia s"),
    @NamedQuery(name = "ServiciosResencia.findByIdservicio", query = "SELECT s FROM ServiciosResencia s WHERE s.idservicio = :idservicio"),
    @NamedQuery(name = "ServiciosResencia.findByDescripcion", query = "SELECT s FROM ServiciosResencia s WHERE s.descripcion = :descripcion"),
    @NamedQuery(name = "ServiciosResencia.findByPrecio", query = "SELECT s FROM ServiciosResencia s WHERE s.precio = :precio"),
    @NamedQuery(name = "ServiciosResencia.findByFechaAlta", query = "SELECT s FROM ServiciosResencia s WHERE s.fechaAlta = :fechaAlta"),
    @NamedQuery(name = "ServiciosResencia.findByFechaEntrega", query = "SELECT s FROM ServiciosResencia s WHERE s.fechaEntrega = :fechaEntrega"),
    @NamedQuery(name = "ServiciosResencia.findByFechaPago", query = "SELECT s FROM ServiciosResencia s WHERE s.fechaPago = :fechaPago"),
    @NamedQuery(name = "ServiciosResencia.findByEstadoPago", query = "SELECT s FROM ServiciosResencia s WHERE s.estadoPago = :estadoPago"),
    @NamedQuery(name = "ServiciosResencia.lastTen", query = "SELECT s FROM ServiciosResencia s ORDER BY s.fechaAlta DESC")})
public class ServiciosResencia implements Serializable {

    @OneToMany(mappedBy = "idservicio")
    private List<TicketSoporte> ticketSoporteList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idservicio")
    private Integer idservicio;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "precio")
    private BigInteger precio;
    @Column(name = "fecha_alta")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaAlta;
    @Column(name = "fecha_entrega")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaEntrega;
    @Column(name = "fecha_pago")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaPago;
    @Column(name = "estado_pago")
    private Boolean estadoPago;
    @JoinColumn(name = "idcliente", referencedColumnName = "idcliente")
    @ManyToOne
    private ClientesResencia idcliente;

    public ServiciosResencia() {
    }

    public ServiciosResencia(Integer idservicio) {
        this.idservicio = idservicio;
    }

    public Integer getIdservicio() {
        return idservicio;
    }

    public void setIdservicio(Integer idservicio) {
        this.idservicio = idservicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigInteger getPrecio() {
        return precio;
    }

    public void setPrecio(BigInteger precio) {
        this.precio = precio;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public Boolean getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(Boolean estadoPago) {
        this.estadoPago = estadoPago;
    }

    public ClientesResencia getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(ClientesResencia idcliente) {
        this.idcliente = idcliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idservicio != null ? idservicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServiciosResencia)) {
            return false;
        }
        ServiciosResencia other = (ServiciosResencia) object;
        if ((this.idservicio == null && other.idservicio != null) || (this.idservicio != null && !this.idservicio.equals(other.idservicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.resencia.backoffice.app.Servicios.Dominio.ServiciosResencia[ idservicio=" + idservicio + " ]";
    }

    @XmlTransient
    public List<TicketSoporte> getTicketSoporteList() {
        return ticketSoporteList;
    }

    public void setTicketSoporteList(List<TicketSoporte> ticketSoporteList) {
        this.ticketSoporteList = ticketSoporteList;
    }
    
}
