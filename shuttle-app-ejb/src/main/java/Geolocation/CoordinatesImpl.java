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
public class CoordinatesImpl implements Coordinates {

    private double latitude;
    
    private double longitude;
    
    private GeolocationResult status;
    
    @Override
    public double getLatitude() {
  
    return this.latitude;
    
    }

    @Override
    public void setLatitude(double latitude) {
        
        this.latitude = latitude;
        
    }

    @Override
    public double getLongitude() {
   
        return this.longitude;
    
    }

    @Override
    public void setLongitude(double longitude) {
        
        this.longitude = longitude;
    
    }

    @Override
    public void setStatus(GeolocationResult status) {
   this.status = status;
    }

    @Override
    public GeolocationResult getStatus() {
   return this.status;
    }
    
}
