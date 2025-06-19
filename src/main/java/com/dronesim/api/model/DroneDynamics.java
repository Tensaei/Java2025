package com.dronesim.api.model;

/**
 * Represents the real-time dynamics data of an individual drone in the
 * simulation system. Holds data such as speed, orientation (roll, pitch, yaw),
 * location (latitude, longitude), velocity, battery level, and status.
 */
public class DroneDynamics {

    // Reference to the associated individual drone (as String for now)
    private String drone;

    // Timestamp of the recorded data
    private String timestamp;

    // Current speed of the drone in m/s
    private double speed;

    // Full constructor – used when creating a dynamics record with all data
    public DroneDynamics(String drone, String timestamp, double speed) {
        this.drone = drone;
        this.timestamp = timestamp;
        this.speed = speed;
    }

    // Default constructor – required for JSON libraries
    public DroneDynamics() {
    }

    // Getter and setter methods for each attribute
    public String getDrone() {
        return drone;
    }

    public void setDrone(String drone) {
        this.drone = drone;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    // Overridden toString method to display dynamics data in a readable format
    @Override
    public String toString() {
        return "DroneDynamics{"
                + "drone='" + drone + '\''
                + ", timestamp='" + timestamp + '\''
                + ", speed=" + speed
                + '}';
    }
}
