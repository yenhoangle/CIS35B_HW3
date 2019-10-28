package model;
import java.io.*;
import java.util.ArrayList;
import model.*;

public class Automotive implements Serializable {
    //separate variables to hold make and model, make + model = full name
    private String make;
    private String model;
    private float baseprice;
    private ArrayList<OptionSet> optionSets;
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
        optionSets = new ArrayList<OptionSet>();
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

    public ArrayList getOpsets() {
        return optionSets;
    }

    //TODO: FINISH THIS
    public Option getOptionChoice(String opsetName) {
        return null;
    }

    //get opchoice, get opchoiceprice, set opchoice, get totalprice
    //setters
    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setBaseprice(float price) {
        this.baseprice = price;
    }

    public void setOptionChoice(String opsetName, String opName) {
        //break it down to do null checks
        OptionSet foundOpSet = findOpset(opsetName);
        if (foundOpSet != null) {
            int foundOptionIndex = foundOpSet.findOpIndex(opName);
            if (foundOptionIndex != -1) {
                foundOpSet.setOpChoice(foundOptionIndex);
            }
        }
        //TODO: UPDATE choices
    }

    public int findOpsetIndex(String opsetName) {
        for (OptionSet opset : optionSets) {
            if (opset.getName().equals(opsetName)) {
                //use built in arraylist method to find index
                return optionSets.indexOf(opset);
            }
        }
        //not found
        return -1;
    }

    public OptionSet findOpset(String opsetName) {
        for (OptionSet opset : optionSets) {
            if (opset.getName().equals(opsetName)) {
                return opset;
            }
        }
        return null;
    }
    //TODO: TOSTRING / PRINT

}
