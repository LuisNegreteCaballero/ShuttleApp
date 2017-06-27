/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBean;

import javax.ejb.Local;
import org.json.JSONObject;

/**
 *
 * @author luis
 */
@Local
public interface ServiceLocal {
   public JSONObject orderService(String idUser, Integer startCountryIdFrom,Integer startStateIdFrom,Integer startCityIdFrom,String startAddressFrom, Integer startCountryIdTo, Integer startStateIdTo, Integer startCityIdTo, String startAddressTo,String startDateString,Integer returnCountryIdFrom,Integer returnStateIdFrom, Integer returnCityIdFrom, String returnAddressFrom,Integer returnCountryIdTo,Integer returnStateIdTo,Integer returnCityIdTo ,
    String returnAddressTo,String returnDateString,boolean round);
     }
