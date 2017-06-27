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
public interface Coordinates {
    
    public double getLatitude();
    
    public void setLatitude(double latitude);
    
    public double getLongitude();
    
    public void setLongitude(double longitude);
    
    public void setStatus(GeolocationResult status);
    
    public GeolocationResult getStatus();
}
