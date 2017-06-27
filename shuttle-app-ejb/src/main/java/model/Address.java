/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
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
@Table(name = "address")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Address.findAll", query = "SELECT a FROM Address a")
    , @NamedQuery(name = "Address.findByIdAddress", query = "SELECT a FROM Address a WHERE a.idAddress = :idAddress")
    , @NamedQuery(name = "Address.findByAddress", query = "SELECT a FROM Address a WHERE a.address = :address")})
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_address")
    @SequenceGenerator(schema = "public", name = "seqGenerator", sequenceName  = "address_id_address_seq", allocationSize = 1)
   @GeneratedValue(generator = "seqGenerator", strategy = GenerationType.SEQUENCE)
    private Integer idAddress;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "address")
    private String address;
    @JoinColumns({
        @JoinColumn(name = "id_city", referencedColumnName = "id_city")
        , @JoinColumn(name = "id_state", referencedColumnName = "id_state")
        , @JoinColumn(name = "id_country", referencedColumnName = "id")})
    @ManyToOne(optional = false)
    private City city;
    @OneToMany(mappedBy = "startAddress")
    private Collection<Service> serviceCollection;
    @OneToMany(mappedBy = "finalAddress")
    private Collection<Service> serviceCollection1;
    @OneToMany(mappedBy = "returnStartAddress")
    private Collection<Service> serviceCollection2;
    @OneToMany(mappedBy = "returnEndAddress")
    private Collection<Service> serviceCollection3;
    @OneToMany(mappedBy = "idAddress")
    private Collection<Account> accountCollection;

    public Address() {
    }

    public Address(Integer idAddress) {
        this.idAddress = idAddress;
    }

    public Address(Integer idAddress, String address) {
        this.idAddress = idAddress;
        this.address = address;
    }

    public Integer getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(Integer idAddress) {
        this.idAddress = idAddress;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @XmlTransient
    public Collection<Service> getServiceCollection() {
        return serviceCollection;
    }

    public void setServiceCollection(Collection<Service> serviceCollection) {
        this.serviceCollection = serviceCollection;
    }

    @XmlTransient
    public Collection<Service> getServiceCollection1() {
        return serviceCollection1;
    }

    public void setServiceCollection1(Collection<Service> serviceCollection1) {
        this.serviceCollection1 = serviceCollection1;
    }

    @XmlTransient
    public Collection<Service> getServiceCollection2() {
        return serviceCollection2;
    }

    public void setServiceCollection2(Collection<Service> serviceCollection2) {
        this.serviceCollection2 = serviceCollection2;
    }

    @XmlTransient
    public Collection<Service> getServiceCollection3() {
        return serviceCollection3;
    }

    public void setServiceCollection3(Collection<Service> serviceCollection3) {
        this.serviceCollection3 = serviceCollection3;
    }

    @XmlTransient
    public Collection<Account> getAccountCollection() {
        return accountCollection;
    }

    public void setAccountCollection(Collection<Account> accountCollection) {
        this.accountCollection = accountCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAddress != null ? idAddress.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Address)) {
            return false;
        }
        Address other = (Address) object;
        if ((this.idAddress == null && other.idAddress != null) || (this.idAddress != null && !this.idAddress.equals(other.idAddress))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Address[ idAddress=" + idAddress + " ]";
    }
    
}
