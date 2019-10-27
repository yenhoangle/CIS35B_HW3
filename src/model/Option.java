package model;
import java.io.*;

public class Option implements Serializable {
    private String name;
    private float price;

    //constructors
    protected Option() {
        this("", 0);
    }

    protected Option(String name) {
        this(name, 0);
    }

    protected Option(float price) {
        this("", price);
    }

    protected Option(String name, float price) {
        this.name = name;
        this.price = price;
    }

    //getters
    protected String getName() {
        return this.name;
    }

    protected float getPrice() {
        return this.price;
    }


}
