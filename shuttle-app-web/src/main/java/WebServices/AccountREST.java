/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebServices;

import EJBFacade.AccountFacadeLocal;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author luisnegrete
 */
@javax.ejb.Stateless
@javax.ws.rs.Path("/account")
public class AccountREST {
    
    @javax.ejb.EJB
    private AccountFacadeLocal accountFacade;
    
    @javax.ejb.EJB
    private EJBFacade.PhoneFacadeLocal _phoneFacade;
    
    @javax.ejb.EJB
    private EJBFacade.PhoneFacadeLocal _phonecodeFacade;
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response edit(String json){
     JSONObject obj = new JSONObject();
    try{
    JSONObject input = new JSONObject(json);
    System.out.print(input);
    if(input.has("id")){
    //find user in database
    if(this.accountFacade.find(input.getString("id")) != null){
    //user found
    model.Account account = this.accountFacade.find(input.getString("id"));
    if(input.has("name")){
    
    account.setName(input.getString("name"));
    
    }
    if(input.has("lastname")){
    
    account.setLastName("lastname");
    
    }
    
    if(input.has("phonecodeid")){
    
    model.Phonecode phoneCode = this._phonecodeFacade.findPhonecode(input.getInt("phonecodeid"));
    
    account.setPhoneId(phoneCode);
    
    }
    
    if(input.has("phone")){
    
        account.setPhoneNumber(input.getString("phone"));
    
    }
    
    if(input.has("discounts")){
    
        account.setDiscounts(input.getBoolean("discounts"));
    
    }
    
    if(input.has("mytripsinformation")){
    account.setTripNotifications(input.getBoolean("mytripsinformation"));
    }
    
    this.accountFacade.edit(account);
    
    obj.put("status", "success");
    
    }
    else{
    obj.put("status", "user not found");
    }
    }
    else{
    obj.put("status", "invalid id");
    }
    return Response.status(200).entity(obj.toString()).build();
    }
    catch(Exception ex){
    
        ex.printStackTrace(System.out);
        
        obj.put("status", "failure");
        
        return Response.status(200).entity(obj.toString()).build();
    
    }
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response find(@PathParam("id") String id) {
    
        JSONObject obj = new JSONObject();
        
    try{
        
        obj.put("status", "success");
        
        model.Account account = this.accountFacade.find(id);
        
        if(account != null){
        
            JSONObject result = new JSONObject();
            
            result.put("email", account.getEmail());
            
            result.put("birthdate", account.getBirthdate());
            
            result.put("name", account.getName());
            
            result.put("lastname", account.getLastName());
            
            result.put("phone", account.getPhoneNumber());
            
            result.put("phonecodeid", account.getPhoneCode().getId());
            
            result.put("phonecode", account.getPhoneCode().getCode());
            
            result.put("discounts", account.getDiscounts());
            
            result.put("mytripsinformation", account.getTripNotifications());
            
            JSONArray array = new JSONArray();
            
            for(model.Role role: account.getRoleCollection()){
            
                JSONObject aux = new JSONObject();
                
                aux.put("role",role.getRoleName());
                
                array.put(aux);
            
            }
            
            result.put("roles", array);
            
            obj.put("result", result);
        
        }
        
        else{
        
            obj.put("status", "not found");
        
        }
        
        return Response.status(200).entity(obj.toString()).build();
     
    }
    catch(NullPointerException ex){
    
        obj.put("status", "failure");
        
        return Response.status(200).entity(obj.toString()).build();
    
    }
    
    }
    
    @javax.ws.rs.POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response Registrate(String user){
    
        JSONObject input = new JSONObject(user);
        
        model.Account account = new model.Account();
        if(input.getString("name") != null){
        account.setName(input.getString("name"));
        }
        account.setPassword(input.getString("password"));
        
        if(input.getString("phone")!=null){
        
        account.setPhoneNumber(input.getString("phone"));
        //Set phonecode
        account.setPhoneId(this._phoneFacade.findPhonecode(input.getInt("phonecodeId")));
        
        }
        
        //New Functionality added
        account.setPushNotifications(input.getBoolean("push-notifications"));
        
        account.setDiscounts(input.getBoolean("discounts"));
        
        account.setTripNotifications(input.getBoolean("trip-notifications"));
       
        if(input.getString("birthdate") != null){
        account.setBirthdate(new java.util.Date(input.getString("birthdate")));
        }
        account.setEmail(input.getString("email"));
        
        JSONObject obj = new JSONObject();
        
        try{
        
        enumeration.TransactionResult result = this.accountFacade.Registration(account);
        
        switch(result){
        
            case SUCCESS:
                obj.put("status", "success");
              break;
              
            case TRANSACTIONERROR:
                obj.put("status","error");
                break;
                
                
        
        }
        
        return Response.status(200).entity(obj.toString()).build();
     
        }
        catch (Exception ex){
        
            obj.put("status","error");
            
            return Response.status(200).entity(obj.toString()).build();
     
        
        }
    
    }
    
    @GET
    @javax.ws.rs.Path("/login/{username}/{password}")
    public Response Login(@javax.ws.rs.PathParam("username") String username, @javax.ws.rs.PathParam("password")String password){
        
        JSONObject obj = new JSONObject();
      
        try{
        
            model.Account account = this.accountFacade.find(username);
            
            if(account != null){
            
                if(account.getPassword().equals(password)){
                
                    obj.put("status", "success");
                
                }else{
                
                    obj.put("status", "login failed");
                
                }
            
            }
            else{
            
                obj.put("status", "user not found");
                
            }
            
           return Response.status(200).entity(obj.toString()).build(); 
        }
        catch(Exception ex){
        
           obj.put("status", "error");
           
           return Response.status(200).entity(obj.toString()).build();
        
        }
    
    }
    
}
