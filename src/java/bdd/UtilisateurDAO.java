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
public class UtilisateurDAO {
    
    @PersistenceContext(unitName = "BeerbookWebAppPU")
    private EntityManager em;

    public void add(Utilisateur u){
        em.persist(u);
        em.flush();
    } 
    
    //CHANGER METTTRE L'objet utilisateur au lieu de juste l'ID
    public List<Utilisateur> checkConnexion(String inputPseudo, String inputMdp){
        Query query;
        query = em.createQuery(
                "SELECT u FROM Utilisateur u WHERE u.pseudoU = :inputPseudoParam AND u.mdpU = :inputMdpParam")
                .setParameter("inputPseudoParam", inputPseudo)
                .setParameter("inputMdpParam", inputMdp);
        return query.getResultList();
    }   
    
    
    public void updateUtilisateur(Utilisateur utilisateur){
        Utilisateur u = em.merge(utilisateur);
        em.persist(u);
        em.flush();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
