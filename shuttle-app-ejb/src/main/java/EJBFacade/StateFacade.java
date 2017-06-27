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
import model.State;

/**
 *
 * @author luisnegrete
 */
@Stateless
public class StateFacade extends AbstractFacade<State> implements StateFacadeLocal {

    @PersistenceContext(unitName = "com.mycompany_shuttle-app-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StateFacade() {
        super(State.class);
    }

    @Override
    public List<State> findByCountry(Integer idCountry) {
       
        try{
        
            javax.persistence.Query query = em.createNamedQuery("State.findByCountryId");
            
            query.setParameter("id", idCountry);
            
            return query.getResultList();
            
        }
        catch(javax.persistence.NoResultException ex){
        
            ex.printStackTrace(System.out);
            
            return null;
            
        }
        
    }
    
    
    
}
