/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdd;

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

/**
 *
 * @author Simon Hay
 */
@Entity
@Table(name = "decouvrirbiere")
@NamedQueries({
    @NamedQuery(name = "Decouvrirbiere.findAll", query = "SELECT d FROM Decouvrirbiere d")
    , @NamedQuery(name = "Decouvrirbiere.findByIdDBi", query = "SELECT d FROM Decouvrirbiere d WHERE d.idDBi = :idDBi")})
public class Decouvrirbiere implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDBi")
    private Integer idDBi;
    @JoinColumn(name = "idBi", referencedColumnName = "idBi")
    @ManyToOne
    private Biere idBi;
    @JoinColumn(name = "idU", referencedColumnName = "idU")
    @ManyToOne
    private Utilisateur idU;

    public Decouvrirbiere() {
    }

    public Decouvrirbiere(Integer idDBi) {
        this.idDBi = idDBi;
    }

    public Integer getIdDBi() {
        return idDBi;
    }

    public void setIdDBi(Integer idDBi) {
        this.idDBi = idDBi;
    }

    public Biere getIdBi() {
        return idBi;
    }

    public void setIdBi(Biere idBi) {
        this.idBi = idBi;
    }

    public Utilisateur getIdU() {
        return idU;
    }

    public void setIdU(Utilisateur idU) {
        this.idU = idU;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDBi != null ? idDBi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Decouvrirbiere)) {
            return false;
        }
        Decouvrirbiere other = (Decouvrirbiere) object;
        if ((this.idDBi == null && other.idDBi != null) || (this.idDBi != null && !this.idDBi.equals(other.idDBi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bdd.Decouvrirbiere[ idDBi=" + idDBi + " ]";
    }
    
}
