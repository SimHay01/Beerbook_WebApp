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
@Table(name = "bar")
@NamedQueries({
    @NamedQuery(name = "Bar.findAll", query = "SELECT b FROM Bar b")
    , @NamedQuery(name = "Bar.findByIdBa", query = "SELECT b FROM Bar b WHERE b.idBa = :idBa")
    , @NamedQuery(name = "Bar.findByNomBa", query = "SELECT b FROM Bar b WHERE b.nomBa = :nomBa")
    , @NamedQuery(name = "Bar.findByVilleBa", query = "SELECT b FROM Bar b WHERE b.villeBa = :villeBa")
    , @NamedQuery(name = "Bar.findByPaysBa", query = "SELECT b FROM Bar b WHERE b.paysBa = :paysBa")})
public class Bar implements Serializable {

    @OneToMany(mappedBy = "idBa")
    private Collection<Post> postCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idBa")
    private Integer idBa;
    @Size(max = 25)
    @Column(name = "nomBa")
    private String nomBa;
    @Size(max = 25)
    @Column(name = "villeBa")
    private String villeBa;
    @Size(max = 25)
    @Column(name = "paysBa")
    private String paysBa;

    public Bar() {
    }

    public Bar(Integer idBa) {
        this.idBa = idBa;
    }

    public Integer getIdBa() {
        return idBa;
    }

    public void setIdBa(Integer idBa) {
        this.idBa = idBa;
    }

    public String getNomBa() {
        return nomBa;
    }

    public void setNomBa(String nomBa) {
        this.nomBa = nomBa;
    }

    public String getVilleBa() {
        return villeBa;
    }

    public void setVilleBa(String villeBa) {
        this.villeBa = villeBa;
    }

    public String getPaysBa() {
        return paysBa;
    }

    public void setPaysBa(String paysBa) {
        this.paysBa = paysBa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBa != null ? idBa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bar)) {
            return false;
        }
        Bar other = (Bar) object;
        if ((this.idBa == null && other.idBa != null) || (this.idBa != null && !this.idBa.equals(other.idBa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bdd.Bar[ idBa=" + idBa + " ]";
    }

    public Collection<Post> getPostCollection() {
        return postCollection;
    }

    public void setPostCollection(Collection<Post> postCollection) {
        this.postCollection = postCollection;
    }
    
}
