/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJBFacade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.GeoLocation;

/**
 *
 * @author luisnegrete
 */
@Stateless
public class GeoLocationFacade extends AbstractFacade<GeoLocation> implements GeoLocationFacadeLocal {

    @PersistenceContext(unitName = "com.mycompany_shuttle-app-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GeoLocationFacade() {
        super(GeoLocation.class);
    }
    
}
