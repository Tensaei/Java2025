package com.dronesim.api;

import com.dronesim.api.model.*;
import com.dronesim.api.service.ManualJsonParser;
import java.nio.file.Path;
import java.util.List;

public class Test {
    public static void main(String[] args) throws Exception {
        List<DroneType> types = ManualJsonParser.parseDroneTypes(Path.of("dronetypes.json"));
        System.out.println("Loaded DroneTypes: " + types.size());
            
        List<Drone> drones = ManualJsonParser.parseDrones(Path.of("drones.json"));
        System.out.println("Loaded Drones: " + drones.size());

        List<DroneDynamics> dyn = ManualJsonParser.parseDynamics(Path.of("dynamics.json"));
        System.out.println("Loaded Dynamics: " + dyn.size());

    }
}
