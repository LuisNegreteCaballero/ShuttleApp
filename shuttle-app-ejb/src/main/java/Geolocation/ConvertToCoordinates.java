/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Geolocation;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 *
 * @author negre
 */
public class ConvertToCoordinates {
    
    public static Coordinates convertAddressToCoordinates(model.Address address){
    
        Coordinates coordinates = new CoordinatesImpl();
        coordinates.setStatus(GeolocationResult.FAILURE);
        try{
        String stringAddress = "";
        stringAddress = address.getCity().getState().getCountry().getName()+","+address.getCity().getState().getName()+","+address.getCity().getName()+","+address.getAddress();
                ;
        URL myUrl=new URL("http://maps.googleapis.com/maps/api/geocode/xml?address="+stringAddress+"&sensor=false");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(myUrl.openStream());
        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath xpath = xPathFactory.newXPath();
        javax.xml.xpath.XPathExpression expr = xpath.compile("/GeocodeResponse/result/geometry/location/lat");
        String latitude=expr.evaluate(doc,XPathConstants.STRING).toString();
           
           coordinates.setLatitude(new java.lang.Double(latitude));
           
           expr=xpath.compile("/GeocodeResponse/result/geometry/location/lng");
       
           String longitude=expr.evaluate(doc,XPathConstants.STRING).toString();
        if(latitude != null && !latitude.equals("") && longitude != null && !longitude.equals("")){
        
            coordinates.setLatitude(Double.parseDouble(latitude));
            coordinates.setLongitude(Double.parseDouble(longitude));
            coordinates.setStatus(GeolocationResult.SUCCESS);
        }
        
        }
        catch(MalformedURLException ex){
        
            ex.printStackTrace(System.out);
            
        } catch (SAXException ex) {
            Logger.getLogger(ConvertToCoordinates.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConvertToCoordinates.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(ConvertToCoordinates.class.getName()).log(Level.SEVERE, null, ex);
        } catch (XPathExpressionException ex) {
            Logger.getLogger(ConvertToCoordinates.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return coordinates;
    
    }
    
    public static double calculateDistance(double lat1,double lat2,double lon1,double lon2){
        
        
    
    double r=6371000;//Meters Earth Ratio
    
    double latRad1=Math.toRadians(lat1);
    
    double latRad2=Math.toRadians(lat2);
    
    double varLat=Math.toRadians(lat2-lat1);
    
    double lonVar=Math.toRadians(lon2-lon1);
    
    double a=Math.sin(varLat/2)*Math.sin(varLat/2)+Math.cos(latRad1)*Math.sin(lonVar/2)*Math.sin(lonVar/2);
    
    double c=2*Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

    //Distance in meters
    return r*c;
    }
     
    
}
