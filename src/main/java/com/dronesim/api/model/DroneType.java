package com.dronesim.api.model;

public class DroneType {
    private int id;
    private String manufacturer;
    private String typename;
    private int weight;
    private int max_speed;
    private int battery_capacity;
    private int control_range;
    private int max_carriage;

    public DroneType() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getManufacturer() { return manufacturer; }
    public void setManufacturer(String m) { this.manufacturer = m; }

    public String getTypename() { return typename; }
    public void setTypename(String t) { this.typename = t; }

    public int getWeight() { return weight; }
    public void setWeight(int w) { this.weight = w; }

    public int getMax_speed() { return max_speed; }
    public void setMax_speed(int s) { this.max_speed = s; }

    public int getBattery_capacity() { return battery_capacity; }
    public void setBattery_capacity(int b) { this.battery_capacity = b; }

    public int getControl_range() { return control_range; }
    public void setControl_range(int r) { this.control_range = r; }

    public int getMax_carriage() { return max_carriage; }
    public void setMax_carriage(int c) { this.max_carriage = c; }
}
