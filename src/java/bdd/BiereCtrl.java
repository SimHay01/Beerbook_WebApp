/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdd;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import java.util.List;
import javax.enterprise.context.SessionScoped;


/**
 *
 * @author Simon Hay
 */
@Named(value = "biereCtrl")
@SessionScoped
public class BiereCtrl implements Serializable {
    
    @EJB
    private BiereDAO daoBiere;
    private Biere biere;
            
    /**
     * Creates a new instance of BiereCtrl
     */
    public BiereCtrl() {
        this.biere = new Biere();
    }    
    
    public List<Biere> getAllBeers(){
        return daoBiere.allBeers();
    }  

    public BiereDAO getDaoBiere() {
        return daoBiere;
    }

    public void setDaoBiere(BiereDAO daoBiere) {
        this.daoBiere = daoBiere;
    }

    public Biere getBiere() {
        return biere;
    }

    public void setBiere(Biere biere) {
        this.biere = biere;
    }
    

    
    
    
}
