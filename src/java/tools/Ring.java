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
import javax.faces.bean.ManagedBean;

/**
 *
 * @author carlito
 */
@ManagedBean
public class Ring implements Serializable {

    private List<String> bieres;

    @PostConstruct
    public void init() {
        bieres = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            bieres.add("biere" + i + ".png");
        }
    }

    public List<String> getBieres() {
        return bieres;
    }

    public void setBieres(List<String> bieres) {
        this.bieres = bieres;
    }

}
