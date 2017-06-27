/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBean;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ejb.Stateful;
import org.json.JSONObject;

/**
 *
 * @author luis
 */
@Stateful
public class Service implements ServiceLocal {
    
    
    
    @javax.ejb.EJB
    private EJBFacade.CountryFacadeLocal _countryFacade;
    
    @javax.ejb.EJB
    private EJBFacade.StateFacadeLocal _stateFacade;
    
    @javax.ejb.EJB
    private EJBFacade.CityFacadeLocal _cityFacade;
    @Override
    //From is a boolean indicating if the service is from the airport
    public JSONObject orderService(String idUser, Integer startCountryIdFrom,Integer startStateIdFrom,Integer startCityIdFrom,String startAddressFrom, Integer startCountryIdTo, Integer startStateIdTo, Integer startCityIdTo, String startAddressTo,String startDateString,Integer returnCountryIdFrom,Integer returnStateIdFrom, Integer returnCityIdFrom, String returnAddressFrom,Integer returnCountryIdTo,Integer returnStateIdTo,Integer returnCityIdTo ,
    String returnAddressTo,String returnDateString,boolean round) {
    JSONObject object = new JSONObject();
        
        try{
        
        object.put("status","success");
        
        JSONObject result = new JSONObject();
        
        String startFromAddress = "";
        
        String startToAddress = "";
        
        model.Country countryFrom = this._countryFacade.find(startCountryIdFrom);
        
        System.out.print(countryFrom.getName());
        
        model.State stateFrom = this._stateFacade.find(new model.StatePK(startStateIdFrom,startCountryIdFrom));
        
        System.out.print(stateFrom.getName());
        
        model.City cityFrom = this._cityFacade.find(new model.CityPK(startCityIdFrom,startStateIdFrom,startCountryIdFrom));
        
        System.out.print(cityFrom.getName());
        
        startFromAddress = countryFrom.getName()+", "+stateFrom.getName()+", "+cityFrom.getName()+", "+startAddressFrom;
        
        startToAddress = this._countryFacade.find(startCountryIdTo).getName()+", "+this._stateFacade.find(new model.StatePK(startStateIdTo,startCountryIdTo)).getName()+", "+this._cityFacade.find(new model.CityPK(startCityIdTo,startStateIdTo,startCountryIdTo)).getName()+", "+startAddressTo;
        
        //StartDate
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        System.out.print("Start Date "+startDateString);
        Date startDate =  formatter.parse(startDateString);

        
        
        result.put("startAddressFrom", startFromAddress);
        
        result.put("startAddressTo", startToAddress);
        
        result.put("startIdCountryFrom", startCountryIdFrom);
        
        result.put("startIdStateFrom", startStateIdFrom);
        
        result.put("startIdCityFrom", startCityIdFrom);
        
        result.put("startIdCountryTo", startCountryIdTo);
        
        result.put("startIdStateTo", startStateIdTo);
        
        result.put("startIdCityTo", startCityIdTo);
        
        result.put("startDate", startDate);
        
        result.put("userId", idUser);
        
        if(round){
            
        String returnFromAddress = "";
        
        String returnToAddress = "";
        
        returnFromAddress = this._countryFacade.find(returnCountryIdFrom).getName()+", "+this._stateFacade.find(new model.StatePK(returnStateIdFrom,returnCountryIdFrom)).getName()+", "+this._cityFacade.find(new model.CityPK(returnCityIdFrom,returnStateIdFrom,returnCountryIdFrom)).getName()+", "+returnAddressFrom;
        
        returnToAddress = this._countryFacade.find(returnCountryIdTo).getName()+", "+this._stateFacade.find(new model.StatePK(returnStateIdTo,returnCountryIdTo)).getName()+", "+this._cityFacade.find(new model.CityPK(returnCityIdTo,returnStateIdTo,returnCountryIdTo)).getName()+", "+returnAddressTo;
        
        //Return Date
        SimpleDateFormat formatterReturn = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        System.out.print("Start Date "+startDateString);
       // Date startDate =  formatter.parse(startDateString);
        Date returnDate = formatterReturn.parse(returnDateString);
        
       
        
        result.put("returnAddressFrom", returnFromAddress);
        
        result.put("returnAddressTo", returnToAddress);
        
        result.put("returnIdCountryFrom", returnCountryIdFrom);
        
        result.put("returnIdStateFrom", returnStateIdFrom);
        
        result.put("returnIdCityFrom", returnCityIdFrom);
        
        result.put("returnIdCountryTo", returnCountryIdTo);
        
        result.put("returnIdStateTo", returnStateIdTo);
        
        result.put("returnIdCityTo", returnCityIdTo);
        
        result.put("returnDate", returnDate);
        
        }
        
        object.put("result",result);
        
        return object;
        }
        catch(Exception ex){
        
            object.put("status","failure");
            ex.printStackTrace(System.out);
            return object;
        
        }
    
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
