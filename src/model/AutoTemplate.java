package model;

import java.util.*;

public class AutoTemplate {
    private static LinkedHashMap<String, Automotive> autoMap;

    public AutoTemplate() {
        autoMap = new LinkedHashMap<String, Automotive>();
    }

    public LinkedHashMap<String, Automotive> getAutoTemplate() {
        return autoMap;
    }

    public Automotive getAuto(String key) {
        return autoMap.get(key);
    }

    public void setAutoTemplate(LinkedHashMap<String, Automotive> newMap) {
        autoMap = newMap;
    }

    public void addAuto(String key, Automotive auto) {
        autoMap.put(key, auto);
    }

    //for replacing an entire auto object but keeping the same key
    public void updateAuto(String key, Automotive newAuto) {
        autoMap.put(key, newAuto);
    }

    public void deleteAuto(String key) {
        autoMap.remove(key);
    }

    //using keySet to print all keys
    public void printAllAutos() {
        for (String autoKey: autoMap.keySet()) {
            System.out.println("Printing all Automotives");
            System.out.println(autoKey);
        }
    }
}
