/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJBFacade;

import Geolocation.ConvertToCoordinates;
import Geolocation.Coordinates;
import Geolocation.DriverLocation;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import model.Driver;

/**
 *
 * @author luisnegrete
 */
@Stateless
@javax.ejb.TransactionManagement(javax.ejb.TransactionManagementType.BEAN)
public class DriverFacade extends AbstractFacade<Driver> implements DriverFacadeLocal {

    @PersistenceContext(unitName = "com.mycompany_shuttle-app-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @javax.annotation.Resource
    private javax.ejb.EJBContext context;
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DriverFacade() {
        super(Driver.class);
    }
    
    @Override
    public java.util.List<Driver>nonTakenDrivers(){
    
        try{
        
            javax.persistence.Query query = em.createNamedQuery("Driver.findByTaken");
            
            query.setParameter("taken", false);
            
            return query.getResultList();
        
        }
        catch(NullPointerException ex)
        {
            ex.printStackTrace(System.out);
            return null;
        
        }
    }
    
    @Override
    public model.Driver findByEmail(String email){
    
        try{
        
            javax.persistence.Query query = em.createNamedQuery("Driver.FindByEmail");
            
            query.setParameter("email", email);
            
            return (model.Driver)query.getSingleResult();
        }
        catch(javax.persistence.NoResultException ex){
        
            return null;
        
        }
    
    }
    
    @Override
    public model.Driver findByEmailAndPassword(String email, String password){
    try{
    
        javax.persistence.Query query = em.createNamedQuery("Driver.Login");
        
        query.setParameter("email", email);
        
        query.setParameter("password", password);
        
        return (Driver)query.getSingleResult();
    
    }
    catch(javax.persistence.NoResultException ex){return null;}
    }
    @Override
    //Find Drivers In Range
    public java.util.List<model.Driver>findDriversInRange(double range, java.util.List<DriverLocation> drivers, Coordinates userPosition){
    try{
    
        java.util.List<Integer>driversId = new java.util.ArrayList<Integer>();
        
        java.util.List<model.Driver>resultDrivers = new java.util.ArrayList<model.Driver>();
        
        for(DriverLocation driver: drivers){
        
            if(ConvertToCoordinates.calculateDistance(userPosition.getLatitude(), userPosition.getLongitude(), driver.getLocation().getLatitude(), driver.getLocation().getLongitude())<= range)
            {
            
                driversId.add(driver.getIdDriver());
            
            }
        }
        
        for (Integer id: driversId){
            context.getUserTransaction().begin();
            model.Driver driver = super.find(id);
            context.getUserTransaction().commit();
            if(!driver.getTaken()){
            
                resultDrivers.add(driver);
            
            }
        
        }
    return resultDrivers;
    }
        catch (NotSupportedException | SystemException | RollbackException | HeuristicMixedException | HeuristicRollbackException | SecurityException | IllegalStateException ex) {
           
            try {
                context.getUserTransaction().rollback();
            } catch (IllegalStateException | SecurityException | SystemException ex1) {
                Logger.getLogger(ServiceFacade.class.getName()).log(Level.SEVERE, null, ex1);
            }
            
            Logger.getLogger(ServiceFacade.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } 
    
    
        
    }
    
}
