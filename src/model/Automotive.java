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

    public void setChoices(ArrayList<Option> choices) {
        this.choices = choices;
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

    //add methods
    public boolean addOpset(String name){
        if (name != null) {
            optionSets.add(new OptionSet(name));
            return true;
        }
        //do we have to do anything with choice here
        return false;
    }

    public boolean addOption(String opsetName, String opname, float opPrice) {
        if (opname != null && opname != null) {
            int opsetIndex = findOpsetIndex(opsetName);
            if (opsetIndex != -1) {
                return optionSets.get(opsetIndex).addOption(opname, opPrice);

            }
        }
        return false;
    }

    //update methods
    public void updateOpsetName(String name, String newName) {
        if (name != null && newName != null) {
            findOpset(name).setName(newName);
        }
    }

    public void updateOpset(String name, OptionSet newOpset) {
        if (name != null && !newOpset.equals(null)) {
            int opsetIndex = findOpsetIndex(name);
            if (opsetIndex != -1) {
                optionSets.set(opsetIndex, newOpset);
            }
        }
    }
    //update the entire option
    public void updateOp(String opsetName, String opname, String newOpname, float newPrice ) {
        if (opsetName != null && opname != null && newOpname!= null) {
            int opsetIndex = findOpsetIndex(opsetName);
            if (opsetIndex != -1) {
                optionSets.get(opsetIndex).updateOption(opname, newOpname, newPrice);
            }
        }
    }

    public void updateOpname (String opsetName, String opname, String newOpname) {
        if (opsetName != null && opname != null && newOpname!= null) {
            int opsetIndex = findOpsetIndex(opsetName);
            if (opsetIndex != -1) {
                optionSets.get(opsetIndex).updateOpName(opname, newOpname);
            }
        }
    }

    public void updateOpPrice (String opsetName, String opname, float newPrice) {
        if (opsetName != null && opname != null) {
            int opsetIndex = findOpsetIndex(opsetName);
            if (opsetIndex != -1) {
                optionSets.get(opsetIndex).updateOpPrice(opname, newPrice);
            }
        }
    }

    //delete methods
    public boolean deleteOpset(String name) {
        if (optionSets != null) {
            for(int i = 0; i < optionSets.size(); i++) {
                if (optionSets.get(i).getName().equals(name)) {
                    //use existing arraylist set method to set item to null
                    optionSets.set(i, null);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean deleteOption(String opsetName, String opName) {
        if (optionSets != null) {
            for (int i = 0; i < optionSets.size(); i++) {
                if(optionSets.get(i).getName().equals(opsetName)) {
                    return optionSets.get(i).deleteOption(opName);
                }
            }
        }
        return false;
    }
    //TODO: TOSTRING / PRINT

}
