/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdd;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author Simon Hay
 */
@Entity
@Table(name = "post")
@NamedQueries({
    @NamedQuery(name = "Post.findAll", query = "SELECT p FROM Post p")
    , @NamedQuery(name = "Post.findByIdP", query = "SELECT p FROM Post p WHERE p.idP = :idP")
    , @NamedQuery(name = "Post.findByNoteBiereP", query = "SELECT p FROM Post p WHERE p.noteBiereP = :noteBiereP")
    , @NamedQuery(name = "Post.findByNoteBarP", query = "SELECT p FROM Post p WHERE p.noteBarP = :noteBarP")
    , @NamedQuery(name = "Post.findByDateP", query = "SELECT p FROM Post p WHERE p.dateP = :dateP")})
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idP")
    private Integer idP;
    @Column(name = "noteBiereP")
    private Integer noteBiereP;
    @Column(name = "noteBarP")
    private Integer noteBarP;
    @Lob
    @Size(max = 65535)
    @Column(name = "commentP")
    private String commentP;
    @Column(name = "dateP")
    @Temporal(TemporalType.DATE)
    private Date dateP;
    @JoinColumn(name = "idBa", referencedColumnName = "idBa")
    @ManyToOne
    private Bar idBa;
    @JoinColumn(name = "idBi", referencedColumnName = "idBi")
    @ManyToOne
    private Biere idBi;
    @JoinColumn(name = "idU", referencedColumnName = "idU")
    @ManyToOne
    private Utilisateur idU;

    public Post() {
    }

    public Post(Integer idP) {
        this.idP = idP;
    }

    public Integer getIdP() {
        return idP;
    }

    public void setIdP(Integer idP) {
        this.idP = idP;
    }

    public Integer getNoteBiereP() {
        return noteBiereP;
    }

    public void setNoteBiereP(Integer noteBiereP) {
        this.noteBiereP = noteBiereP;
    }

    public Integer getNoteBarP() {
        return noteBarP;
    }

    public void setNoteBarP(Integer noteBarP) {
        this.noteBarP = noteBarP;
    }

    public String getCommentP() {
        return commentP;
    }

    public void setCommentP(String commentP) {
        this.commentP = commentP;
    }

    public Date getDateP() {
        return dateP;
    }

    public void setDateP(Date dateP) {
        this.dateP = dateP;
    }

    public Bar getIdBa() {
        return idBa;
    }

    public void setIdBa(Bar idBa) {
        this.idBa = idBa;
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
        hash += (idP != null ? idP.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Post)) {
            return false;
        }
        Post other = (Post) object;
        if ((this.idP == null && other.idP != null) || (this.idP != null && !this.idP.equals(other.idP))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bdd.Post[ idP=" + idP + " ]";
    }

    String setDateP() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
