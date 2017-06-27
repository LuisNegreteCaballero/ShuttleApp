/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Singleton;

import javax.annotation.PostConstruct;
import javax.ejb.Startup;

/**
 *
 * @author luis
 */
@javax.ejb.Singleton
@Startup
public class ServiceSingleton implements ServiceSingletonInterface {
    
    private java.util.HashMap<String,EJBClasses.Service>services;
    
    @SuppressWarnings("unused")
    @PostConstruct
    public void postConstruct(){
    
        this.services = new java.util.HashMap();
    
    }
    @SuppressWarnings("unused")
    @javax.annotation.PreDestroy
    public void preDestroy(){
    
        System.out.print("Pre Destroy");
    
    }
    
    @Override
    public java.util.HashMap<String,EJBClasses.Service>getServices(){
    if(services == null){
    
        this.services = new java.util.HashMap<String,EJBClasses.Service>();
    
    }
        return services;
    
    }
    
}
