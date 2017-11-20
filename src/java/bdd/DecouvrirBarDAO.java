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
public class DecouvrirBarDAO {
    
    @PersistenceContext(unitName = "BeerbookWebAppPU")
    private EntityManager em;
         
    public void add(Decouvrirbar decouvrirbar){
        em.persist(decouvrirbar);
        em.flush();
    }     
    
    public List<Decouvrirbar> barAlreadyAdded(Bar selectedBar, Utilisateur connectedUser){
        Query query;
        query = em.createQuery(
                "SELECT d FROM Decouvrirbar d WHERE d.idBa = :selectedBar AND d.idU = :connectedUser")
                .setParameter("selectedBar", selectedBar)
                .setParameter("connectedUser", connectedUser);
        return query.getResultList();
    }     
    
    public List<Decouvrirbar> pubList(Utilisateur connectedUser){
        Query queryPubList = em.createQuery(
                "SELECT d FROM Decouvrirbar d WHERE d.idU = :connectedUser")
                .setParameter("connectedUser", connectedUser);
        return queryPubList.getResultList();        
    }
    
    public void remove(Decouvrirbar decouvrirbar) {
        em.remove(em.merge(decouvrirbar));
        em.flush();
    }
    
    public Double barAverageRating(Bar ba, Utilisateur connectedUser){
        Query queryAverageRating = em.createQuery(
                "SELECT AVG(p.noteBarP) FROM Post p, Decouvrirbar d WHERE p.idBa = d.idBa AND d.idU = :connectedUser AND d.idBa = :ba")
                .setParameter("connectedUser", connectedUser)
                .setParameter("ba", ba);
        return (Double) queryAverageRating.getSingleResult();        
    }    


}
