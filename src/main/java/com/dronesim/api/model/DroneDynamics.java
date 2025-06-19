package com.dronesim.api.model;

public class DroneDynamics {
    private String drone;
    private String timestamp;
    private double speed;

    public DroneDynamics() {}

    public String getDrone() { return drone; }
    public void setDrone(String d) { this.drone = d; }

    public String getTimestamp() { return timestamp; }
    public void setTimestamp(String t) { this.timestamp = t; }

    public double getSpeed() { return speed; }
    public void setSpeed(double s) { this.speed = s; }
}
