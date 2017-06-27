/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJBFacade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Country;

/**
 *
 * @author luisnegrete
 */
@Stateless
public class CountryFacade extends AbstractFacade<Country> implements CountryFacadeLocal {

    @PersistenceContext(unitName = "com.mycompany_shuttle-app-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CountryFacade() {
        super(Country.class);
    }
    
    @Override
    public java.util.List<model.Country>findAll(){
    
        try{
        
            javax.persistence.Query query = em.createNamedQuery("Country.findAll");
            
            return query.getResultList();
        
        }
        catch(javax.persistence.NoResultException | NullPointerException ex){
        
            ex.printStackTrace(System.out);
            
            return null;
        
        }
    
    
    }
    
    @Override
    public Country find(Integer id){
    
        try{
        
           javax.persistence.Query query = em.createNamedQuery("Country.findById");
           
           System.out.print("Country Id: "+id);
           
           query.setParameter("id", id);
           
           return (model.Country)query.getSingleResult();
        
        }
        catch(javax.persistence.NoResultException ex){
        
            ex.printStackTrace(System.out);
            
            return null;
        }
    
    }
    
}
