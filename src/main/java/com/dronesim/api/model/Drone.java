package com.dronesim.api.model;

import java.sql.Date;

/**
 * Represents an individual drone instance in the drone simulation system. Holds
 * data such as ID, serial number, model, cargo weight, status, and last seen
 * time.
 */
public class Drone {

    // Unique id for the drone
    private int id;

    // The type of drone
    private DroneType dronetype;

    private DroneDynamics droneDynamics;

    // Creation date of the drone
    private Date created;

    // Manufacturer-assigned serial number
    private String serialNumber;

    // Weight of the cargo being carried, in kg
    private int carriage_weight;

    // Type of the carriage
    private String carriage_type;

    // Full constructor – used when creating a drone object with all data
    public Drone(int id, String dronetype, Date created, String serialNumber, int carriage_weight, String carriage_type) {
        this.id = id;
        this.created = created;
        this.serialNumber = serialNumber;
        this.carriage_weight = carriage_weight;
        this.carriage_type = carriage_type;

    }

    // Default constructor – required for JSON libraries
    public Drone() {

    }

    //Fetch DroneType

    //Fetch DroneDynamics

    // Getter and setter methods for each attribute
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DroneType getDronetype() {
        return dronetype;
    }

    public void setDronetype(DroneType dronetype) {
        this.dronetype = dronetype;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public double getCarriage_weight() {
        return carriage_weight;
    }

    public void setCarriage_weight(int carriage_weight) {
        this.carriage_weight = carriage_weight;
    }

    public String getCarriage_type() {
        return carriage_type;
    }

    public void setCarriage_type(String carriage_type) {
        this.carriage_type = carriage_type;
    }

    @Override
    public String toString() {
        return "Drone{"
                + "id=" + id
                + ", dronetype='" + dronetype + '\''
                + ", created='" + created.toString() + '\''
                + ", serialNumber='" + serialNumber + '\''
                + ", carriage_weight=" + carriage_weight
                + ", carriage_type='" + carriage_type + '\''
                + '}';

    }

}