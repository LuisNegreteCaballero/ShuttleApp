package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Driver;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-20T18:36:38")
@StaticMetamodel(Car.class)
public class Car_ { 

    public static volatile CollectionAttribute<Car, Driver> driverCollection;
    public static volatile SingularAttribute<Car, Integer> year;
    public static volatile SingularAttribute<Car, String> model;
    public static volatile SingularAttribute<Car, String> brand;
    public static volatile SingularAttribute<Car, String> numberPlate;
    public static volatile SingularAttribute<Car, Integer> carId;

}