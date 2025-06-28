package com.dronesim.api;

import com.dronesim.api.model.*;
import java.util.List;

/*
 * Converts raw JSON into model objects
 * 
 * Es braucht keine Liste an FroneTypes und DroneDynamics
 */

public interface DataProvider {
    List<DroneType> parseDroneTypes(String json) throws Exception;
    List<Drone> parseDrones(String json) throws Exception;
    List<DroneDynamics> parseDynamics (String json) throws Exception;
}
