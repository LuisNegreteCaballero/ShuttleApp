/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author negre
 */
@Entity
@Table(name = "service")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Service.findAll", query = "SELECT s FROM Service s")
    , @NamedQuery(name = "Service.findByEmail", query = "SELECT s FROM Service s WHERE s.servicePK.email = :email")
    , @NamedQuery(name = "Service.findByIdService", query = "SELECT s FROM Service s WHERE s.servicePK.idService = :idService")
    , @NamedQuery(name = "Service.findByStartDate", query = "SELECT s FROM Service s WHERE s.startDate = :startDate")
    , @NamedQuery(name = "Service.findByFinalDate", query = "SELECT s FROM Service s WHERE s.finalDate = :finalDate")})
public class Service implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ServicePK servicePK;
    @Column(name = "start_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Column(name = "final_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date finalDate;
    @JoinColumn(name = "email", referencedColumnName = "email", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Account account;
    @JoinColumn(name = "start_address", referencedColumnName = "id_address")
    @ManyToOne( cascade = CascadeType.ALL)
    private Address startAddress;
    @JoinColumn(name = "final_address", referencedColumnName = "id_address")
    @ManyToOne( cascade = CascadeType.ALL)
    private Address finalAddress;
    @JoinColumn(name = "return_start_address", referencedColumnName = "id_address")
    @ManyToOne( cascade = CascadeType.ALL)
    private Address returnStartAddress;
    @JoinColumn(name = "return_end_address", referencedColumnName = "id_address")
    @ManyToOne( cascade = CascadeType.ALL)
    private Address returnEndAddress;
    @JoinColumn(name = "id_driver", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Driver idDriver;

    public Service() {
    }

    public Service(ServicePK servicePK) {
        this.servicePK = servicePK;
    }

    public Service(String email, int idService) {
        this.servicePK = new ServicePK(email, idService);
    }

    public ServicePK getServicePK() {
        return servicePK;
    }

    public void setServicePK(ServicePK servicePK) {
        this.servicePK = servicePK;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(Date finalDate) {
        this.finalDate = finalDate;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Address getStartAddress() {
        return startAddress;
    }

    public void setStartAddress(Address startAddress) {
        this.startAddress = startAddress;
    }

    public Address getFinalAddress() {
        return finalAddress;
    }

    public void setFinalAddress(Address finalAddress) {
        this.finalAddress = finalAddress;
    }

    public Address getReturnStartAddress() {
        return returnStartAddress;
    }

    public void setReturnStartAddress(Address returnStartAddress) {
        this.returnStartAddress = returnStartAddress;
    }

    public Address getReturnEndAddress() {
        return returnEndAddress;
    }

    public void setReturnEndAddress(Address returnEndAddress) {
        this.returnEndAddress = returnEndAddress;
    }

    public Driver getIdDriver() {
        return idDriver;
    }

    public void setIdDriver(Driver idDriver) {
        this.idDriver = idDriver;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (servicePK != null ? servicePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Service)) {
            return false;
        }
        Service other = (Service) object;
        if ((this.servicePK == null && other.servicePK != null) || (this.servicePK != null && !this.servicePK.equals(other.servicePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Service[ servicePK=" + servicePK + " ]";
    }
    
}
