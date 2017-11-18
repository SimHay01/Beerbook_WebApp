/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdd;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Simon Hay
 */
@Named(value = "utilCtrl")
@SessionScoped
public class UtilisateurCtrl implements Serializable {
    
    @EJB
    private UtilisateurDAO daoUtil;
    private Utilisateur util;
    
    private String inputPseudo, inputMdp;
    
    /**
     * Creates a new instance of BiereCtrl
     */
    public UtilisateurCtrl() {
        //this.util = new Utilisateur();
    }    
    
    public void addUtil(){
        daoUtil.add(this.util);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, util.getPseudoU() + " !", "Bienvenue :-) !"));
        this.util = new Utilisateur();
    }
    
    public String checkConnexion(){
        this.util = new Utilisateur();        
        if(daoUtil.checkConnexion(getInputPseudo(), getInputMdp()).size() == 1) {
            return "Menu";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur", "Pseudo ou mot de passe incorrect(s)."));        
        }
        return null;
    }

    public void setInputPseudo(String inputPseudo) {
        this.inputPseudo = inputPseudo;
    }

    public void setInputMdp(String inputMdp) {
        this.inputMdp = inputMdp;
    }    

    public String getInputPseudo() {
        return inputPseudo;
    }

    public String getInputMdp() {
        return inputMdp;
    }

    
    
    public UtilisateurDAO getDaoUtil() {
        return daoUtil;
    }

    public void setDaoUtil(UtilisateurDAO daoUtil) {
        this.daoUtil = daoUtil;
    }

    public Utilisateur getUtil() {
        return util;
    }

    public void setUtil(Utilisateur util) {
        this.util = util;
    }
    
    
    
    
}
