/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author negre
 */
@Entity
@Table(name = "city")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "City.findAll", query = "SELECT c FROM City c")
    , @NamedQuery(name = "City.findByIdCity", query = "SELECT c FROM City c WHERE c.cityPK.idCity = :idCity")
    , @NamedQuery(name = "City.findByIdState", query = "SELECT c FROM City c WHERE c.cityPK.idState = :idState")
    , @NamedQuery(name = "City.findById", query = "SELECT c FROM City c WHERE c.cityPK.id = :id")
    , @NamedQuery(name = "City.findByCountry", query = "SELECT c FROM City c WHERE c.state.country.id = :idCountry")
    , @NamedQuery(name = "City.findByName", query = "SELECT c FROM City c WHERE c.name = :name")})
public class City implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CityPK cityPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "city")
    private Collection<Address> addressCollection;
    @JoinColumns({
        @JoinColumn(name = "id_state", referencedColumnName = "id_state", insertable = false, updatable = false)
        , @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private State state;

    public City() {
    }

    public City(CityPK cityPK) {
        this.cityPK = cityPK;
    }

    public City(CityPK cityPK, String name) {
        this.cityPK = cityPK;
        this.name = name;
    }

    public City(int idCity, int idState, int id) {
        this.cityPK = new CityPK(idCity, idState, id);
    }

    public CityPK getCityPK() {
        return cityPK;
    }

    public void setCityPK(CityPK cityPK) {
        this.cityPK = cityPK;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<Address> getAddressCollection() {
        return addressCollection;
    }

    public void setAddressCollection(Collection<Address> addressCollection) {
        this.addressCollection = addressCollection;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cityPK != null ? cityPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof City)) {
            return false;
        }
        City other = (City) object;
        if ((this.cityPK == null && other.cityPK != null) || (this.cityPK != null && !this.cityPK.equals(other.cityPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.City[ cityPK=" + cityPK + " ]";
    }
    
}
