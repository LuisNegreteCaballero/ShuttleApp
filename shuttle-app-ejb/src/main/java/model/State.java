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
@Table(name = "state")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "State.findAll", query = "SELECT s FROM State s")
    , @NamedQuery(name = "State.findByIdState", query = "SELECT s FROM State s WHERE s.statePK.idState = :idState")
    , @NamedQuery(name = "State.findById", query = "SELECT s FROM State s WHERE s.statePK.id = :id")
    , @NamedQuery(name = "State.findByName", query = "SELECT s FROM State s WHERE s.name = :name")})
public class State implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected StatePK statePK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "state")
    private Collection<City> cityCollection;
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Country country;

    public State() {
    }

    public State(StatePK statePK) {
        this.statePK = statePK;
    }

    public State(StatePK statePK, String name) {
        this.statePK = statePK;
        this.name = name;
    }

    public State(int idState, int id) {
        this.statePK = new StatePK(idState, id);
    }

    public StatePK getStatePK() {
        return statePK;
    }

    public void setStatePK(StatePK statePK) {
        this.statePK = statePK;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<City> getCityCollection() {
        return cityCollection;
    }

    public void setCityCollection(Collection<City> cityCollection) {
        this.cityCollection = cityCollection;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (statePK != null ? statePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof State)) {
            return false;
        }
        State other = (State) object;
        if ((this.statePK == null && other.statePK != null) || (this.statePK != null && !this.statePK.equals(other.statePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.State[ statePK=" + statePK + " ]";
    }
    
}
