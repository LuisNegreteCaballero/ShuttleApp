/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJBFacade;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import model.Service;

/**
 *
 * @author luisnegrete
 */
@Stateless
@Transactional
public class ServiceFacade extends AbstractFacade<Service> implements ServiceFacadeLocal {

    @PersistenceContext(unitName = "com.mycompany_shuttle-app-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;
    
    @javax.annotation.Resource
    private javax.ejb.EJBContext context;
    
     @javax.ejb.EJB
     private EJBFacade.AccountFacadeLocal _accountFacade;
     
     @javax.ejb.EJB
     private EJBFacade.DriverFacadeLocal _driverFacade;
     
     
     @javax.ejb.EJB
     private EJBFacade.AddressFacadeLocal _addressFacade;
      

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ServiceFacade() {
        super(Service.class);
    }
    //Create New Service
    @Override
    public void createService(String accountEmail, Integer idDriver,boolean round, model.Address startAddressFrom, model.Address startAddressTo, model.Address returnAddressFrom, model.Address returnAddressTo, Date startDate, Date finalDate){
    
        try {
            
            model.Service service = new model.Service();
            
            model.ServicePK servicePK = new model.ServicePK();
            
            servicePK.setEmail(accountEmail);
            
            service.setServicePK(servicePK);
            
            service.setIdDriver(this._driverFacade.find(idDriver));
            
            service.setAccount(this._accountFacade.find(accountEmail));
            
            service.setStartAddress(startAddressFrom);
            
            service.setFinalAddress(startAddressTo);
            
            service.setStartDate(startDate);
            
            if(returnAddressFrom != null){
            
                service.setReturnStartAddress(returnAddressFrom);
                
                service.setReturnEndAddress(returnAddressTo);
                
                service.setFinalDate(finalDate);
            
            }
            
           
            
            super.create(service);
            
          
            
            
        } catch (Exception ex) {
         
            Logger.getLogger(ServiceFacade.class.getName()).log(Level.SEVERE, null, ex);
        } 
    
    
    
    }
    
}
