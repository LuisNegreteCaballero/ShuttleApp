/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJBClasses;

/**
 *
 * @author negre
 */
public class Session {
   
    private javax.websocket.Session session;
    
    private String username;
    
    public javax.websocket.Session getSession(){
    
        return this.session;
    
    }
    
    public void setSession(javax.websocket.Session session){
    
        this.session = session;
    
    }
    
    
    public String getUsername(){
    
        return this.username;
    
    }
    
    public void setUsername(String username){
    
        this.username = username;
    
    }
    
    
}
