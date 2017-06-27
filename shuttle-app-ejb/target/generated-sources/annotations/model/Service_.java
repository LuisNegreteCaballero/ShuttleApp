package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Account;
import model.Address;
import model.Driver;
import model.ServicePK;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-20T18:36:38")
@StaticMetamodel(Service.class)
public class Service_ { 

    public static volatile SingularAttribute<Service, Date> finalDate;
    public static volatile SingularAttribute<Service, Address> startAddress;
    public static volatile SingularAttribute<Service, Address> returnStartAddress;
    public static volatile SingularAttribute<Service, Address> returnEndAddress;
    public static volatile SingularAttribute<Service, ServicePK> servicePK;
    public static volatile SingularAttribute<Service, Date> startDate;
    public static volatile SingularAttribute<Service, Account> account;
    public static volatile SingularAttribute<Service, Address> finalAddress;
    public static volatile SingularAttribute<Service, Driver> idDriver;

}