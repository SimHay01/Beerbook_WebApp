/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdd;

import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.Size;

/**
 *
 * @author Simon Hay
 */
@Entity
@Table(name = "biere")
@NamedQueries({
    @NamedQuery(name = "Biere.findAll", query = "SELECT b FROM Biere b")
    , @NamedQuery(name = "Biere.findByIdBi", query = "SELECT b FROM Biere b WHERE b.idBi = :idBi")
    , @NamedQuery(name = "Biere.findByNomBi", query = "SELECT b FROM Biere b WHERE b.nomBi = :nomBi")
    , @NamedQuery(name = "Biere.findByPourcentBi", query = "SELECT b FROM Biere b WHERE b.pourcentBi = :pourcentBi")
    , @NamedQuery(name = "Biere.findByTypeBi", query = "SELECT b FROM Biere b WHERE b.typeBi = :typeBi")
    , @NamedQuery(name = "Biere.findByPaysBi", query = "SELECT b FROM Biere b WHERE b.paysBi = :paysBi")
    , @NamedQuery(name = "Biere.findByPhotoBi", query = "SELECT b FROM Biere b WHERE b.photoBi = :photoBi")})
public class Biere implements Serializable {

    @OneToMany(mappedBy = "idBi")
    private Collection<Decouvrirbiere> decouvrirbiereCollection;

    @OneToMany(mappedBy = "idBi")
    private Collection<Post> postCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idBi")
    private Integer idBi;
    @Size(max = 25)
    @Column(name = "nomBi")
    private String nomBi;
    @Column(name = "pourcentBi")
    private Integer pourcentBi;
    @Size(max = 25)
    @Column(name = "typeBi")
    private String typeBi;
    @Size(max = 25)
    @Column(name = "paysBi")
    private String paysBi;
    @Size(max = 25)
    @Column(name = "photoBi")
    private String photoBi;

    public Biere() {
    }

    public Biere(Integer idBi) {
        this.idBi = idBi;
    }

    public Integer getIdBi() {
        return idBi;
    }

    public void setIdBi(Integer idBi) {
        this.idBi = idBi;
    }

    public String getNomBi() {
        return nomBi;
    }

    public void setNomBi(String nomBi) {
        this.nomBi = nomBi;
    }

    public Integer getPourcentBi() {
        return pourcentBi;
    }

    public void setPourcentBi(Integer pourcentBi) {
        this.pourcentBi = pourcentBi;
    }

    public String getTypeBi() {
        return typeBi;
    }

    public void setTypeBi(String typeBi) {
        this.typeBi = typeBi;
    }

    public String getPaysBi() {
        return paysBi;
    }

    public void setPaysBi(String paysBi) {
        this.paysBi = paysBi;
    }

    public String getPhotoBi() {
        return photoBi;
    }

    public void setPhotoBi(String photoBi) {
        this.photoBi = photoBi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBi != null ? idBi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Biere)) {
            return false;
        }
        Biere other = (Biere) object;
        if ((this.idBi == null && other.idBi != null) || (this.idBi != null && !this.idBi.equals(other.idBi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bdd.Biere[ idBi=" + idBi + " ]";
    }

    public Collection<Post> getPostCollection() {
        return postCollection;
    }

    public void setPostCollection(Collection<Post> postCollection) {
        this.postCollection = postCollection;
    }

    public Collection<Decouvrirbiere> getDecouvrirbiereCollection() {
        return decouvrirbiereCollection;
    }

    public void setDecouvrirbiereCollection(Collection<Decouvrirbiere> decouvrirbiereCollection) {
        this.decouvrirbiereCollection = decouvrirbiereCollection;
    }
    
}
