/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebServices;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONObject;

/**
 *
 * @author negre
 */
@javax.ejb.Stateless
@javax.ws.rs.Path("/service")
public class ServiceREST {
    @javax.ejb.EJB
    private EJBFacade.ServiceFacadeLocal _serviceFacade;
    
    @javax.inject.Inject
    private ServiceController.ServiceController _serviceController;
    public Response createService(){
        
     
        JSONObject obj = new JSONObject();
        try{
        
        return Response.status(200).entity(obj.toString()).build();
        }
        catch(NullPointerException ex){
        
            obj.put("status", "error");
        
        return Response.status(200).entity(obj.toString()).build();
            
        }
    
    }
    
    @javax.ws.rs.Path("/getServiceList")
    @javax.ws.rs.GET
    @javax.ws.rs.Produces(MediaType.APPLICATION_JSON)
    public Response orderService(String json){
    JSONObject obj = new JSONObject();
        try{
        
          obj.put("status","success");
          
          obj.put("service_list", this._serviceController.convertListToJSON());
          
        return Response.status(200).entity(obj.toString()).build();
        }
        catch(Exception ex){
        
              obj.put("status", "error");
        
        return Response.status(200).entity(obj.toString()).build();
        
        }
    
    }
}
