/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJBFacade;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Country;
import model.Phonecode;

/**
 *
 * @author luis
 */
@Stateless
public class PhoneFacade extends AbstractFacade<model.Phonecode> implements PhoneFacadeLocal {

      @PersistenceContext(unitName = "com.mycompany_shuttle-app-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PhoneFacade() {
        super(model.Phonecode.class);
    }
    @Override
    public java.util.List<model.Phonecode>findAll(){
    
        return super.findAll();
    
    }
    @Override
public model.Phonecode findPhonecode(Integer id){

return super.find(id);

}
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    
}
