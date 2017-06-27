package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Phonecode;
import model.State;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-20T18:36:37")
@StaticMetamodel(Country.class)
public class Country_ { 

    public static volatile SingularAttribute<Country, String> name;
    public static volatile CollectionAttribute<Country, State> stateCollection;
    public static volatile SingularAttribute<Country, Phonecode> phonecode;
    public static volatile SingularAttribute<Country, Integer> id;

}