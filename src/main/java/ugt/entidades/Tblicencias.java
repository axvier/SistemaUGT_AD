/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ugt.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(schema = "esquemaugt")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblicencias.findAll", query = "SELECT t FROM Tblicencias t")
    , @NamedQuery(name = "Tblicencias.findByCedula", query = "SELECT t FROM Tblicencias t WHERE t.cedula = :cedula")
    , @NamedQuery(name = "Tblicencias.findByTipo", query = "SELECT t FROM Tblicencias t WHERE t.tipo = :tipo")
    , @NamedQuery(name = "Tblicencias.findByFechaexpedicion", query = "SELECT t FROM Tblicencias t WHERE t.fechaexpedicion = :fechaexpedicion")
    , @NamedQuery(name = "Tblicencias.findByFechaexpiracion", query = "SELECT t FROM Tblicencias t WHERE t.fechaexpiracion = :fechaexpiracion")})
public class Tblicencias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cedula")
    private String cedula;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo")
    private Character tipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaexpedicion")
    @Temporal(TemporalType.DATE)
    private Date fechaexpedicion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaexpiracion")
    @Temporal(TemporalType.DATE)
    private Date fechaexpiracion;
    @JoinColumn(name = "cedula", referencedColumnName = "cedula", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Tbconductores tbconductores;

    public Tblicencias() {
    }

    public Tblicencias(String cedula) {
        this.cedula = cedula;
    }

    public Tblicencias(String cedula, Character tipo, Date fechaexpedicion, Date fechaexpiracion) {
        this.cedula = cedula;
        this.tipo = tipo;
        this.fechaexpedicion = fechaexpedicion;
        this.fechaexpiracion = fechaexpiracion;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public Character getTipo() {
        return tipo;
    }

    public void setTipo(Character tipo) {
        this.tipo = tipo;
    }

    public Date getFechaexpedicion() {
        return fechaexpedicion;
    }

    public void setFechaexpedicion(Date fechaexpedicion) {
        this.fechaexpedicion = fechaexpedicion;
    }

    public Date getFechaexpiracion() {
        return fechaexpiracion;
    }

    public void setFechaexpiracion(Date fechaexpiracion) {
        this.fechaexpiracion = fechaexpiracion;
    }

    public Tbconductores getTbconductores() {
        return tbconductores;
    }

    public void setTbconductores(Tbconductores tbconductores) {
        this.tbconductores = tbconductores;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cedula != null ? cedula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblicencias)) {
            return false;
        }
        Tblicencias other = (Tblicencias) object;
        if ((this.cedula == null && other.cedula != null) || (this.cedula != null && !this.cedula.equals(other.cedula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ugt.entidades.Tblicencias[ cedula=" + cedula + " ]";
    }
    
}
