/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdd;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Simon Hay
 */
@Stateless
public class BarDAO {
    
    @PersistenceContext(unitName = "BeerbookWebAppPU")
    private EntityManager em;
    
    public List<Bar> allBars(){
        Query query = em.createNamedQuery("Bar.findAll");
        return query.getResultList();
    }

    public void add(Bar b){
        em.persist(b);
        em.flush();
    }    


}
