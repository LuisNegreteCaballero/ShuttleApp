/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJBFacade;

import java.util.Date;
import java.util.List;
import javax.ejb.Local;
import model.Service;

/**
 *
 * @author luisnegrete
 */
@Local
public interface ServiceFacadeLocal {

    void create(Service service);

    void edit(Service service);

    void remove(Service service);

    Service find(Object id);

    List<Service> findAll();

    List<Service> findRange(int[] range);

    int count();
    
    void createService(String accountEmail, Integer idDriver,boolean round, model.Address startAddressFrom, model.Address startAddressTo, model.Address returnAddressFrom, model.Address returnAddressTo, Date startDate, Date finalDate);
    }
