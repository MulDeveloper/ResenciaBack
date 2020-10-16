
package com.resencia.backoffice.app.Credenciales.Dominio;

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
import com.resencia.backoffice.app.Servicios.Dominio.ServiciosResencia;

/**
 *
 * @author bunn3
 */
@Entity
@Table(name = "credenciales_servicio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CredencialesServicio.findAll", query = "SELECT c FROM CredencialesServicio c"),
    @NamedQuery(name = "CredencialesServicio.findByIdcredencial", query = "SELECT c FROM CredencialesServicio c WHERE c.idcredencial = :idcredencial"),
    @NamedQuery(name = "CredencialesServicio.findByUsernameCms", query = "SELECT c FROM CredencialesServicio c WHERE c.usernameCms = :usernameCms"),
    @NamedQuery(name = "CredencialesServicio.findByPasswordCms", query = "SELECT c FROM CredencialesServicio c WHERE c.passwordCms = :passwordCms"),
    @NamedQuery(name = "CredencialesServicio.findByUserFtp", query = "SELECT c FROM CredencialesServicio c WHERE c.userFtp = :userFtp"),
    @NamedQuery(name = "CredencialesServicio.findByPassFtp", query = "SELECT c FROM CredencialesServicio c WHERE c.passFtp = :passFtp"),
    @NamedQuery(name = "CredencialesServicio.findByIp", query = "SELECT c FROM CredencialesServicio c WHERE c.ip = :ip"),
    @NamedQuery(name = "CredencialesServicio.findByPassSsh", query = "SELECT c FROM CredencialesServicio c WHERE c.passSsh = :passSsh")})
public class CredencialesServicio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcredencial")
    private Integer idcredencial;
    @Column(name = "username_cms")
    private String usernameCms;
    @Column(name = "password_cms")
    private String passwordCms;
    @Column(name = "user_ftp")
    private String userFtp;
    @Column(name = "pass_ftp")
    private String passFtp;
    @Column(name = "ip")
    private String ip;
    @Column(name = "pass_ssh")
    private String passSsh;
    @JoinColumn(name = "idservicio", referencedColumnName = "idservicio")
    @ManyToOne
    private ServiciosResencia idservicio;

    public CredencialesServicio() {
    }

    public CredencialesServicio(Integer idcredencial) {
        this.idcredencial = idcredencial;
    }

    public Integer getIdcredencial() {
        return idcredencial;
    }

    public void setIdcredencial(Integer idcredencial) {
        this.idcredencial = idcredencial;
    }

    public String getUsernameCms() {
        return usernameCms;
    }

    public void setUsernameCms(String usernameCms) {
        this.usernameCms = usernameCms;
    }

    public String getPasswordCms() {
        return passwordCms;
    }

    public void setPasswordCms(String passwordCms) {
        this.passwordCms = passwordCms;
    }

    public String getUserFtp() {
        return userFtp;
    }

    public void setUserFtp(String userFtp) {
        this.userFtp = userFtp;
    }

    public String getPassFtp() {
        return passFtp;
    }

    public void setPassFtp(String passFtp) {
        this.passFtp = passFtp;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPassSsh() {
        return passSsh;
    }

    public void setPassSsh(String passSsh) {
        this.passSsh = passSsh;
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
        hash += (idcredencial != null ? idcredencial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CredencialesServicio)) {
            return false;
        }
        CredencialesServicio other = (CredencialesServicio) object;
        if ((this.idcredencial == null && other.idcredencial != null) || (this.idcredencial != null && !this.idcredencial.equals(other.idcredencial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.resencia.backoffice.app.Credenciales.Dominio.CredencialesServicio[ idcredencial=" + idcredencial + " ]";
    }
    
}
