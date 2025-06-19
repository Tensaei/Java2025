package com.dronesim.api.model;

/** Represents an individual drone instance in the drone simulation system.
    Holds data such as ID, serial number, model, cargo weight, status, and last seen time.
  */

public class IndividualDrone {

    // Unique id for the drone
    private int id;
    
    // Manufacturer-assigned serial number
    private String serialNumber;
    
    // The model of the drone
    private DroneModel model;
    
    // Weight of the cargo being carried, in kg
    private double cargoWeight;
    
    // Current status of the drone
    private String status;
    
    // Last known location and or timestamp
    private String lastSeen;
    
    // Full constructor – used when creating a drone object with all data
    public IndividualDrone(int id, String serialNumber, DroneModel model, double cargoWeight, String status, String lastSeen) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.model = model;
        this.cargoWeight = cargoWeight;
        this.status = status;
        this.lastSeen = lastSeen;
    }
    
    // Default constructor – required for JSON libraries
    public IndividualDrone() {
        
    }
    
    // Getter and setter methods for each attribute
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public DroneModel getModel() {
        return model;
    }

    public void setModel(DroneModel model) {
        this.model = model;
    }

    public double getCargoWeight() {
        return cargoWeight;
    }

    public void setCargoWeight(double cargoWeight) {
        this.cargoWeight = cargoWeight;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(String lastSeen) {
        this.lastSeen = lastSeen;
    }

    @Override
    public String toString() {
        return "IndividualDrone{"
                + "id=" + id
                + ", serialNumber='" + serialNumber + '\''
                + ", model=" + (model != null ? model.getModel() : "null")
                + ", cargoWeight=" + cargoWeight
                + ", status='" + status + '\''
                + ", lastSeen='" + lastSeen + '\''
                + '}';
    }

}

