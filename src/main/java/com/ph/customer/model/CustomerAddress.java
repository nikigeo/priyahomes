package com.ph.customer.model;

/**
 * Created by mozanta on 10/11/15.
 */
public class CustomerAddress implements java.io.Serializable{
    private int addressId;
    private String houseStreetName;
    private String houseLocality;
    private String state;
    private String country;
    private String phoneNumber;

    public int getAddressId() {   return addressId;  }

    public void setAddressId(int addressId) {  this.addressId = addressId; }

    public String getHouseStreetName() {
        return houseStreetName;
    }

    public void setHouseStreetName(String houseStreetName) {
        this.houseStreetName = houseStreetName;
    }

    public String getHouseLocality() {
        return houseLocality;
    }

    public void setHouseLocality(String houseLocality) {
        this.houseLocality = houseLocality;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


}
