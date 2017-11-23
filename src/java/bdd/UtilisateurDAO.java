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

    public void add(Utilisateur u) {
        em.persist(u);
        em.flush();
    }

    public List<Utilisateur> checkConnexion(String inputPseudo, String inputMdp) {
        Query query;
        query = em.createQuery(
                "SELECT u FROM Utilisateur u WHERE u.pseudoU = :inputPseudoParam AND u.mdpU = :inputMdpParam")
                .setParameter("inputPseudoParam", inputPseudo)
                .setParameter("inputMdpParam", inputMdp);
        return query.getResultList();
    }

    public void updatePseudo(String newPseudo, Integer idConnectedUser) {
        Query queryUpdatePseudo = em.createQuery(
                "UPDATE Utilisateur u SET u.pseudoU = :newPseudo WHERE u.idU = :idConnectedUser")
                .setParameter("newPseudo", newPseudo)
                .setParameter("idConnectedUser", idConnectedUser);
        queryUpdatePseudo.executeUpdate();
    }

    public void updateMdp(String newMdp, Integer idConnectedUser) {
        Query queryUpdateMdp = em.createQuery(
                "UPDATE Utilisateur u SET u.mdpU = :newMdp WHERE u.idU = :idConnectedUser")
                .setParameter("newMdp", newMdp)
                .setParameter("idConnectedUser", idConnectedUser);
        queryUpdateMdp.executeUpdate();
    }
    
    public void updatePp(String newPathPp, Integer idConnectedUser) {
        Query queryUpdateMdp = em.createQuery(
                "UPDATE Utilisateur u SET u.photoU = :newPathPp WHERE u.idU = :idConnectedUser")
                .setParameter("newPathPp", newPathPp)
                .setParameter("idConnectedUser", idConnectedUser);
        queryUpdateMdp.executeUpdate();
    }    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
