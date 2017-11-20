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
@Named(value = "biereCtrl")
@SessionScoped
public class BiereCtrl implements Serializable {
    
    @EJB
    private BiereDAO daoBiere;
    private Biere biere;
    
    private String selectedType, selectedCountry;
    
    private List<Biere> filteredBeers;
    private Biere selectedBeer;
            
    /**
     * Creates a new instance of BiereCtrl
     */
    public BiereCtrl() {
        this.biere = new Biere();
    }
       
    public List<Biere> getAllBeers(){
        return daoBiere.allBeers();
    }
    
    public List<String> getAllTypes(){
        return daoBiere.allTypes();
    }

    public List<String> getAllCountries(){
            return daoBiere.allCountries();
    }    
    
    public void addBiere(){
        daoBiere.add(this.biere);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "La " + biere.getNomBi() + " !", "La communauté Beerbook te remercie pour cet ajout !"));
        this.biere = new Biere();
    }
    
    public boolean filterByPercent(Object value, Object filter, Locale locale) {
        String filterText = (filter == null) ? null : filter.toString().trim();
        if(filterText == null||filterText.equals("")) {
            return true;
        }
         
        if(value == null) {
            return false;
        }
         
        return ((Comparable) value).compareTo(Integer.valueOf(filterText)) > 0;
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
