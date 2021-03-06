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
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Xavy PC
 */
@Embeddable
public class TbvehiculosdependenciasPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "iddependencia")
    private int iddependencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "matricula")
    private String matricula;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechainicio")
    @Temporal(TemporalType.DATE)
    private Date fechainicio;

    public TbvehiculosdependenciasPK() {
    }

    public TbvehiculosdependenciasPK(int iddependencia, String matricula, Date fechainicio) {
        this.iddependencia = iddependencia;
        this.matricula = matricula;
        this.fechainicio = fechainicio;
    }

    public int getIddependencia() {
        return iddependencia;
    }

    public void setIddependencia(int iddependencia) {
        this.iddependencia = iddependencia;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) iddependencia;
        hash += (matricula != null ? matricula.hashCode() : 0);
        hash += (fechainicio != null ? fechainicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbvehiculosdependenciasPK)) {
            return false;
        }
        TbvehiculosdependenciasPK other = (TbvehiculosdependenciasPK) object;
        if (this.iddependencia != other.iddependencia) {
            return false;
        }
        if ((this.matricula == null && other.matricula != null) || (this.matricula != null && !this.matricula.equals(other.matricula))) {
            return false;
        }
        if ((this.fechainicio == null && other.fechainicio != null) || (this.fechainicio != null && !this.fechainicio.equals(other.fechainicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ugt.entidades.TbvehiculosdependenciasPK[ iddependencia=" + iddependencia + ", matricula=" + matricula + ", fechainicio=" + fechainicio + " ]";
    }
    
}
