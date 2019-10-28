package model;
import java.io.*;
import java.util.ArrayList;
import model.*;

public class Automotive implements Serializable {
    //separate variables to hold make and model, make + model = full name
    private String make;
    private String model;
    private float baseprice;
    private ArrayList<OptionSet> optionSet;
    private ArrayList<Option> choices; //choices is an array list of options chosen

    //constructors
    public Automotive() {
        this("", "", 0);
    }

    public Automotive(float baseprice) {
        this("","", baseprice);
    }

    public Automotive(String make, String model, float baseprice ) {
        this.make = make;
        this.model = model;
        this.baseprice = baseprice;
        optionSet = new ArrayList<OptionSet>();
        choices = new ArrayList<Option>();
    }

    //getters
    public String getName() {
        return(make + " " + model);
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public float baseprice() {
        return baseprice;
    }

    public ArrayList getOpset() {
        return optionSet;
    }

    //get opchoice, get opchoiceprice, set opchoice, get totalprice
    //setters
    //TODO: TOSTRING / PRINT

}
