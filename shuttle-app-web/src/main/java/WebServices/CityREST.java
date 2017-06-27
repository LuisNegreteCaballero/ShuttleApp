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
@javax.ws.rs.Path("/city")
@javax.ejb.Stateless
public class CityREST {
    
    @javax.ejb.EJB
    private EJBFacade.CityFacadeLocal _cityFacade;
    
    @javax.ws.rs.Path("/findByCountry/{idCountry}")
    @javax.ws.rs.GET
    @javax.ws.rs.Consumes(MediaType.APPLICATION_JSON)    
     public Response findByCountry(@javax.ws.rs.PathParam("idCountry")Integer idCountry ){
         
            JSONObject obj = new JSONObject(); 
         
            try 
            {
             obj.put("status", "success");
         JSONArray cities = new JSONArray();
         
         java.util.List<model.City> cityList = this._cityFacade.findByCountry(idCountry);
         
         System.out.print("CITIES LENGTH: "+cityList.size()+ "IDCITY:" +idCountry);
         
         for(model.City city: this._cityFacade.findByCountry(idCountry)){
         
           JSONObject cityJSON = new JSONObject();
           
           cityJSON.put("idCountry", city.getCityPK().getId());
           
           cityJSON.put("idState", city.getCityPK().getIdState());
           
           cityJSON.put("idCity", city.getCityPK().getIdCity());
           
           cityJSON.put("name", city.getName());
           
           cities.put(cityJSON);
         
         }
         
         obj.put("result", cities);
         
         return Response.status(200).entity(obj.toString()).build();
            
            }
             catch(Exception ex){
                 
                 ex.printStackTrace(System.out);
                 
                 obj.put("status", "failure");
                 
                 return Response.status(200).entity(obj.toString()).build();
                 
             }
         }
            
            
    
    @javax.ws.rs.Path("/findByCountryState/{idCountry}/{idState}")
    @javax.ws.rs.GET
    @javax.ws.rs.Consumes(MediaType.APPLICATION_JSON)
     public Response findByCountryState(@javax.ws.rs.PathParam("idCountry")Integer idCountry,@javax.ws.rs.PathParam("idState")Integer idstate ){
     
         JSONObject obj = new JSONObject();
         
         try{
         obj.put("status", "success");
         JSONArray cities = new JSONArray();
         for(model.City city: this._cityFacade.findByCountryState(idCountry, idstate)){
         
           JSONObject cityJSON = new JSONObject();
           
           cityJSON.put("idCountry", city.getCityPK().getId());
           
           cityJSON.put("idState", city.getCityPK().getIdState());
           
           cityJSON.put("idCity", city.getCityPK().getIdCity());
           
           cityJSON.put("name", city.getName());
           
           cities.put(cityJSON);
         
         }
         
         obj.put("result", cities);
         
         return Response.status(200).entity(obj.toString()).build();
         }
         catch(Exception ex){
             obj.put("status", "failure");
             ex.printStackTrace(System.out);
             return Response.status(200).entity(obj.toString()).build();
         }
     
     }
     
    
}
