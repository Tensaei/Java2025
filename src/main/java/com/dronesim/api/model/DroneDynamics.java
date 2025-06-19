package com.dronesim.api.model;

/**
 * Represents the real-time dynamics data of an individual drone in the simulation system.
 * Holds data such as speed, orientation (roll, pitch, yaw), location (latitude, longitude),
 * velocity, battery level, and status.
 */
public class DroneDynamics {

    // Unique ID for this dynamics record
    private int id;

    // Reference to the associated individual drone
    private IndividualDrone droneId;

    // Timestamp of the recorded data
    private String timestamp;

    // Current speed of the drone in m/s
    private double speed;

    // Roll alignment angle in degrees
    private double alignRoll;

    // Pitch alignment angle in degrees
    private double alignPitch;

    // Yaw alignment angle in degrees
    private double alignYaw;

    // Current longitude of the drone
    private double longitude;

    // Current latitude of the drone
    private double latitude;

    // Velocity vector magnitude in m/s
    private double velocity;

    // Battery level in percentage (0–100)
    private double battery;

    // Status
    private String status;

    // Full constructor – used when creating a dynamics record with all data
    public DroneDynamics(int id, IndividualDrone droneId, String timestamp, double speed, double alignRoll,
                         double alignPitch, double alignYaw, double longitude, double latitude,
                         double velocity, double battery, String status) {
        this.id = id;
        this.droneId = droneId;
        this.timestamp = timestamp;
        this.speed = speed;
        this.alignRoll = alignRoll;
        this.alignPitch = alignPitch;
        this.alignYaw = alignYaw;
        this.longitude = longitude;
        this.latitude = latitude;
        this.velocity = velocity;
        this.battery = battery;
        this.status = status;
    }

    // Default constructor – required for JSON libraries
    public DroneDynamics() {
    }

    // Getter and setter methods for each attribute

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public IndividualDrone getDroneId() {
        return droneId;
    }

    public void setDroneId(IndividualDrone droneId) {
        this.droneId = droneId;
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

    public double getAlignRoll() {
        return alignRoll;
    }

    public void setAlignRoll(double alignRoll) {
        this.alignRoll = alignRoll;
    }

    public double getAlignPitch() {
        return alignPitch;
    }

    public void setAlignPitch(double alignPitch) {
        this.alignPitch = alignPitch;
    }

    public double getAlignYaw() {
        return alignYaw;
    }

    public void setAlignYaw(double alignYaw) {
        this.alignYaw = alignYaw;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getVelocity() {
        return velocity;
    }

    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    public double getBattery() {
        return battery;
    }

    public void setBattery(double battery) {
        this.battery = battery;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Overridden toString method to display dynamics data in a readable format
    @Override
    public String toString() {
        return "DroneDynamics{"
                + "id=" + id
                + ", droneId=" + (droneId != null ? droneId.getSerialNumber() : "null")
                + ", timestamp='" + timestamp + '\''
                + ", speed=" + speed
                + ", alignRoll=" + alignRoll
                + ", alignPitch=" + alignPitch
                + ", alignYaw=" + alignYaw
                + ", longitude=" + longitude
                + ", latitude=" + latitude
                + ", velocity=" + velocity
                + ", battery=" + battery
                + ", status='" + status + '\''
                + '}';
    }
}
