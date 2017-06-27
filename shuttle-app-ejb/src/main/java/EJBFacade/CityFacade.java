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
import model.City;

/**
 *
 * @author luisnegrete
 */
@Stateless
public class CityFacade extends AbstractFacade<City> implements CityFacadeLocal {

    @PersistenceContext(unitName = "com.mycompany_shuttle-app-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CityFacade() {
        super(City.class);
    }

    @Override
    public List<City> findByCountryState(Integer idCountry, Integer idState) {
    
        try{
        
            javax.persistence.Query query = em.createNamedQuery("City.findByCountryAndState");
            
            query.setParameter("idCountry", idCountry);
            
            query.setParameter("idState", idState);
            
            return query.getResultList();
            
        }
        catch(NullPointerException | javax.persistence.NoResultException ex){
        
            ex.printStackTrace(System.out);
            
            return null;
        
        }
        
    }

    @Override
    public List<City> findByCountry(int idCountry) {
    
        try{
            
            java.util.List<model.City> resultList = new java.util.ArrayList();
            
            for(model.City city: this.findAll()){
            
                if(city.getCityPK().getId() == idCountry){
                
                    resultList.add(city);
                
                }
                
            }
            
            return resultList;
            
        }
        catch(Exception ex){
        
            ex.printStackTrace(System.out);
            
            return null;
            
        }
    
    }
    
}
