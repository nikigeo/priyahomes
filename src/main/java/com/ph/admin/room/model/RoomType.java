package com.ph.admin.room.model;

import org.postgresql.core.types.PGNumber;
import org.postgresql.util.PGmoney;

import javax.persistence.*;

/**
 * Created by pradeesh on 12/5/2015.
 */

@Entity
@Table(name = "ph_room_types")
public class RoomType {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "type")
    private String type;

    @Column(name = "description")
    private String description;

    @Column(name = "rate")
    private Float rate;

    @Column(name = "numberofbedrooms")
    private int numberOfBedrooms;

    @Column(name = "numberoftoilets")
    private int numberOfToilets;

    @Column(name = "numberoftenants")
    private int numberOfTenants;

    @Column(name = "kitchen")
    private boolean kitchenAvailable;

    @Column(name = "ac")
    private boolean acAvailable;

    @Column(name = "tv")
    private boolean tvAvailable;

    @Column(name = "wifi")
    private boolean wifiAvailable;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public Float getRate() {
        return rate;
    }

    public void setRate(final Float rate) {
        this.rate = rate;
    }

    public int getNumberOfBedrooms() {
        return numberOfBedrooms;
    }

    public void setNumberOfBedrooms(final int numberOfBedrooms) {
        this.numberOfBedrooms = numberOfBedrooms;
    }

    public int getNumberOfToilets() {
        return numberOfToilets;
    }

    public void setNumberOfToilets(final int numberOfToilets) {
        this.numberOfToilets = numberOfToilets;
    }

    public int getNumberOfTenants() {
        return numberOfTenants;
    }

    public void setNumberOfTenants(final int numberOfTenants) {
        this.numberOfTenants = numberOfTenants;
    }

    public boolean isKitchenAvailable() {
        return kitchenAvailable;
    }

    public void setKitchenAvailable(final boolean kitchenAvailable) {
        this.kitchenAvailable = kitchenAvailable;
    }

    public boolean isAcAvailable() {
        return acAvailable;
    }

    public void setAcAvailable(final boolean acAvailable) {
        this.acAvailable = acAvailable;
    }

    public boolean isTvAvailable() {
        return tvAvailable;
    }

    public void setTvAvailable(final boolean tvAvailable) {
        this.tvAvailable = tvAvailable;
    }

    public boolean isWifiAvailable() {
        return wifiAvailable;
    }

    public void setWifiAvailable(final boolean wifiAvailable) {
        this.wifiAvailable = wifiAvailable;
    }
}
