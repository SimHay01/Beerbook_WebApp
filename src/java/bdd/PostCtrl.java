/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdd;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import javax.ejb.EJB;
import javax.inject.Named;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


/**
 *
 * @author Simon Hay
 */
@Named(value = "postCtrl")
@SessionScoped
public class PostCtrl implements Serializable {
    
    @EJB
    private PostDAO daoPost;
    private Post post;
    
    @EJB
    private UtilisateurDAO daoUtil;
    private Utilisateur util;
    
            
    /**
     * Creates a new instance of BiereCtrl
     */
    public PostCtrl() {
        this.post = new Post();
    }

    public void addPost(){        
        new SimpleDateFormat("yyyy-MM-dd").format(this.post.setDateP());
        this.post.setIdU(this.daoUtil.checkConnexion(util.getPseudoU(), util.getMdpU()).get(0));        
        daoPost.addPost(this.post);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Merci pour ta publication !", "Ton post est maintenant visible par la communauté Beerbook !"));
        this.post = new Post();
    }    
    
    public List<Post> getAllPosts(){
        return daoPost.allPosts();
    }  

    public PostDAO getDaoPost() {
        return daoPost;
    }

    public void setDaoPost(PostDAO daoPost) {
        this.daoPost = daoPost;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }


    

    
    
    
}
