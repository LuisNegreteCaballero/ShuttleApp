/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author negre
 */
@Entity
@Table(name = "geo_location")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GeoLocation.findAll", query = "SELECT g FROM GeoLocation g")
    , @NamedQuery(name = "GeoLocation.findByIdGeolocation", query = "SELECT g FROM GeoLocation g WHERE g.idGeolocation = :idGeolocation")
    , @NamedQuery(name = "GeoLocation.findByLatitude", query = "SELECT g FROM GeoLocation g WHERE g.latitude = :latitude")
    , @NamedQuery(name = "GeoLocation.findByLongitude", query = "SELECT g FROM GeoLocation g WHERE g.longitude = :longitude")})
public class GeoLocation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_geolocation")
    private Integer idGeolocation;
    @Basic(optional = false)
    @NotNull
    @Column(name = "latitude")
    private double latitude;
    @Basic(optional = false)
    @NotNull
    @Column(name = "longitude")
    private double longitude;

    public GeoLocation() {
    }

    public GeoLocation(Integer idGeolocation) {
        this.idGeolocation = idGeolocation;
    }

    public GeoLocation(Integer idGeolocation, double latitude, double longitude) {
        this.idGeolocation = idGeolocation;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Integer getIdGeolocation() {
        return idGeolocation;
    }

    public void setIdGeolocation(Integer idGeolocation) {
        this.idGeolocation = idGeolocation;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGeolocation != null ? idGeolocation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GeoLocation)) {
            return false;
        }
        GeoLocation other = (GeoLocation) object;
        if ((this.idGeolocation == null && other.idGeolocation != null) || (this.idGeolocation != null && !this.idGeolocation.equals(other.idGeolocation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.GeoLocation[ idGeolocation=" + idGeolocation + " ]";
    }
    
}
