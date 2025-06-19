package com.dronesim.api.model;

/**
 * Represents a drone model definition used by individual drones.
 * Holds data such as ID, manufacturer, model name, and maximum speed.
 */
public class DroneModel {

    // Unique ID for the drone model
    private int id;

    // Name of the drone manufacturer
    private String manufacturer;

    // Name or identifier of the drone model
    private String model;

    // Maximum speed of the drone in km/h
    private double maxSpeed;

    // Full constructor – used when creating a drone model with all data
    public DroneModel(int id, String manufacturer, String model, double maxSpeed) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    // Default constructor – required for JSON libraries
    public DroneModel() {
    }

    // Getter and setter methods for each attribute

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "DroneModel{"
                + "id=" + id
                + ", manufacturer='" + manufacturer + '\''
                + ", model='" + model + '\''
                + ", maxSpeed=" + maxSpeed
                + '}';
    }

}
