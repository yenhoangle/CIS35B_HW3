package model;
import java.util.ArrayList;
import java.io.*;
public class OptionSet implements Serializable {
    private String name;
    private ArrayList<Option> options;
    private Option choice;
}
