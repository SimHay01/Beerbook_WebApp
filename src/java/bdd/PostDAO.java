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
public class PostDAO {
    
    @PersistenceContext(unitName = "BeerbookWebAppPU")
    private EntityManager em;
    
    public void addPost(Post p){
        em.persist(p);
        em.flush();
    }     
    
    public List<Post> allPosts(){
        Query query = em.createNamedQuery("Post.findAll");
        return query.getResultList();
    }   
    
    public Biere findBeer(Integer idSelectedBeer){
        Query queryFindBeer = em.createQuery(
                "SELECT b FROM Biere b WHERE b.idBi = :idSelectedBeer")
                .setParameter("idSelectedBeer", idSelectedBeer);
        return (Biere) queryFindBeer.getSingleResult();
    }
    
    public Bar findBar(Integer idSelectedBar){
        Query queryFindBar = em.createQuery(
                "SELECT b FROM Bar b WHERE b.idBa = :idSelectedBar")
                .setParameter("idSelectedBar", idSelectedBar);
        return (Bar) queryFindBar.getSingleResult();
    }    
}
