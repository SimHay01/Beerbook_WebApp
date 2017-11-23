/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdd;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServlet;
import org.primefaces.model.UploadedFile;
import org.apache.commons.io.FilenameUtils;

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

    private UploadedFile uploadedFile;
    private UploadedFile newPp;
    private Path file;

    /**
     * Creates a new instance of BiereCtrl
     */
    public UtilisateurCtrl() {
        this.util = new Utilisateur();
    }

    public void addUtil() throws IOException {
        this.upload();
        if (uploadedFile != null) {
            this.util.setPhotoU(this.getFile().getFileName().toString());
        } else {
            this.util.setPhotoU("default.png");
        }
        daoUtil.add(this.util);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, util.getPseudoU() + " !", "Bienvenue :-) !"));
        this.util = new Utilisateur();
    }

    public void upload() throws IOException {
        if (uploadedFile != null) {
            InputStream input = uploadedFile.getInputstream();
            Path folder = Paths.get("C:/workspace/Dernier_code/Beerbook_WebApp/web/PhotosProfil");
            String filename = FilenameUtils.getBaseName(uploadedFile.getFileName());
            String extension = FilenameUtils.getExtension(uploadedFile.getFileName());
            file = Files.createTempFile(folder, filename + "-", "." + extension);
            try (InputStream input2 = uploadedFile.getInputstream()) {
                Files.copy(input2, file, StandardCopyOption.REPLACE_EXISTING);
            }            
            file = Paths.get(file.toString());            
        }
        //return null;
    }
    
    public void uploadNewPp() throws IOException {
        if (newPp != null) {
            InputStream input = newPp.getInputstream();
            Path folder = Paths.get("C:/workspace/Dernier_code/Beerbook_WebApp/web/PhotosProfil");
            String filename = FilenameUtils.getBaseName(newPp.getFileName());
            String extension = FilenameUtils.getExtension(newPp.getFileName());
            file = Files.createTempFile(folder, filename + "-", "." + extension);
            try (InputStream input2 = newPp.getInputstream()) {
                Files.copy(input2, file, StandardCopyOption.REPLACE_EXISTING);
            }            
            file = Paths.get(file.toString());            
        }
        //return null;
    }    

    public void updatePseudo() {
        if (checkPseudo()) {
            daoUtil.updatePseudo(inputPseudo, util.getIdU());
            util.setPseudoU(inputPseudo);
            setInputPseudo("");
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, util.getPseudoU(), "Sympa comme nouveau pseudo !"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Merci d'essayer un autre pseudo !"));
        }

    }

    public void updateMdp() {
        daoUtil.updateMdp(inputMdp, util.getIdU());
        util.setMdpU(inputMdp);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, util.getPseudoU(), "Ton mot de passe a été modifié."));
    }
    
    public void updatePp() throws IOException {
        //this.uploadNewPp();
//        if (newPp != null) {
//            daoUtil.updatePp(newPp.toString(), util.getIdU());
//        } else {
//            daoUtil.updatePp("default.png", util.getIdU());
//        }                
//        util.setPhotoU(this.getFile().getFileName().toString());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, newPp.toString() + "!", "Ta nouvelle photo a été modifiée."));
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

    public boolean checkPseudo() {
        if (!daoUtil.checkPseudo(getInputPseudo()).isEmpty()) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Erreur - ", "Pseudo indisponible"));
            daoUtil.checkPseudo(getInputPseudo()).clear();
            return (false);
        } else {
            // else does not exist so we can add it
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "", "Pseudo disponible"));
            return (true);
        }
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        this.util = new Utilisateur();
        return "HomePage.xhtml?faces-redirect=true";
    }
        
    public Path getFile() {
        return file;
    }

    public void setFile(Path file) {
        this.file = file;
    }

    public UploadedFile getNewPp() {
        return newPp;
    }

    public void setNewPp(UploadedFile newPp) {
        this.newPp = newPp;
    }
    
    
        

    public UploadedFile getUploadedFile() {
        return uploadedFile;
    }

    public void setUploadedFile(UploadedFile uploadedFile) {
        this.uploadedFile = uploadedFile;
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
