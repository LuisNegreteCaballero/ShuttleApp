/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebServices;

import java.text.SimpleDateFormat;
import javax.inject.Inject;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.Address;
import model.CityPK;
import model.Driver;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author luis
 */
@javax.ejb.Stateless
@javax.ws.rs.Path("/orderservice")
public class OrderServiceREST {
    
    @javax.inject.Inject
    private ServiceController.ServiceController _serviceController;
    
    @javax.ejb.EJB
    private SessionBean.ServiceLocal _service;
    
    @javax.ejb.EJB
    private EJBFacade.ServiceFacadeLocal _serviceFacade;
    
    @javax.ejb.EJB
    private EJBFacade.CityFacadeLocal _cityFacade;
    
    @javax.ejb.EJB
    private EJBFacade.DriverFacadeLocal _driverFacade;
    
    @Inject
    private SessioController.SessionController _sessionController;
    
    @javax.ws.rs.Path("/ordernew")
    @javax.ws.rs.POST
    @javax.ws.rs.Consumes(MediaType.APPLICATION_JSON)
    public Response orderService(String json){
    
        JSONObject input = new JSONObject(json);
        
        JSONObject obj = new JSONObject();
        
        try{
            
         obj.put("status", "success");
         
         System.out.print(input);
         
         EJBClasses.Service service = new EJBClasses.Service();
         
         String idUser = input.getString("idUser");
         
         service.setIdUser(idUser);
         
         Integer startCountryIdFrom = input.getInt("startCountryIdFrom");
         
         service.setIdStartCountryFrom(startCountryIdFrom);
         
         Integer startStateIdFrom = input.getInt("startStateIdFrom");
         
         service.setIdStartStateFrom(startStateIdFrom);
         
         Integer startCityIdFrom = input.getInt("startCityIdFrom");
         
         service.setIdStartCityFrom(startCityIdFrom);
         
         String startAddressFrom = input.getString("startAddressFrom");
         
         service.setStartAddressFrom(startAddressFrom);
         
         Integer startCountryIdTo = input.getInt("startCountryIdTo");
         
         service.setIdStartCountryTo(startCountryIdTo);
         
         Integer startStateIdTo = input.getInt("startStateIdTo");
         
         service.setIdStartStateTo(startStateIdTo);
         
         Integer startCityIdTo = input.getInt("startCityIdTo");
         
         service.setIdStartCityTo(startCityIdTo);
         
         String  startAddressTo = input.getString("startAddressTo");
         
         service.setStartAddressTo(startAddressTo);
         
         String startDate = input.getString("startDate");
         
         
         service.setStartDate(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(startDate));
         
         boolean round = input.getBoolean("round");
         
         String id = idUser+"--"+startDate;
         
         service.setServiceId(id);
         
         service.setIdUser(idUser);
         
         JSONObject result = null;
         
         if(round){
         //It is a round trip
         Integer returnCountryIdFrom = input.getInt("returnCountryIdFrom");
         
         service.setIdReturnCountryFrom(returnCountryIdFrom);
         
         Integer returnStateIdFrom = input.getInt("returnStateIdFrom");
         
         service.setIdReturnStateFrom(returnStateIdFrom);
         
         Integer returnCityIdFrom = input.getInt("returnCityIdFrom");
         
         service.setIdReturnCityFrom(returnCityIdFrom);
         
         String returnAddressFrom = input.getString("returnAddressFrom");
         
         service.setReturnAddressFrom(returnAddressFrom);
         
         Integer returnCountryIdTo = input.getInt("returnCountryIdTo");
         
         service.setIdReturnCountryTo(returnCountryIdTo);
         
         Integer returnStateIdTo = input.getInt("returnStateIdTo");
         
         service.setIdReturnStateTo(returnStateIdTo);
         
         Integer returnCityIdTo = input.getInt("returnCityIdTo");
         
         service.setIdReturnCityTo(returnCityIdTo);
         
         String  returnAddressTo = input.getString("returnAddressTo");
         
         service.setReturnAddressTo(returnAddressTo);
         
         String returnDate =input.getString("returnDate");
         
         service.setReturnDate(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(returnDate));
         
         service.setIsRound(true);
         
         result = this._service.orderService(idUser, startCountryIdFrom, startStateIdFrom, startCityIdFrom, startAddressFrom, startCountryIdTo, startStateIdTo, startCityIdTo, startAddressTo, startDate, returnCountryIdFrom, returnStateIdFrom, returnCityIdFrom, returnAddressFrom, returnCountryIdTo, returnStateIdTo, returnCityIdTo, returnAddressTo, returnDate, round);
         
         this._serviceController.addService(service);
         
         }
         
         else{
         
         // result = this._service.orderService(idUser, startCountryIdFrom, startStateIdFrom, startCityIdFrom, startAddressFrom,startCountryIdTo, startStateIdTo,startCityIdTo,startAddressTo,null,null,null,null,null,null,null,null,null,null,null,null,null,null,,round);
         
         service.setIsRound(false);
         
         result = this._service.orderService(idUser, startCountryIdFrom, startStateIdFrom, startCityIdFrom, startAddressFrom, startCountryIdTo, startStateIdTo, startCityIdTo, startAddressTo, startDate,  null, null, null, null, null, null, null, null, null, false);
         
         this._serviceController.addService(service);
         
         }
         
         result.put("id", id);
         
         result.put("type", "request");
         
         result.put("role","driver");
         
         Socket.ServiceSocket.sendMessageToAll(result);
         
         return Response.status(200).entity(obj.toString()).build();
     
        }
        catch(Exception ex){
        
            ex.printStackTrace(System.out);
            
            obj.put("status", "failure");
            
             return Response.status(200).entity(obj.toString()).build();
     
        
        }
    
    }
    
    @javax.ws.rs.Path("/confirmService")
    @javax.ws.rs.POST
    @javax.ws.rs.Consumes(MediaType.APPLICATION_JSON)
    public Response ServiceConfirmation(String json){
    
        JSONObject obj = new JSONObject();
        
        try{
        
        JSONObject input = new JSONObject(json);
            
        String idService = input.getString("serviceId");
        
        Integer idDriver = input.getInt("driverId");
        
        System.out.print("Service ID: "+idService);
        
        if(this._serviceController.find(idService) != null){
        
            obj.put("status", "success");
            
            EJBClasses.Service service = this._serviceController.find(idService);
        
            JSONObject result = new JSONObject();
            
            result.put("type","confirmation");
            
            result.put("role","driver");
        
            result.put("message", "Service Accepted");
                
            result.put("serviceId",idService);
       
            obj.put("result", result);
             
             //AddService to database
             
             //StartAddressFrom
             Address startAddressFrom = new Address();
             
             //CityPK
             
             CityPK cityPK = new CityPK();
             
             cityPK.setId(service.getIdStartCountryFrom());
             
             cityPK.setIdState(service.getIdStartStateFrom());
             
             cityPK.setIdCity(service.getIdStartCityFrom());
             
             startAddressFrom.setCity(this._cityFacade.find(cityPK));
             
             startAddressFrom.setAddress(service.getStartAddressFrom());
             
             //StartAddressTo
             
             Address startAddressTo = new Address();
             
             model.CityPK startAddressToCityPK = new model.CityPK();
             
             startAddressToCityPK.setId(service.getIdStartCountryTo());
             
             startAddressToCityPK.setIdState(service.getIdStartStateTo());
             
             startAddressToCityPK.setIdCity(service.getIdStartCityTo());
             
             startAddressTo.setCity(this._cityFacade.find(startAddressToCityPK));
             
             startAddressTo.setAddress(service.getStartAddressTo());
             
             if(!service.isRound()){
             _serviceFacade.createService(service.getIdUser(), idDriver, service.isRound(), startAddressFrom, startAddressTo,null, null, service.getStartDate(), null);
             }
             else{
             
                 //ReturnAddressFrom
                 model.Address returnAddressFrom = new model.Address();
                 
                 model.CityPK returnAddressCityPK = new model.CityPK();
                 
                 returnAddressCityPK.setId(service.getIdReturnCountryFrom());
                 
                 returnAddressCityPK.setIdState(service.getIdReturnStateFrom());
                 
                 returnAddressCityPK.setIdCity(service.getIdReturnCityFrom());
                 
                 returnAddressFrom.setCity(this._cityFacade.find(returnAddressCityPK));
                 
                 returnAddressFrom.setAddress(service.getReturnAddressFrom());
                 
                 //Return address to
                 
                 model.Address returnAddressTo = new model.Address();
                 
                 model.CityPK returnAddressToCityPK = new model.CityPK();
                 
                 returnAddressToCityPK.setId(service.getIdReturnCountryTo());
                 
                 returnAddressToCityPK.setIdState(service.getIdReturnStateTo());
                 
                 returnAddressToCityPK.setIdCity(service.getIdReturnCityTo());
                 
                 returnAddressTo.setCity(this._cityFacade.find(returnAddressToCityPK));
                 
                 returnAddressTo.setAddress(service.getReturnAddressTo());
                 
                 _serviceFacade.createService(service.getIdUser(), idDriver, service.isRound(), startAddressFrom, startAddressTo, returnAddressFrom, returnAddressTo, service.getStartDate(),service.getReturnDate());
             
             }
             //Remove service from Application Bean
             this._serviceController.removeService(idService);
             
             result.put("serviceList", this._serviceController.convertListToJSON());
             
             Socket.ServiceSocket.sendMessageToAll(result);
             
             Socket.ServiceSocket socket = new Socket.ServiceSocket();
             
             JSONObject jsonObject = new JSONObject();
             
             jsonObject.put("message","service accepted");
             
             jsonObject.put("status", "success");
             
             jsonObject.put("role", "user");
             
             JSONObject payload = new JSONObject();
             
             //Service Information
             
             model.Driver driver = _driverFacade.find(idDriver);
             
             payload.put("driver_name", driver.getName());
             
             payload.put("driver_picture", driver.getProfilePicture());
             
             payload.put("car_brand", driver.getCarId().getBrand());
             
             payload.put("car_model", driver.getCarId().getModel());
             
             payload.put("car_number_plate", driver.getCarId().getNumberPlate());
             
             payload.put("start_address", service.getStartAddressFrom());
             
             payload.put("destination_address", service.getStartAddressTo());
             
             
             
             jsonObject.put("payload", payload);
             
             for(EJBClasses.Session aux: this._sessionController.getSessions()){
             
                 if(aux.getUsername().equals(service.getIdUser())){
                       //User Found
                       
                       socket.sendMessageToUser(jsonObject, aux.getSession());
                       
                     break;
                 
                 }
             
             }
             
           
             
        }
        
        else{
        
            this._serviceController.pintMap();
            
              obj.put("status", "failure");
              
              obj.put("message", "service not found in list");
              
               
        }
        
        return Response.status(200).entity(obj.toString()).build();
        
        }catch(Exception ex){
        
            ex.printStackTrace(System.out);
            
            obj.put("status", "failure");
             obj.put("message", "exception caught");
             return Response.status(200).entity(obj.toString()).build();
        
        }
    
    }
    
}
