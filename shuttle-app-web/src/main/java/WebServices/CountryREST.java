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
@javax.ws.rs.Path("/country")
@javax.ejb.Stateless
public class CountryREST {
 
    @javax.ejb.EJB
    private EJBFacade.CountryFacadeLocal _countryFacade;
    
   @javax.ws.rs.GET
   @javax.ws.rs.Path("/findAll")
   @javax.ws.rs.Produces(MediaType.APPLICATION_JSON)
    public Response findAll(){
    JSONObject obj = new JSONObject();
        try{
        
            obj.put("status","success");
             
            JSONArray countries = new JSONArray();
            
            if(_countryFacade.findAll() != null){
            
                System.out.print("Countries found: "+_countryFacade.findAll().size());
                
            for(model.Country country: _countryFacade.findAll()){
            
                JSONObject countryJSON = new JSONObject();
                
                countryJSON.put("id", country.getId());
                
                countryJSON.put("name", country.getName());
                
                countries.put(countryJSON);
            
            }
            
            }
            
            obj.put("result", countries);
            
             return Response.status(200).entity(obj.toString()).build();
        
        }
        catch(Exception ex){
            
            ex.printStackTrace(System.out);
            
            obj.put("status","failure");
            
            return Response.status(200).entity(obj.toString()).build();
        
        }
    
    }
    
}
