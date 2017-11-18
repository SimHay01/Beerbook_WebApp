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


}
