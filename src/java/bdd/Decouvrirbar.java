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
@Table(name = "decouvrirbar")
@NamedQueries({
    @NamedQuery(name = "Decouvrirbar.findAll", query = "SELECT d FROM Decouvrirbar d")
    , @NamedQuery(name = "Decouvrirbar.findByIdDBa", query = "SELECT d FROM Decouvrirbar d WHERE d.idDBa = :idDBa")})
public class Decouvrirbar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDBa")
    private Integer idDBa;
    @JoinColumn(name = "idBa", referencedColumnName = "idBa")
    @ManyToOne
    private Bar idBa;
    @JoinColumn(name = "idU", referencedColumnName = "idU")
    @ManyToOne
    private Utilisateur idU;

    public Decouvrirbar() {
    }

    public Decouvrirbar(Integer idDBa) {
        this.idDBa = idDBa;
    }

    public Integer getIdDBa() {
        return idDBa;
    }

    public void setIdDBa(Integer idDBa) {
        this.idDBa = idDBa;
    }

    public Bar getIdBa() {
        return idBa;
    }

    public void setIdBa(Bar idBa) {
        this.idBa = idBa;
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
        hash += (idDBa != null ? idDBa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Decouvrirbar)) {
            return false;
        }
        Decouvrirbar other = (Decouvrirbar) object;
        if ((this.idDBa == null && other.idDBa != null) || (this.idDBa != null && !this.idDBa.equals(other.idDBa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bdd.Decouvrirbar[ idDBa=" + idDBa + " ]";
    }
    
}
