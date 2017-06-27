/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ServiceController;

import EJBClasses.Service;
import java.util.Map;
import javax.enterprise.context.ApplicationScoped;
import org.json.JSONObject;

/**
 *
 * @author luis
 */
@ApplicationScoped
public class ServiceController {
    
    @javax.ejb.EJB
    private Singleton.ServiceSingletonInterface _serviceSingletonFacade;
    
    public EJBClasses.Service find(String serviceId){
    
    if(_serviceSingletonFacade.getServices().containsKey(serviceId)){
        
         return   _serviceSingletonFacade.getServices().get(serviceId);
        
        }
    return null;
    }
    
    public void addService(EJBClasses.Service service){
    
        _serviceSingletonFacade.getServices().put(service.getServiceId(), service);
    
    }
    
    
    public void pintMap(){
    
        for (Map.Entry<String, Service> entry : this._serviceSingletonFacade.getServices().entrySet()) {
    System.out.print("INSIDE PRINT MAP: "+entry.getKey() + " "+entry.getValue().getIdUser());
}
    
    }
    
    
    public void removeService(String serviceId){
    
          for(java.util.HashMap.Entry<String,Service> entry: this._serviceSingletonFacade.getServices().entrySet()){
            
              if(entry.getKey().equals(serviceId)){
              
                  System.out.print("SERVICE FOUND");
                  _serviceSingletonFacade.getServices().remove(entry.getKey());
                  System.out.print("SERVICES SIZE: "+_serviceSingletonFacade.getServices().size());
                  break;
              
              }
            }
        
  
    }
    
    public java.util.HashMap<String,EJBClasses.Service>getAll(){
    
        return this._serviceSingletonFacade.getServices();
    
    }
    
    public JSONObject convertListToJSON(){
    JSONObject obj = new JSONObject();
        try{
        
            for(java.util.HashMap.Entry<String,Service> entry: _serviceSingletonFacade.getServices().entrySet()){
            
                obj.put("serviceId", entry.getValue().getServiceId());
                System.out.print("Service added to list");
            }
        return obj;
        }
        catch(Exception ex){
            
            ex.printStackTrace(System.out);
            obj.put("status", "exception");
            return obj;
        
        }
    
    }
    
    
    
}
