package adapter;
import exception.AutoException;
import model.AutoTemplate;
import model.Automotive;
import util.FileIO;
import java.util.LinkedHashMap;

public class ProxyAutomotive {
    private static AutoTemplate at1;
    private static Automotive a1;

    public ProxyAutomotive() {
        a1 = new Automotive();
        at1 = new AutoTemplate();
    }

    //implements CreateAuto interface methods via subclass BuildAuto
    public void buildAuto(String filename) throws AutoException {
        FileIO fileIO = new FileIO();
        a1 = fileIO.buildAutoObject(filename);
        at1.addAuto(a1.getName(), a1); //also add a1 to the hash map
    }

    public void printAuto(String modelName) {
        a1.print();
    }

    //UpdateAuto interface methods via subclass BuildAuto
    public void updateOptionSetName(String modelName, String opsetName, String newOpsetName) {
        a1.updateOpsetName(opsetName, newOpsetName);
    }

    public void updateOptionPrice(String modelName, String opsetName, String opName, float newPrice) {
        a1.updateOpPrice(opsetName, opName, newPrice);
    }

    //implements FixAuto interface method
    public void fix(int errno)  {
    }

    //implements ConfigureAuto interface methods
    public void setChoices() {

    }

    public void printChoices() {

    }
    public float calculatePrice() {
        return a1.getTotalPrice();
    }
}
