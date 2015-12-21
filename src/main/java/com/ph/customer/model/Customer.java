/*
 * Copyright (c) Priya homes.
 */

package com.ph.customer.model;

import org.hibernate.FetchMode;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="ph_customers")
public class Customer implements java.io.Serializable{


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "midname")
    private String midName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "dob")
    private Date dateOfBirth ;

    @Column(name = "gender")
    private char gender;

    @Column(name = "contactnumber")
    private String contactNumber;

    @Column(name = "emergencycontact")
    private String emergencyContact;

    @Column(name = "indian")
    private boolean indian;

    @Column(name = "verificationidtype")
    private Integer verificationType;

    @Column(name = "verificationrefnumber")
    private String verificationNumber;

    @OneToMany(mappedBy = "customer",fetch = FetchType.LAZY)
    private Set<CustomerAddress> customerAddresses = new HashSet<CustomerAddress>();



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMidName() {
        return midName;
    }

    public void setMidName(String midName) {
        this.midName = midName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public boolean isIndian() {
        return indian;
    }

    public void setIndian(boolean indian) {
        this.indian = indian;
    }

    public int getVerificationType() {
        return verificationType;
    }

    public void setVerificationType(int verificationType) {
        this.verificationType = verificationType;
    }

    public String getVerificationNumber() {
        return verificationNumber;
    }

    public void setVerificationNumber(String verificationNumber) {
        this.verificationNumber = verificationNumber;
    }

    public Set<CustomerAddress> getCustomerAddresses() {
        return customerAddresses;
    }

    public void setCustomerAddresses(Set<CustomerAddress> customerAddresses) {
        this.customerAddresses = customerAddresses;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
