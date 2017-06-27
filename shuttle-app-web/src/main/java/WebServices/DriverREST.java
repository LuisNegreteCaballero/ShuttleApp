/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebServices;

import Geolocation.Coordinates;
import Geolocation.CoordinatesImpl;
import Geolocation.DriverLocation;
import Geolocation.DriverLocationImpl;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author negre
 */
@javax.ejb.Stateless
@javax.ws.rs.Path("/driver")
public class DriverREST {
    @javax.ejb.EJB
    private EJBFacade.DriverFacadeLocal _driverFacade;
    
    @javax.ws.rs.GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDrivers(){
    JSONObject obj = new JSONObject();
    try{
    
    java.util.List<model.Driver>drivers = _driverFacade.findAll();
    obj.put("status", "ok");
    JSONArray driversArray = new JSONArray();
    for(model.Driver driver: drivers){
    
        JSONObject driverObject = new JSONObject();
        //Driver Id
        driverObject.put("driverId", driver.getId());
        
        //Driver name
        driverObject.put("name", driver.getName());
        
        //Driver taken
        driverObject.put("taken", driver.getTaken());
        
        //Car object
        JSONObject car = new JSONObject();
        
        car.put("carId", driver.getCarId().getCarId());
        
        car.put("brand", driver.getCarId().getBrand());
        
        car.put("model", driver.getCarId().getModel());
        
        car.put("year", driver.getCarId().getYear());
        
        driverObject.put("car", car);
   
        driversArray.put(driverObject);
    
    }
    
    obj.put("result", driversArray);
    
     return Response.status(200).entity(obj.toString()).build();
    
    }
    catch(NullPointerException ex){
    
        obj.put("status", "error");
        
        return Response.status(200).entity(obj.toString()).build();
    
    }
    }
    
    @javax.ws.rs.GET()
    @javax.ws.rs.Path("/findByEmail/{email}")
    @javax.ws.rs.Produces(MediaType.APPLICATION_JSON)
    public Response findByEmail(@javax.ws.rs.PathParam("email")String email){
    JSONObject obj = new JSONObject();
        try{
        
            if(this._driverFacade.findByEmail(email)!= null){
            model.Driver driver = this._driverFacade.findByEmail(email);
                JSONObject driverObject = new JSONObject();
        //Driver Id
        driverObject.put("driverId", driver.getId());
        
        //Driver name
        driverObject.put("name", driver.getName());
        
        //Driver taken
        driverObject.put("taken", driver.getTaken());
        
        //Car object
        JSONObject car = new JSONObject();
        
        car.put("carId", driver.getCarId().getCarId());
        
        car.put("brand", driver.getCarId().getBrand());
        
        car.put("model", driver.getCarId().getModel());
        
        car.put("year", driver.getCarId().getYear());
        
        driverObject.put("car", car);
        
        obj.put("result", driverObject);
         
         obj.put("status","ok");
         
            
            }
            else{
            
                 obj.put("status", "failure");
                 obj.put("message", "driver not found");
            
            }
        return Response.status(200).entity(obj.toString()).build();
        }
    catch(Exception ex){
    
        obj.put("status", "failure");
        
        return Response.status(200).entity(obj.toString()).build();
    
    }
    }
    
    @javax.ws.rs.GET()
    @javax.ws.rs.Path("{id}")
    @javax.ws.rs.Produces(MediaType.APPLICATION_JSON)
    public Response find(@javax.ws.rs.PathParam("id")Integer id){
     JSONObject obj = new JSONObject();
   
        try{
        
         model.Driver driver = this._driverFacade.find(id);
         
         JSONObject driverObject = new JSONObject();
        //Driver Id
        driverObject.put("driverId", driver.getId());
        
        //Driver name
        driverObject.put("name", driver.getName());
        
        //Driver taken
        driverObject.put("taken", driver.getTaken());
        
        //Car object
        JSONObject car = new JSONObject();
        
        car.put("carId", driver.getCarId().getCarId());
        
        car.put("brand", driver.getCarId().getBrand());
        
        car.put("model", driver.getCarId().getModel());
        
        car.put("year", driver.getCarId().getYear());
        
        driverObject.put("car", car);
        
        obj.put("result", driverObject);
         
         obj.put("status","ok");
         return Response.status(200).entity(obj.toString()).build();
        }
        catch(NullPointerException ex){
        
          obj.put("status", "error");
        
        return Response.status(200).entity(obj.toString()).build();
        }
        
    }
    
    @javax.ws.rs.POST
    @javax.ws.rs.Path("/findDriversInRange")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response findRangeDrivers(String json){
    JSONObject obj = new JSONObject();
    
    try{
        JSONObject input = new JSONObject(json);
        System.out.print(input);
        JSONArray drivers = input.getJSONArray("drivers");
        JSONObject user = input.getJSONObject("user");
        
        java.util.List<DriverLocation>driversGeolocation = new java.util.ArrayList<DriverLocation>();
        
        if(drivers != null){
        
            System.out.print("Drivers Found "+drivers.length());
            
            for(int i = 0; i<drivers.length() ; i++){
            
                JSONObject driver = drivers.getJSONObject(i);
                
                DriverLocation aux = new DriverLocationImpl();
                
                aux.setIdDriver(driver.getInt("driverId"));
                
                JSONObject coordinates = driver.getJSONObject("coordinates");
                
                Coordinates location = new CoordinatesImpl();
                
                location.setLatitude(coordinates.getDouble("latitude"));
                
                location.setLongitude(coordinates.getDouble("longitude"));
                
                aux.setLocation(location);
                
                driversGeolocation.add(aux);
            
            }
        
        }
        Coordinates userCoordinates = new CoordinatesImpl();
            
        if(user != null){
            
            userCoordinates.setLatitude(user.getDouble("latitude"));
            userCoordinates.setLongitude(user.getDouble("longitude"));
            
        
        }
        
       java.util.List<model.Driver> result = this._driverFacade.findDriversInRange(input.getDouble("range"), driversGeolocation, userCoordinates);
        
        System.out.print("Drivers list length: "+result.size());
        
        obj.put("status", "ok");
    JSONArray driversArray = new JSONArray();
    
    for(model.Driver driver: result){
    
        JSONObject driverObject = new JSONObject();
        //Driver Id
        driverObject.put("driverId", driver.getId());
        
        //Driver name
        driverObject.put("name", driver.getName());
        
        //Driver taken
        driverObject.put("taken", driver.getTaken());
        
        //Car object
        JSONObject car = new JSONObject();
        
        car.put("carId", driver.getCarId().getCarId());
        
        car.put("brand", driver.getCarId().getBrand());
        
        car.put("model", driver.getCarId().getModel());
        
        car.put("year", driver.getCarId().getYear());
        
        driverObject.put("car", car);
   
        driversArray.put(driverObject);
    
    }
    
    obj.put("result", driversArray);
        
     return Response.status(200).entity(obj.toString()).build();
    }
    catch(NullPointerException ex){
      obj.put("status", "error");
        
        return Response.status(200).entity(obj.toString()).build();
    }
    
    }
    
    //Login
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/login/{email}/{password}")
    public Response login(@javax.ws.rs.PathParam("email")String email, @javax.ws.rs.PathParam("password")String password){
    JSONObject obj = new JSONObject();
        try{
        
            model.Driver driver = this._driverFacade.findByEmailAndPassword(email, password);
            
            if(driver != null){
            
                obj.put("status", "success");
                
                obj.put("driver_id", driver.getId());
                
                obj.put("driver_email", driver.getEmail());
            
            }
            else{
            
                obj.put("status", "error");
                
                obj.put("message", "wrong email or password");
                
            }
            
            
            return Response.status(200).entity(obj.toString()).build();
        }
        catch(Exception ex){
        
            ex.printStackTrace(System.out);
            
             obj.put("status", "error");
        
        return Response.status(200).entity(obj.toString()).build();
            
        }
    
    }
    
    
}
