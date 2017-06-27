/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJBFacade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Account;
import model.Phonecode;

/**
 *
 * @author luis
 */
@Stateless
public class PhonecodeFacade extends AbstractFacade<model.Phonecode> implements PhonecodeFacadeLocal {
    
@PersistenceContext(unitName = "com.mycompany_shuttle-app-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    public PhonecodeFacade() {
        super(model.Phonecode.class);
    }

    @Override
    protected EntityManager getEntityManager() {
    return em;
    }
@Override
    public model.Phonecode find(Object id){
    
        try{
        
          return super.find(id);
            
        }
        catch(Exception ex){
        
            return null;
        
        }
    
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
