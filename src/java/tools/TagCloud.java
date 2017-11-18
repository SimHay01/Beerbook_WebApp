/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

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
public class TagCloud {

    private TagCloudModel menu;

    @PostConstruct
    public void init() {
        menu = new DefaultTagCloudModel();
        menu.addTag(new DefaultTagCloudItem("Exprime-toi", "AjoutPost.xhtml", 5));
        menu.addTag(new DefaultTagCloudItem("Communauté Beerbook", "Communaute.xhtml", 4));
        menu.addTag(new DefaultTagCloudItem("Classements", "Classements.xhtml", 3));
        menu.addTag(new DefaultTagCloudItem("À découvrir", "ADecouvrir.xhtml", 3));
        menu.addTag(new DefaultTagCloudItem("Mon profil", "MonProfil.xhtml", 1));
    }

    public TagCloudModel getMenu() {
        return menu;
    }
    
    public String onSelect(SelectEvent event) {
        TagCloudItem item = (TagCloudItem) event.getObject();
        return item.getUrl();
    }

}
