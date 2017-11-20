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
import java.util.Locale;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


/**
 *
 * @author Simon Hay
 */
@Named(value = "decouvrirBiCtrl")
@SessionScoped
public class DecouvrirBiereCtrl implements Serializable {
    
    @EJB
    private DecouvrirBiereDAO daoDecouvrirBiere;
    private Decouvrirbiere decouvrirbiere;
                
    /**
     * Creates a new instance of BiereCtrl
     */
    public DecouvrirBiereCtrl() {
        this.decouvrirbiere = new Decouvrirbiere();
    }
       
        
    public void addBiere(Biere selectedBi, Utilisateur connectedUser){
        if (daoDecouvrirBiere.beerAlreadyAdded(selectedBi, connectedUser).isEmpty()) {
            decouvrirbiere.setIdU(connectedUser);
            decouvrirbiere.setIdBi(selectedBi);
            daoDecouvrirBiere.add(this.decouvrirbiere);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "La " + decouvrirbiere.getIdBi().getNomBi() + " !", "Ajoutée à ta Drink List ;-) !"));
            this.decouvrirbiere = new Decouvrirbiere();            
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Tu as déjà ajouté cette bière à ta liste."));
        }
    }
    
    public void removeBiere(Decouvrirbiere decouvrirbiere){ 
        daoDecouvrirBiere.remove(decouvrirbiere);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "La " + decouvrirbiere.getIdBi().getNomBi(), "a été supprimée de ta Drink List."));
        
    }
    
    public Integer averageRating(Biere bi, Utilisateur connectedUser){
        return daoDecouvrirBiere.averageRating(bi, connectedUser).intValue();
    }
            
    public List<Decouvrirbiere> getDrinkList(Utilisateur connectedUser){
        return daoDecouvrirBiere.drinkList(connectedUser);
    }    
    
    public DecouvrirBiereDAO getDecouvrirBiereDAO() {
        return daoDecouvrirBiere;
    }

    public void setDecouvrirBiereDAO(DecouvrirBiereDAO decouvrirBiereDAO) {
        this.daoDecouvrirBiere = decouvrirBiereDAO;
    }

    public Decouvrirbiere getDecouvrirbiere() {
        return decouvrirbiere;
    }

    public void setDecouvrirbiere(Decouvrirbiere decouvrirbiere) {
        this.decouvrirbiere = decouvrirbiere;
    }
 

    

    
    
    
}
