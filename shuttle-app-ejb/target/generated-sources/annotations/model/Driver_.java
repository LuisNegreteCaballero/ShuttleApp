package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Car;
import model.Service;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-20T18:36:38")
@StaticMetamodel(Driver.class)
public class Driver_ { 

    public static volatile SingularAttribute<Driver, String> profilePicture;
    public static volatile SingularAttribute<Driver, String> password;
    public static volatile SingularAttribute<Driver, Boolean> taken;
    public static volatile SingularAttribute<Driver, String> name;
    public static volatile SingularAttribute<Driver, Boolean> active;
    public static volatile SingularAttribute<Driver, Integer> id;
    public static volatile CollectionAttribute<Driver, Service> serviceCollection;
    public static volatile SingularAttribute<Driver, String> email;
    public static volatile SingularAttribute<Driver, Car> carId;

}