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
import javax.servlet.http.HttpServlet;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Simon Hay
 */
@Named(value = "utilCtrl")
@SessionScoped
public class UtilisateurCtrl extends HttpServlet implements Serializable {

    @EJB
    private UtilisateurDAO daoUtil;
    private Utilisateur util;

    private String inputPseudo;
    private String inputMdp;
    private UploadedFile file;

    /**
     * Creates a new instance of BiereCtrl
     */
    public UtilisateurCtrl() {
        this.util = new Utilisateur();
    }

    public void addUtil() {
        if (file != null) {
            this.util.setPhotoU(file.getFileName());
        } else {
            this.util.setPhotoU("default.png");
        }
        daoUtil.add(this.util);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, util.getPseudoU() + " !", "Bienvenue :-) !"));
        this.util = new Utilisateur();
    }

    public void updatePseudo() {
        daoUtil.updatePseudo(inputPseudo, util.getIdU());
        util.setPseudoU(inputPseudo);
        setInputPseudo("");
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, util.getPseudoU(), "Sympa comme nouveau pseudo !"));
    }

    public void updateMdp() {
        daoUtil.updateMdp(inputMdp, util.getIdU());
        util.setMdpU(inputMdp);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, util.getPseudoU(), "Ton mot de passe a été modifié."));
    }

    public String checkConnexion() {
        if (daoUtil.checkConnexion(getInputPseudo(), getInputMdp()).size() == 1) {
            setUtil(daoUtil.checkConnexion(getInputPseudo(), getInputMdp()).get(0));
            daoUtil.checkConnexion(getInputPseudo(), getInputMdp()).clear();
            setInputPseudo("");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenue !", "Vous êtes connecté"));
            return "Menu";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur" + daoUtil.checkConnexion(getInputPseudo(), getInputMdp()).size(), "Pseudo ou mot de passe incorrect(s)."));
        }
        return null;
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        this.util = new Utilisateur();
        return "HomePage.xhtml?faces-redirect=true";
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
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
