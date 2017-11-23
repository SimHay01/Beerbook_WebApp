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
import javax.inject.Named;
import java.util.List;
import java.util.Locale;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.apache.commons.io.FilenameUtils;
import org.primefaces.model.UploadedFile;
import tools.Upload;

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

    private String selectedType, selectedCountry;

    private final String addBeer = "PhotosBi";

    private List<Biere> filteredBeers;
    private Biere selectedBeer;

    private UploadedFile uploadedFile;
    private Upload uploadBean;

    /**
     * Creates a new instance of BiereCtrl
     */
    public BiereCtrl() {
        this.biere = new Biere();
    }

    public List<Biere> getAllBeers() {
        return daoBiere.allBeers();
    }

    public List<String> getAllTypes() {
        return daoBiere.allTypes();
    }

    public List<String> getAllCountries() {
        return daoBiere.allCountries();
    }

    public void addBiere() throws IOException {
        uploadBean = new Upload();
        uploadBean.upload(uploadedFile, addBeer);
        if (uploadedFile != null) {
            this.biere.setPhotoBi(uploadBean.getFile().getFileName().toString());
        } else {
            this.biere.setPhotoBi("defaultBi.png");
        }
        daoBiere.add(this.biere);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "La " + biere.getNomBi() + " !", "La communauté Beerbook te remercie pour cet ajout !"));
        this.biere = new Biere();
    }

//    public void upload() throws IOException {
//        if (uploadedFile != null) {
//            InputStream input = uploadedFile.getInputstream();
//            Path folder = Paths.get("C:/workspace/Dernier_code/Beerbook_WebApp/web/PhotoBi");
//            String filename = FilenameUtils.getBaseName(uploadedFile.getFileName());
//            String extension = FilenameUtils.getExtension(uploadedFile.getFileName());
//            file = Files.createTempFile(folder, filename + "-", "." + extension);
//            try (InputStream input2 = uploadedFile.getInputstream()) {
//                Files.copy(input2, file, StandardCopyOption.REPLACE_EXISTING);
//            }
//            file = Paths.get(file.toString());
//        }
//        //return null;
//    }

    public boolean filterByPercent(Object value, Object filter, Locale locale) {
        String filterText = (filter == null) ? null : filter.toString().trim();
        if (filterText == null || filterText.equals("")) {
            return true;
        }

        if (value == null) {
            return false;
        }

        return ((Comparable) value).compareTo(Integer.valueOf(filterText)) > 0;
    }

    public UploadedFile getUploadedFile() {
        return uploadedFile;
    }

    public void setUploadedFile(UploadedFile uploadedFile) {
        this.uploadedFile = uploadedFile;
    }

    public Biere getSelectedBeer() {
        return selectedBeer;
    }

    public void setSelectedBeer(Biere selectedBeer) {
        this.selectedBeer = selectedBeer;
    }

    public List<Biere> getFilteredBeers() {
        return filteredBeers;
    }

    public void setFilteredBeers(List<Biere> filteredBeers) {
        this.filteredBeers = filteredBeers;
    }

    public String getSelectedType() {
        return selectedType;
    }

    public void setSelectedType(String selectedType) {
        this.selectedType = selectedType;
    }

    public String getSelectedCountry() {
        return selectedCountry;
    }

    public void setSelectedCountry(String selectedCountry) {
        this.selectedCountry = selectedCountry;
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
