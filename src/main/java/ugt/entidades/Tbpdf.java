/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ugt.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Xavy PC
 */
@Entity
@Table(schema = "esquemaugt")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tbpdf.findAll", query = "SELECT t FROM Tbpdf t")
    , @NamedQuery(name = "Tbpdf.findByIdpdf", query = "SELECT t FROM Tbpdf t WHERE t.idpdf = :idpdf")})
public class Tbpdf implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpdf")
    private Integer idpdf;
    @Lob
    @Column(name = "archivo")
    private byte[] archivo;

    public Tbpdf() {
    }

    public Tbpdf(Integer idpdf) {
        this.idpdf = idpdf;
    }

    public Integer getIdpdf() {
        return idpdf;
    }

    public void setIdpdf(Integer idpdf) {
        this.idpdf = idpdf;
    }

    public byte[] getArchivo() {
        return archivo;
    }

    public void setArchivo(byte[] archivo) {
        this.archivo = archivo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpdf != null ? idpdf.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tbpdf)) {
            return false;
        }
        Tbpdf other = (Tbpdf) object;
        if ((this.idpdf == null && other.idpdf != null) || (this.idpdf != null && !this.idpdf.equals(other.idpdf))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ugt.entidades.Tbpdf[ idpdf=" + idpdf + " ]";
    }
    
}
