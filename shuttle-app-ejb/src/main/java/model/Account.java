/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author negre
 */
@Entity
@Table(name = "account")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account a")
    , @NamedQuery(name = "Account.findByEmail", query = "SELECT a FROM Account a WHERE a.email = :email")
    , @NamedQuery(name = "Account.findByPhoneNumber", query = "SELECT a FROM Account a WHERE a.phoneNumber = :phoneNumber")
    , @NamedQuery(name = "Account.findByName", query = "SELECT a FROM Account a WHERE a.name = :name")
    , @NamedQuery(name = "Account.findByBirthdate", query = "SELECT a FROM Account a WHERE a.birthdate = :birthdate")
    , @NamedQuery(name = "Account.findByPassword", query = "SELECT a FROM Account a WHERE a.password = :password")})
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "email")
    private String email;
    @Size(max = 20)
    @Column(name = "phone_number")
    private String phoneNumber;
    @Size(max = 100)
    @Column(name="profile_picture")
    private String profilePicture;
    @Size(max = 100)
    @Column(name = "name")
    private String name;
    @Column(name = "birthdate")
    @Temporal(TemporalType.DATE)
    private Date birthdate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "last_name")
    @Size(max = 100)
    private String lastName;
    
    @Basic(optional = false)
    @Column(name = "discounts")
    private boolean discounts;

    
    
    @Basic(optional = false)
    @Column(name = "push_notifications")
    private boolean pushNotifications;
    
    @Basic(optional = false)
    @Column(name = "trip_notifications")
    private boolean tripNotifications;
   
    @JoinTable(name = "account_has_role", joinColumns = {
        @JoinColumn(name = "email", referencedColumnName = "email")}, inverseJoinColumns = {
        @JoinColumn(name = "id_role", referencedColumnName = "id_role")})
    @ManyToMany
    private Collection<Role> roleCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "account")
    private Collection<Service> serviceCollection;
    @JoinColumn(name = "id_address", referencedColumnName = "id_address")
    @ManyToOne
    private Address idAddress;
    @JoinColumn(name = "phone_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Phonecode phoneCode;
    

    public Account() {
    }

    public Account(String email) {
        this.email = email;
    }

    public Account(String email, String password) {
        this.email = email;
        this.password = password;
    }
    
    public String getProfilePicture(){
    
        return this.profilePicture;
    
    }
    
    public void setProfilePicture(String profilePicture){
    
        this.profilePicture = profilePicture;
    
    }
    
    
    public boolean getDiscounts() {
        return discounts;
    }

    public void setDiscounts(boolean discounts) {
        this.discounts = discounts;
    }

    public boolean getPushNotifications() {
        return pushNotifications;
    }

    public void setPushNotifications(boolean pushNotifications) {
        this.pushNotifications = pushNotifications;
    }

    public boolean getTripNotifications() {
        return tripNotifications;
    }

    public void setTripNotifications(boolean tripNotifications) {
        this.tripNotifications = tripNotifications;
    }
     public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlTransient
    public Collection<Role> getRoleCollection() {
        return roleCollection;
    }

    public void setRoleCollection(Collection<Role> roleCollection) {
        this.roleCollection = roleCollection;
    }

    @XmlTransient
    public Collection<Service> getServiceCollection() {
        return serviceCollection;
    }

    public void setServiceCollection(Collection<Service> serviceCollection) {
        this.serviceCollection = serviceCollection;
    }

    public Address getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(Address idAddress) {
        this.idAddress = idAddress;
    }

    public Phonecode getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneId(Phonecode phoneCode) {
        this.phoneCode = phoneCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (email != null ? email.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Account)) {
            return false;
        }
        Account other = (Account) object;
        if ((this.email == null && other.email != null) || (this.email != null && !this.email.equals(other.email))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Account[ email=" + email + " ]";
    }
    
}
