/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.tagcloud.DefaultTagCloudItem;
import org.primefaces.model.tagcloud.DefaultTagCloudModel;
import org.primefaces.model.tagcloud.TagCloudItem;
import org.primefaces.model.tagcloud.TagCloudModel;

/**
 *
 * @author carlito
 */
@ManagedBean
public class Ring implements Serializable{

    private List<String> bieres;
    
    @PostConstruct
    public void init() {
        bieres = new ArrayList<>();
         
        bieres.add("faro");
        bieres.add("chouffe");
        bieres.add("delirium");
        bieres.add("tripel");
        bieres.add("barbar");

    }

    public List<String> getBieres() {
        return bieres;
    }

    public void setBieres(List<String> bieres) {
        this.bieres = bieres;
    }
    
    
    
}
