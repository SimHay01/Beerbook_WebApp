/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdd;

import java.io.Serializable;
import java.sql.Date;
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

    private Integer idSelectedBeer;
    private Integer idSelectedBar;   
    
    private SimpleDateFormat sdf;
    
            
    /**
     * Creates a new instance of BiereCtrl
     */
    public PostCtrl() {
        this.post = new Post();
    }
    
    public List<Post> getAllPosts(){
        return daoPost.allPosts();
    }
    
    public void addPost(Utilisateur connectedUser){
        this.post.setIdBi(findBeer());
        this.post.setIdBa(findBar());
        java.util.Calendar cal = java.util.Calendar.getInstance();
        java.util.Date utilDate = cal.getTime();
        java.sql.Date sqlDate = new Date(utilDate.getTime()); 
        this.post.setDateP(sqlDate);
        this.post.setIdU(connectedUser);
        daoPost.addPost(this.post);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Merci pour ta publication !", "Ton post est maintenant visible par la communauté Beerbook !"));
        idSelectedBeer = null;
        idSelectedBar = null;
        this.post = new Post();
    }
    
    public String displayDate(java.util.Date utilDate){
        SimpleDateFormat dmyFormat = new SimpleDateFormat("dd-MM-yyyy");
        String dmy = dmyFormat.format(utilDate);
        return dmy;
    }
    
    public Biere findBeer(){
        return daoPost.findBeer(idSelectedBeer);
    }
    
    public Bar findBar(){
        return daoPost.findBar(idSelectedBar);
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

    public Integer getIdSelectedBeer() {
        return idSelectedBeer;
    }

    public void setIdSelectedBeer(Integer idSelectedBeer) {
        this.idSelectedBeer = idSelectedBeer;
    }

    public Integer getIdSelectedBar() {
        return idSelectedBar;
    }

    public void setIdSelectedBar(Integer idSelectedBar) {
        this.idSelectedBar = idSelectedBar;
    }
    
    


    

    
    
    
}
