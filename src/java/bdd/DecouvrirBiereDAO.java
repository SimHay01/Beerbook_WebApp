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
public class DecouvrirBiereDAO {
    
    @PersistenceContext(unitName = "BeerbookWebAppPU")
    private EntityManager em;
         
    public void add(Decouvrirbiere decouvrirbiere){
        em.persist(decouvrirbiere);
        em.flush();
    }     
    
    public List<Decouvrirbiere> beerAlreadyAdded(Biere selectedBeer, Utilisateur connectedUser){
        Query query;
        query = em.createQuery(
                "SELECT d FROM Decouvrirbiere d WHERE d.idBi = :selectedBeer AND d.idU = :connectedUser")
                .setParameter("selectedBeer", selectedBeer)
                .setParameter("connectedUser", connectedUser);
        return query.getResultList();
    }     

    public List<Decouvrirbiere> drinkList(Utilisateur connectedUser){
        Query queryDrinkList = em.createQuery(
                "SELECT d FROM Decouvrirbiere d WHERE d.idU = :connectedUser")
                .setParameter("connectedUser", connectedUser);
        return queryDrinkList.getResultList();        
    }
    
    public void remove(Decouvrirbiere decouvrirbiere) {
        em.remove(em.merge(decouvrirbiere));
        em.flush();
    }
    
    public Double averageRating(Biere bi, Utilisateur connectedUser){
        Query queryAverageRating = em.createQuery(
                "SELECT AVG(p.noteBiereP) FROM Post p, Decouvrirbiere d WHERE p.idBi = d.idBi AND d.idU = :connectedUser AND d.idBi = :bi")
                .setParameter("connectedUser", connectedUser)
                .setParameter("bi", bi);
        return (Double) queryAverageRating.getSingleResult();        
    }

}
