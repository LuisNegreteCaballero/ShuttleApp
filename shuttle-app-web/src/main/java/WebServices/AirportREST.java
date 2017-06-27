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
 * @author negre
 */
@javax.ws.rs.Path("/airport")
@javax.ejb.Stateless
public class AirportREST {
    /*
    @javax.ejb.EJB
    private EJBFacade.AirportFacadeLocal _airportFacade;
    
    @javax.ws.rs.GET
    @javax.ws.rs.Produces(MediaType.APPLICATION_JSON)
    public Response findAll(){
    JSONObject obj = new JSONObject();
        try{
        
        java.util.List<model.Airport>airports = _airportFacade.findAll();
        
        JSONArray airportsArray = new JSONArray();
        
        for(model.Airport airport: airports){
        
            JSONObject airportObject = new JSONObject();
            
            airportObject.put("id", airport.getAirportId());
            
            airportObject.put("name", airport.getName());
            
            airportObject.put("latitude", airport.getIdGeolocation().getLatitude());
            
            airportObject.put("longitude", airport.getIdGeolocation().getLongitude());
            
            airportObject.put("idCountry", airport.getCity().getCityPK().getId());
            
            airportObject.put("idState", airport.getCity().getCityPK().getIdState());
            
            airportObject.put("idCity", airport.getCity().getCityPK().getIdCity());
            
            airportsArray.put(airportObject);
            
        }
        
        obj.put("result", airportsArray);
        
        obj.put("status","ok");
        
        return Response.status(200).entity(obj.toString()).build();
        }
        catch(NullPointerException ex){
        
            obj.put("status", "error");
        
        return Response.status(200).entity(obj.toString()).build();
            
        }
    
    }
    
    @javax.ws.rs.GET
    @javax.ws.rs.Path("{id}")
    public Response find(@javax.ws.rs.PathParam("id")Integer id){
    JSONObject obj = new JSONObject();
        
        try{
            
            model.Airport airport = this._airportFacade.find(id);
            
            JSONObject airportObject = new JSONObject();
            
            airportObject.put("id", airport.getAirportId());
            
            airportObject.put("name", airport.getName());
            
            airportObject.put("latitude", airport.getIdGeolocation().getLatitude());
            
            airportObject.put("longitude", airport.getIdGeolocation().getLongitude());
            
            obj.put("result", airportObject);
            
            obj.put("status", "ok");
            
            return Response.status(200).entity(obj.toString()).build();
        }
         catch(NullPointerException ex){
        
            obj.put("status", "error");
        
        return Response.status(200).entity(obj.toString()).build();
            
        }
    
    }
    */
}
