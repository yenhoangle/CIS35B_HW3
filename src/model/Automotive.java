package model;
import java.io.*;
import java.util.ArrayList;
import model.*;

public class Automotive implements Serializable {
    //separate variables to hold make and model
    private String make;
    private String model;
    private float baseprice;
    private ArrayList<OptionSet> opset;
    private ArrayList<Option> choices;

    //TODO: tostring / print method
}
