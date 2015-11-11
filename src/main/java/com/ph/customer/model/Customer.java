/*
 * Copyright (c) Priya homes.
 */

package com.ph.customer.model;

import java.util.HashSet;
import java.util.Set;

public class Customer implements java.io.Serializable{

    private int customerId;
    private String firstName;
    private String lastName;
    private String midName;
    private String contactNumber;
    private int age;
    private boolean nonIndian;
    private Set<CustomerAddress> customerAddresses = new HashSet<CustomerAddress>(0);

    public int getCustomerId() { return customerId;  }

    public void setCustomerId(int customerId) { this.customerId = customerId; }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMidName() {
        return midName;
    }

    public void setMidName(String midName) {
        this.midName = midName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isNonIndian() {
        return nonIndian;
    }

    public void setNonIndian(boolean nonIndian) {
        this.nonIndian = nonIndian;
    }

    public Set<CustomerAddress> getCustomerAddresses() {  return customerAddresses;  }

    public void setCustomerAddresses(Set<CustomerAddress> customerAddresses) {  this.customerAddresses = customerAddresses;   }


}
