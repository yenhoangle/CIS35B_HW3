package model;

import java.util.*;

//need to change this into generics
public class AutoTemplate<A extends Automotive> {
    private LinkedHashMap<String, A> autoMap;

    public AutoTemplate() {
        autoMap = new LinkedHashMap<String, A>();
    }

    public LinkedHashMap<String, A> getAutoTemplate() {
        return autoMap;
    }

    public Automotive getAuto(String key) {
        return autoMap.get(key);
    }

    public void setAutoTemplate(LinkedHashMap<String, A> newMap) {
        autoMap = newMap;
    }

    public void addVehicle(String key, A vehicle) {
        autoMap.put(key, vehicle);
    }

    //for replacing an entire auto object but keeping the same key
    public void updateVehicle(String key, A newVehicle) {
        autoMap.put(key, newVehicle);
    }

    public void deleteVehicle(String key) {
        autoMap.remove(key);
    }

    //using keySet to print all keys
    public void printAllVehicles() {
        for (String autoKey: autoMap.keySet()) {
            System.out.println("Printing all Vehicles");
            System.out.println("[" + autoKey + "}");
        }
    }
}
