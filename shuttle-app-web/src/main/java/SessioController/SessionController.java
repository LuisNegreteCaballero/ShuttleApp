/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessioController;

import EJBClasses.Session;
import Singleton.SessionSingleton;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author negre
 */
@ApplicationScoped
public class SessionController {
    @javax.ejb.EJB
    private SessionSingleton _sessionSingleton;
    
    public java.util.List<Session>getSessions(){
    
        return _sessionSingleton.getSessions();
    
    }
    
    public void addSession(Session session){
    
        this._sessionSingleton.getSessions().add(session);
    
    }
    
    public void removeSession(String username){
   
        for(Session session: this._sessionSingleton.getSessions()){
        
            if(session.getUsername().equals(username)){
            
                this._sessionSingleton.getSessions().remove(session);
                
                break;
            
            }
        
        }
    
    }
    
    public Session getSession(String username){
    
        for(Session session: this._sessionSingleton.getSessions()){
        
           if(session.getUsername().equals(username)){
            
             return session;
            }  
        
        }
        
        return null;
    
    }
}
