package com.dronesim.api;

import com.dronesim.api.model.*;
import com.dronesim.api.parser.ManualJsonParser;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Test {
    public static void main(String[] args) throws Exception {
        
        ManualJsonParser parser = new ManualJsonParser();

        String typesJson  = Files.readString(Path.of("dronetypes.json"), StandardCharsets.UTF_8);
        String dronesJson = Files.readString(Path.of("drones.json"    ), StandardCharsets.UTF_8);
        String dynJson    = Files.readString(Path.of("dynamics.json"  ), StandardCharsets.UTF_8);

        List<DroneType> types = parser.parseDroneTypes(typesJson);
        System.out.println("Loaded DroneTypes: " + types.size());

        List<Drone> drones   = parser.parseDrones(dronesJson);
        System.out.println("Loaded Drones: "     + drones.size());

        List<DroneDynamics> dyn = parser.parseDynamics(dynJson);
        System.out.println("Loaded Dynamics: "   + dyn.size());
    }
}
