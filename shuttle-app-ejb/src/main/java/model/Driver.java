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
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "driver")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Driver.findAll", query = "SELECT d FROM Driver d")
    , @NamedQuery(name = "Driver.findById", query = "SELECT d FROM Driver d WHERE d.id = :id")
    , @NamedQuery(name = "Driver.findByName", query = "SELECT d FROM Driver d WHERE d.name = :name")
    , @NamedQuery(name = "Driver.findByActive", query = "SELECT d FROM Driver d WHERE d.active = :active")
    , @NamedQuery(name = "Driver.Login", query = "SELECT d FROM Driver d WHERE d.email = :email AND d.password = :password")
    , @NamedQuery(name = "Driver.FindByEmail", query = "SELECT d from Driver d WHERE d.email = :email")
    , @NamedQuery(name = "Driver.findByTaken", query = "SELECT d FROM Driver d WHERE d.taken = :taken")})
public class Driver implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "active")
    private boolean active;
    
    @Basic(optional = false)
    @Size(max = 100)
    @Column(name="profile_picture")
    private String profilePicture;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "taken")
    private boolean taken;
    @Basic(optional = false)
    @NotNull
    @Column(name="email", unique=true)
    @Size(min=1, max=200)
    private String email;
    
    @Basic(optional = false)
    @NotNull
    @Column(name="password", unique=true)
    @Size(min=1, max=200)
    private String password;
    
    @JoinColumn(name = "car_id", referencedColumnName = "car_id")
    @ManyToOne(optional = false)
    private Car carId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDriver")
    private Collection<Service> serviceCollection;

    public Driver() {
    }

    public Driver(Integer id) {
        this.id = id;
    }

    public Driver(Integer id, String name, boolean active, boolean taken) {
        this.id = id;
        this.name = name;
        this.active = active;
        this.taken = taken;
    }
    
    public String getProfilePicture(){
    
        return this.profilePicture;
    
    }
    
    public void setProfilePicture(String profilePicture){
    
        this.profilePicture = profilePicture;
    
    }
    
    public Integer getId() {
        return id;
    }

    public String getEmail(){
    return this.email;
    }
    
    public void setEmail(String email){
    
        this.email = email;
    
    }
    
    public String getPassword(){
    return this.password;
    }
    
    public void setPassword(String password){
    this.password = password;
    }
    
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean getTaken() {
        return taken;
    }

    public void setTaken(boolean taken) {
        this.taken = taken;
    }

    public Car getCarId() {
        return carId;
    }

    public void setCarId(Car carId) {
        this.carId = carId;
    }

    @XmlTransient
    public Collection<Service> getServiceCollection() {
        return serviceCollection;
    }

    public void setServiceCollection(Collection<Service> serviceCollection) {
        this.serviceCollection = serviceCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Driver)) {
            return false;
        }
        Driver other = (Driver) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Driver[ id=" + id + " ]";
    }
    
}
