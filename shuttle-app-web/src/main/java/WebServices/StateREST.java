/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebServices;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author luis
 */
@javax.ws.rs.Path("/state")
@javax.ejb.Stateless
public class StateREST {
    
    @javax.ejb.EJB
    private EJBFacade.StateFacadeLocal _stateFacade;
    
    @javax.ws.rs.Path("/findByCountry/{id}")
    @javax.ws.rs.GET
    @javax.ws.rs.Consumes(MediaType.APPLICATION_JSON)
     public Response findByCountryId(@javax.ws.rs.PathParam("id")Integer id){
     
         JSONObject obj = new JSONObject();
         
         try{
             
             obj.put("status", "success");
             
             JSONArray states = new JSONArray();
             
             for(model.State state: this._stateFacade.findByCountry(id)){
             
                JSONObject stateJSON = new JSONObject();
                
                stateJSON.put("idCountry", id);
                
                stateJSON.put("stateId", state.getStatePK().getIdState());
                
                stateJSON.put("name", state.getName());
                
                states.put(stateJSON);
             
             }
             
             obj.put("result", states);
             
             return Response.status(200).entity(obj.toString()).build();
             
         }
         catch(Exception ex){
         
             obj.put("status", "failure");
             
             ex.printStackTrace(System.out);
             
             return Response.status(200).entity(obj.toString()).build();
             
         }
     
     }
    
}
