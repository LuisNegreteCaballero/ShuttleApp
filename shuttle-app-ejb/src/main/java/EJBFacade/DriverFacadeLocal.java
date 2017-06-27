/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJBFacade;

import Geolocation.Coordinates;
import Geolocation.DriverLocation;
import java.util.List;
import javax.ejb.Local;
import model.Driver;

/**
 *
 * @author luisnegrete
 */
@Local
public interface DriverFacadeLocal {

    void create(Driver driver);

    void edit(Driver driver);

    void remove(Driver driver);

    Driver find(Object id);

    List<Driver> findAll();

    List<Driver> findRange(int[] range);
    
    java.util.List<Driver>nonTakenDrivers();
    
    java.util.List<model.Driver>findDriversInRange(double range, java.util.List<DriverLocation> drivers, Coordinates userPosition);

    int count();
    
    model.Driver findByEmail(String email);
    
    model.Driver findByEmailAndPassword(String email, String password);
    
}
