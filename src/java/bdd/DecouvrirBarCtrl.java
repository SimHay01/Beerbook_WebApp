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
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


/**
 *
 * @author Simon Hay
 */
@Named(value = "decouvrirBaCtrl")
@SessionScoped
public class DecouvrirBarCtrl implements Serializable {
    
    @EJB
    private DecouvrirBarDAO daoDecouvrirBar;
    private Decouvrirbar decouvrirbar;
                
    /**
     * Creates a new instance of BiereCtrl
     */
    public DecouvrirBarCtrl() {
        this.decouvrirbar = new Decouvrirbar();
    }
       
        
    public void addBar(Bar selectedBa, Utilisateur connectedUser){
        if (daoDecouvrirBar.barAlreadyAdded(selectedBa, connectedUser).isEmpty()) {
            decouvrirbar.setIdU(connectedUser);
            decouvrirbar.setIdBa(selectedBa);
            daoDecouvrirBar.add(this.decouvrirbar);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, decouvrirbar.getIdBa().getNomBa() + " !", "Ajouté à ta Pub List ;-) !"));
            this.decouvrirbar = new Decouvrirbar();            
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Tu as déjà ajouté ce bar à ta liste."));
        }
    }
    
    public void removeBar(Decouvrirbar decouvrirbar){ 
        daoDecouvrirBar.remove(decouvrirbar);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Le bar " + decouvrirbar.getIdBa().getNomBa(), "a été supprimé de ta Pub List."));
        
    }
    
    public Integer barAverageRating(Bar ba, Utilisateur connectedUser){
        return daoDecouvrirBar.barAverageRating(ba, connectedUser).intValue();
    }
    
    public List<Decouvrirbar> getPubList(Utilisateur connectedUser){
        return daoDecouvrirBar.pubList(connectedUser);
    }      

    public DecouvrirBarDAO getDaoDecouvrirBar() {
        return daoDecouvrirBar;
    }

    public void setDaoDecouvrirBar(DecouvrirBarDAO daoDecouvrirBar) {
        this.daoDecouvrirBar = daoDecouvrirBar;
    }

    public Decouvrirbar getDecouvrirbar() {
        return decouvrirbar;
    }

    public void setDecouvrirbar(Decouvrirbar decouvrirbar) {
        this.decouvrirbar = decouvrirbar;
    }
  
}
