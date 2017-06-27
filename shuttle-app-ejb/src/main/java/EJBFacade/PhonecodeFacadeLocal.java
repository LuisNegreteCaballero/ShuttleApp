/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJBFacade;

import javax.ejb.Local;

/**
 *
 * @author luis
 */
@Local
public interface PhonecodeFacadeLocal {
    public model.Phonecode find(Object id);
}
