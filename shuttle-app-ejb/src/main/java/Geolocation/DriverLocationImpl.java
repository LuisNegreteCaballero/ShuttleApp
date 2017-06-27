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
public class DriverLocationImpl implements DriverLocation{

    private Coordinates location;
    
    private Integer idDriver;
    
    @Override
    public Coordinates getLocation() {
        return location;
    }
    @Override
    public void setLocation(Coordinates location) {
        this.location = location;
    }
    @Override
    public Integer getIdDriver() {
        return idDriver;
    }
    @Override
    public void setIdDriver(Integer idDriver) {
        this.idDriver = idDriver;
    }

}
