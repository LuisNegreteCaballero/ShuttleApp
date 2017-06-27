/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJBFacade;

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
import model.Account;

/**
 *
 * @author luisnegrete
 */
@Stateless
@javax.ejb.TransactionManagement(javax.ejb.TransactionManagementType.BEAN)
public class AccountFacade extends AbstractFacade<Account> implements AccountFacadeLocal {

    @javax.annotation.Resource
    private javax.ejb.EJBContext context;
    
    @javax.ejb.EJB
    private EJBFacade.RoleFacadeLocal roleFacade;
    
    @PersistenceContext(unitName = "com.mycompany_shuttle-app-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public model.Account find(Object id){
    
        try{
        
          return super.find(id);
            
        }
        catch(Exception ex){
        
            return null;
        
        }
    
    }
    
    
    @Override
    public enumeration.TransactionResult Registration(model.Account account){
    
    try{
        
        this.context.getUserTransaction().begin();
        
        model.Role role = this.roleFacade.find(1);
        
        this.context.getUserTransaction().commit();
        
        if(account.getRoleCollection() == null){
        
            java.util.List<model.Role>roles = new java.util.ArrayList<>();
            
            roles.add(role);
            
            account.setRoleCollection(roles);
            
        }else{
        
        account.getRoleCollection().add(role);
        
        }
        
        //account.getRoleCollection().add(role);
        
        context.getUserTransaction().begin();
        
        super.create(account);
        
        context.getUserTransaction().commit();
    
        return enumeration.TransactionResult.SUCCESS;
    }
    catch(IllegalStateException | SecurityException | HeuristicMixedException | HeuristicRollbackException | NotSupportedException | RollbackException | SystemException ex){
    
        try {
            context.getUserTransaction().rollback();
            
            return enumeration.TransactionResult.TRANSACTIONERROR;
        } catch (IllegalStateException ex1) {
            Logger.getLogger(AccountFacade.class.getName()).log(Level.SEVERE, null, ex1);
        return enumeration.TransactionResult.TRANSACTIONERROR;
        
        } catch (SecurityException ex1) {
            Logger.getLogger(AccountFacade.class.getName()).log(Level.SEVERE, null, ex1);
        return enumeration.TransactionResult.TRANSACTIONERROR;
        
        } catch (SystemException ex1) {
            Logger.getLogger(AccountFacade.class.getName()).log(Level.SEVERE, null, ex1);
        
        return enumeration.TransactionResult.TRANSACTIONERROR;
        }
    
    }
    
    }
    
    public AccountFacade() {
        super(Account.class);
    }
    
}
