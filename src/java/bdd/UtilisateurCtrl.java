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
import org.primefaces.model.UploadedFile;

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
    
    private String inputPseudo;
    private String inputMdp;
    
    private UploadedFile pic;
    
    /**
     * Creates a new instance of BiereCtrl
     */
    public UtilisateurCtrl() {
        this.util = new Utilisateur();
    }    
    
    public void addUtil(){
        daoUtil.add(this.util);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, util.getPseudoU() + " !", "Bienvenue :-) !"));
        this.util = new Utilisateur();
    }
    
    public void updatePseudo(){
        daoUtil.updatePseudo(inputPseudo, util.getIdU());
        util.setPseudoU(inputPseudo);
        setInputPseudo("");
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, util.getPseudoU(), "Sympa comme nouveau pseudo !"));        
    }
    
    public void updateMdp(){
        daoUtil.updateMdp(inputMdp, util.getIdU());
        util.setMdpU(inputMdp);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, util.getPseudoU(), "Ton mot de passe a été modifié."));        
    }    
    
    public String checkConnexion(){
        if(daoUtil.checkConnexion(getInputPseudo(), getInputMdp()).size() == 1) {
            setUtil(daoUtil.checkConnexion(getInputPseudo(), getInputMdp()).get(0));
            daoUtil.checkConnexion(getInputPseudo(), getInputMdp()).clear();
            setInputPseudo("");
            return "Menu";            
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur" + daoUtil.checkConnexion(getInputPseudo(), getInputMdp()).size(), "Pseudo ou mot de passe incorrect(s)."));        
        }
        return null;
    }
    
    public void uploadPic() {
        if(pic != null) {
            FacesMessage message = new FacesMessage("Succesful", pic.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }  

    public UploadedFile getPic() {
        return pic;
    }

    public void setPic(UploadedFile pic) {
        this.pic = pic;
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
