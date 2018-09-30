/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ugt.entidades;

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
 * @author Usuario
 */
@Entity
@Table(schema = "esquemaugt")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tbrolesopciones.findAll", query = "SELECT t FROM Tbrolesopciones t")
    , @NamedQuery(name = "Tbrolesopciones.findById", query = "SELECT t FROM Tbrolesopciones t WHERE t.id = :id")})
public class Tbrolesopciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "opcion", referencedColumnName = "idopcion")
    @ManyToOne(optional = false)
    private Tbopciones opcion;
    @JoinColumn(name = "rol", referencedColumnName = "idrol")
    @ManyToOne(optional = false)
    private Tbroles rol;

    public Tbrolesopciones() {
    }

    public Tbrolesopciones(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Tbopciones getOpcion() {
        return opcion;
    }

    public void setOpcion(Tbopciones opcion) {
        this.opcion = opcion;
    }

    public Tbroles getRol() {
        return rol;
    }

    public void setRol(Tbroles rol) {
        this.rol = rol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tbrolesopciones)) {
            return false;
        }
        Tbrolesopciones other = (Tbrolesopciones) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ugt.entidades.Tbrolesopciones[ id=" + id + " ]";
    }
    
}
