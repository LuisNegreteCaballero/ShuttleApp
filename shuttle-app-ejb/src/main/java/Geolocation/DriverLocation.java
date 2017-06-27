/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Geolocation;

/**
 *
 * @author negre
 */
public interface DriverLocation {
    Coordinates getLocation();
    void setLocation(Coordinates location);
    Integer getIdDriver();
    void setIdDriver(Integer idDriver);
    
}
