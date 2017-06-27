/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJBClasses;

import java.util.Date;

/**
 *
 * @author luis
 */
public class Service {
    
    private String serviceId;
    
    private String idUser;
    
    private Integer idStartCountryFrom;
    
    private Integer idStartStateFrom;
    
    private Integer idStartCityFrom;
    
    private String startAddressFrom;
    
    private Integer idStartCountryTo;
    
    private Integer idStartStateTo;
    
    private Integer idStartCityTo;
    
    private String startAddressTo;
    
    private java.util.Date startDate;
    
    private Integer idReturnCountryFrom;
    
    private Integer idReturnStateFrom;
    
    private Integer idReturnCityFrom;
    
    private String  returnAddressFrom;
    
    private Integer idReturnCountryTo;
    
    private Integer idReturnStateTo;
    
    private Integer idReturnCityTo;
    
    private String returnAddressTo;
    
    private java.util.Date returnDate;
    
    private boolean round;
    
    public boolean isRound(){
    
        return this.round;
    
    }
    
    public void setIsRound(boolean round){
    
        this.round = round;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public Integer getIdStartCountryFrom() {
        return idStartCountryFrom;
    }

    public void setIdStartCountryFrom(Integer idStartCountryFrom) {
        this.idStartCountryFrom = idStartCountryFrom;
    }

    public Integer getIdStartStateFrom() {
        return idStartStateFrom;
    }

    public void setIdStartStateFrom(Integer idStartStateFrom) {
        this.idStartStateFrom = idStartStateFrom;
    }

    public Integer getIdStartCityFrom() {
        return idStartCityFrom;
    }

    public void setIdStartCityFrom(Integer idStartCityFrom) {
        this.idStartCityFrom = idStartCityFrom;
    }

    public String getStartAddressFrom() {
        return startAddressFrom;
    }

    public void setStartAddressFrom(String startAddressFrom) {
        this.startAddressFrom = startAddressFrom;
    }

    public Integer getIdStartCountryTo() {
        return idStartCountryTo;
    }

    public void setIdStartCountryTo(Integer idStartCountryTo) {
        this.idStartCountryTo = idStartCountryTo;
    }

    public Integer getIdStartStateTo() {
        return idStartStateTo;
    }

    public void setIdStartStateTo(Integer idStartStateTo) {
        this.idStartStateTo = idStartStateTo;
    }

    public Integer getIdStartCityTo() {
        return idStartCityTo;
    }

    public void setIdStartCityTo(Integer idStartCityTo) {
        this.idStartCityTo = idStartCityTo;
    }

    public String getStartAddressTo() {
        return startAddressTo;
    }

    public void setStartAddressTo(String startAddressTo) {
        this.startAddressTo = startAddressTo;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Integer getIdReturnCountryFrom() {
        return idReturnCountryFrom;
    }

    public void setIdReturnCountryFrom(Integer idReturnCountryFrom) {
        this.idReturnCountryFrom = idReturnCountryFrom;
    }

    public Integer getIdReturnStateFrom() {
        return idReturnStateFrom;
    }

    public void setIdReturnStateFrom(Integer idReturnStateFrom) {
        this.idReturnStateFrom = idReturnStateFrom;
    }

    public Integer getIdReturnCityFrom() {
        return idReturnCityFrom;
    }

    public void setIdReturnCityFrom(Integer idReturnCityFrom) {
        this.idReturnCityFrom = idReturnCityFrom;
    }

    public String getReturnAddressFrom() {
        return returnAddressFrom;
    }

    public void setReturnAddressFrom(String returnAddressFrom) {
        this.returnAddressFrom = returnAddressFrom;
    }

    public Integer getIdReturnCountryTo() {
        return idReturnCountryTo;
    }

    public void setIdReturnCountryTo(Integer idReturnCountryTo) {
        this.idReturnCountryTo = idReturnCountryTo;
    }

    public Integer getIdReturnStateTo() {
        return idReturnStateTo;
    }

    public void setIdReturnStateTo(Integer idReturnStateTo) {
        this.idReturnStateTo = idReturnStateTo;
    }

    public Integer getIdReturnCityTo() {
        return idReturnCityTo;
    }

    public void setIdReturnCityTo(Integer idReturnCityTo) {
        this.idReturnCityTo = idReturnCityTo;
    }

    public String getReturnAddressTo() {
        return returnAddressTo;
    }

    public void setReturnAddressTo(String returnAddressTo) {
        this.returnAddressTo = returnAddressTo;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
    
}
