/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Singleton;

import EJBClasses.Session;
import java.util.List;

/**
 *
 * @author negre
 */
@javax.ejb.Singleton
public class SessionSingletonImpl implements SessionSingleton {
    
    private java.util.List<EJBClasses.Session>sessions;

    @Override
    public List<Session> getSessions() {
    
        if(this.sessions == null){
        
           this.sessions = new java.util.ArrayList<EJBClasses.Session>();
        
        }
        
        return this.sessions;
    
    }
    
    
    
}
