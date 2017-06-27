/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJBFacade;

import java.util.List;
import javax.ejb.Local;
import model.GeoLocation;

/**
 *
 * @author luisnegrete
 */
@Local
public interface GeoLocationFacadeLocal {

    void create(GeoLocation geoLocation);

    void edit(GeoLocation geoLocation);

    void remove(GeoLocation geoLocation);

    GeoLocation find(Object id);

    List<GeoLocation> findAll();

    List<GeoLocation> findRange(int[] range);

    int count();
    
}
