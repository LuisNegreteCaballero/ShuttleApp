package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.City;
import model.Country;
import model.StatePK;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-20T18:36:38")
@StaticMetamodel(State.class)
public class State_ { 

    public static volatile SingularAttribute<State, Country> country;
    public static volatile SingularAttribute<State, StatePK> statePK;
    public static volatile SingularAttribute<State, String> name;
    public static volatile CollectionAttribute<State, City> cityCollection;

}