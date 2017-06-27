/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author negre
 */
@Embeddable
public class StatePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_state")
    private int idState;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private int id;

    public StatePK() {
    }

    public StatePK(int idState, int id) {
        this.idState = idState;
        this.id = id;
    }

    public int getIdState() {
        return idState;
    }

    public void setIdState(int idState) {
        this.idState = idState;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idState;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StatePK)) {
            return false;
        }
        StatePK other = (StatePK) object;
        if (this.idState != other.idState) {
            return false;
        }
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.StatePK[ idState=" + idState + ", id=" + id + " ]";
    }
    
}
