package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Account;
import model.City;
import model.Service;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-20T18:36:38")
@StaticMetamodel(Address.class)
public class Address_ { 

    public static volatile CollectionAttribute<Address, Account> accountCollection;
    public static volatile SingularAttribute<Address, String> address;
    public static volatile SingularAttribute<Address, City> city;
    public static volatile CollectionAttribute<Address, Service> serviceCollection1;
    public static volatile CollectionAttribute<Address, Service> serviceCollection2;
    public static volatile CollectionAttribute<Address, Service> serviceCollection3;
    public static volatile CollectionAttribute<Address, Service> serviceCollection;
    public static volatile SingularAttribute<Address, Integer> idAddress;

}