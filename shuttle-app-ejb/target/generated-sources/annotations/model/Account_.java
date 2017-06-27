package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Address;
import model.Phonecode;
import model.Role;
import model.Service;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-20T18:36:38")
@StaticMetamodel(Account.class)
public class Account_ { 

    public static volatile SingularAttribute<Account, String> lastName;
    public static volatile SingularAttribute<Account, Date> birthdate;
    public static volatile SingularAttribute<Account, Boolean> tripNotifications;
    public static volatile CollectionAttribute<Account, Service> serviceCollection;
    public static volatile SingularAttribute<Account, Address> idAddress;
    public static volatile SingularAttribute<Account, String> profilePicture;
    public static volatile SingularAttribute<Account, String> password;
    public static volatile SingularAttribute<Account, String> phoneNumber;
    public static volatile CollectionAttribute<Account, Role> roleCollection;
    public static volatile SingularAttribute<Account, Boolean> discounts;
    public static volatile SingularAttribute<Account, Boolean> pushNotifications;
    public static volatile SingularAttribute<Account, String> name;
    public static volatile SingularAttribute<Account, Phonecode> phoneCode;
    public static volatile SingularAttribute<Account, String> email;

}