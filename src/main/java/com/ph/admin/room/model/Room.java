package com.ph.admin.room.model;

import javax.persistence.*;

/**
 * Created by Pradeesh on 12/6/2015.
 */
@Entity
@Table(name = "ph_rooms")
public class Room {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "roomnumber")
    private String roomNumber;

    @Column(name = "building")
    private int building;

    @Column(name = "roomtype")
    private int roomType;

    @Column(name = "description")
    private String description;

    @Column(name = "rate")
    private Float rate;

    @Column(name = "isavailable")
    private boolean available;


    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(final String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getBuilding() {
        return building;
    }

    public void setBuilding(final int building) {
        this.building = building;
    }

    public int getRoomType() {
        return roomType;
    }

    public void setRoomType(final int roomType) {
        this.roomType = roomType;
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

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(final boolean available) {
        this.available = available;
    }
}
