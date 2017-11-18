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


/**
 *
 * @author Simon Hay
 */
@Named(value = "barCtrl")
@SessionScoped
public class BarCtrl implements Serializable {
    
    @EJB
    private BarDAO daoBar;
    private Bar bar;
            
    /**
     * Creates a new instance of BiereCtrl
     */
    public BarCtrl() {
        this.bar = new Bar();
    }    
    
    public List<Bar> getAllBars(){
        return daoBar.allBars();
    }  

    public BarDAO getDaoBar() {
        return daoBar;
    }

    public void setDaoBar(BarDAO daoBar) {
        this.daoBar = daoBar;
    }

    public Bar getBar() {
        return bar;
    }

    public void setBar(Bar bar) {
        this.bar = bar;
    }


    

    
    
    
}
