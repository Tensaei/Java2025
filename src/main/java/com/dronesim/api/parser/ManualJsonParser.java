package com.dronesim.api.service;

import com.dronesim.api.model.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class ManualJsonParser {

    private static String extractResultsArray(String fullJson) {
        int idx = fullJson.indexOf("\"results\":");
        if (idx < 0) throw new RuntimeException("Kein results-Feld gefunden");
        int start = fullJson.indexOf('[', idx);
        int end   = fullJson.indexOf(']', start+1);
        if (start < 0 || end < 0) throw new RuntimeException("Ungültiges JSON-Format");
        return fullJson.substring(start+1, end).trim();
    }

    public static List<DroneType> parseDroneTypes(Path jsonFile) throws Exception {
        String text = Files.readString(jsonFile);
        String array = extractResultsArray(text);
        if (array.isEmpty()) return List.of();

        List<DroneType> list = new ArrayList<>();
        String[] items = array.split("\\},\\s*\\{");
        for (String item : items) {
            item = item.replaceAll("^[\\{\\s]+|[\\}\\s]+$", "");
            Map<String,String> map = toMap(item);
            DroneType dt = new DroneType();
            dt.setId             (Integer.parseInt(map.get("id")));
            dt.setManufacturer   (map.get("manufacturer"));
            dt.setTypename       (map.get("typename"));
            dt.setWeight         (Integer.parseInt(map.get("weight")));
            dt.setMax_speed      (Integer.parseInt(map.get("max_speed")));
            dt.setBattery_capacity(Integer.parseInt(map.get("battery_capacity")));
            dt.setControl_range  (Integer.parseInt(map.get("control_range")));
            dt.setMax_carriage   (Integer.parseInt(map.get("max_carriage")));
            list.add(dt);
        }
        return list;
    }

    public static List<Drone> parseDrones(Path jsonFile) throws Exception {
        String text  = Files.readString(jsonFile);
        String array = extractResultsArray(text);
        if (array.isEmpty()) return List.of();

        List<Drone> list = new ArrayList<>();
        String[] items = array.split("\\},\\s*\\{");
        for (String item : items) {
            item = item.replaceAll("^[\\{\\s]+|[\\}\\s]+$", "");
            Map<String,String> map = toMap(item);
            Drone d = new Drone();
            d.setId            (Integer.parseInt(map.get("id")));
            d.setDronetype     (map.get("dronetype"));
            d.setCreated       (map.get("created"));
            d.setSerialnumber  (map.get("serialnumber"));
            d.setCarriage_weight(Integer.parseInt(map.get("carriage_weight")));
            d.setCarriage_type (map.get("carriage_type"));
            list.add(d);
        }
        return list;
    }

    public static List<DroneDynamics> parseDynamics(Path jsonFile) throws Exception {
        String text = Files.readString(jsonFile);
        String array = extractResultsArray(text);
        if (array.isEmpty()) return List.of();

        List<DroneDynamics> list = new ArrayList<>();
        String[] items = array.split("\\},\\s*\\{");
        for (String item : items) {
            item = item.replaceAll("^[\\{\\s]+|[\\}\\s]+$", "");
            Map<String,String> map = toMap(item);
            DroneDynamics dd = new DroneDynamics();
            dd.setDrone    (map.get("drone"));
            dd.setTimestamp(map.get("timestamp"));
            dd.setSpeed   (Double.parseDouble(map.get("speed")));
            list.add(dd);
        }
        return list;
    }

    private static Map<String,String> toMap(String item) {
        Map<String,String> map = new HashMap<>();
        String[] pairs = item.split(",\\s*");
        for (String pair : pairs) {
            String[] kv = pair.split(":",2);
            String key   = kv[0].trim().replaceAll("^\"|\"$", "");
            String value = kv[1].trim().replaceAll("^\"|\"$", "");
            map.put(key, value);
        }
        return map;
    }
}
