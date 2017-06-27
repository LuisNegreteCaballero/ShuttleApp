package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Address;
import model.CityPK;
import model.State;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-20T18:36:38")
@StaticMetamodel(City.class)
public class City_ { 

    public static volatile CollectionAttribute<City, Address> addressCollection;
    public static volatile SingularAttribute<City, String> name;
    public static volatile SingularAttribute<City, CityPK> cityPK;
    public static volatile SingularAttribute<City, State> state;

}