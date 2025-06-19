package com.dronesim.api.model;

public class Drone {
    private int id;
    private String dronetype;
    private String created;
    private String serialnumber;
    private int carriage_weight;
    private String carriage_type;

    public Drone() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getDronetype() { return dronetype; }
    public void setDronetype(String dt) { this.dronetype = dt; }

    public String getCreated() { return created; }
    public void setCreated(String c) { this.created = c; }

    public String getSerialnumber() { return serialnumber; }
    public void setSerialnumber(String s) { this.serialnumber = s; }

    public int getCarriage_weight() { return carriage_weight; }
    public void setCarriage_weight(int w) { this.carriage_weight = w; }

    public String getCarriage_type() { return carriage_type; }
    public void setCarriage_type(String t) { this.carriage_type = t; }
}
