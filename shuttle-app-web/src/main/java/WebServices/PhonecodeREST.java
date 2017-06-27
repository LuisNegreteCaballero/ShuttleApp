/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebServices;

import javax.ws.rs.GET;
import javax.ws.rs.core.Response;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author luis
 */
@javax.ejb.Stateless
@javax.ws.rs.Path("/phonecode")
public class PhonecodeREST {
    
    @javax.ejb.EJB
    private EJBFacade.PhoneFacadeLocal _phoneFacade;
    
    
    @GET
    @javax.ws.rs.Path("/phonecodes")
    public Response getAll(){
    
        JSONObject obj = new JSONObject();
        
        try{
            
            JSONArray phonecodes = new JSONArray();
            
            for(model.Phonecode phonecode: this._phoneFacade.findAll()){
            
                JSONObject object = new JSONObject();
                
                object.put("countryId",phonecode.getCountry().getId());
                
                object.put("country", phonecode.getCountry().getName());
                
                object.put("code", phonecode.getCode());
                
                phonecodes.put(object);
            
            }
            
            obj.put("status", "success");
            
            obj.put("result", phonecodes);
            
            return Response.status(200).entity(obj.toString()).build();
        
        }catch(Exception ex){
        
            obj.put("status", "failure");
            
            ex.printStackTrace(System.out);
        
            return Response.status(200).entity(obj.toString()).build();
        }
    
    }
    
}
