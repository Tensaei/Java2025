package com.dronesim.api;

import java.util.List;

import com.dronesim.api.model.Drone;
import com.dronesim.api.model.DroneDynamics;
import com.dronesim.api.model.DroneType;

/*  Klasse um die Einzelnen Dronen Daten zu holen von der API 
 *  muss weiter ueberarbeitet werden bin mir auch nichts ganz sicher ob das
 * alles so seine richtig keit hat wegen Daten und Klassen Trennung
 * vor allem die sichtbarkeit der Methoden
 * 
 * getDroneType und getDroneDynamics sollten nur von der Dronen Klasse 
 * auf gerufen werden koennen 
 * 
 * getDroneList aufjedenfall nicht direkt aus der UI 
*/

public class FetchData {
    ApiConfig cfg = new ApiConfig();
    ApiClient client = new ApiClient(cfg);

    FetchData() {

    }

    public List<Drone> getDroneList(int anzahl, int seite) {
        
        
        return
    }

    public DroneType getDroneType() {}

    public DroneDynamics getDroneDynamics() {}
}
    