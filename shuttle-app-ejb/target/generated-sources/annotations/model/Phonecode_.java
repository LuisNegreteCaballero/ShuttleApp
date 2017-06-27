package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Account;
import model.Country;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-20T18:36:38")
@StaticMetamodel(Phonecode.class)
public class Phonecode_ { 

    public static volatile SingularAttribute<Phonecode, Country> country;
    public static volatile CollectionAttribute<Phonecode, Account> accountCollection;
    public static volatile SingularAttribute<Phonecode, Integer> code;
    public static volatile SingularAttribute<Phonecode, Integer> id;

}