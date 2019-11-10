package adapter;
import exception.AutoException;
import model.AutoTemplate;
import model.Automotive;
import util.FileIO;
import java.util.Scanner;

public abstract class ProxyAutomotive {
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
    public void pickChoices() {
        Scanner scanner = new Scanner(System.in);
        //clear existing choices so user can pick again
        if (a1.getChoices().size() > 0) {
            a1.clearChoices();
        }
        for (int i = 0; i < a1.getOpsets().size(); i++) {
            boolean done = false;
            while(!done) {
                String opsetName = a1.getOpSetName(i);
                System.out.println("Please enter choice for " + opsetName);
                String opNameChosen = scanner.next();
                //search optionset for option choice with name to check validity
                if (a1.findOption(opsetName, opNameChosen) != null) {
                    //put that choice in choices arraylist
                    a1.addOptionChoice(opsetName, opNameChosen);
                    done = true;
                }
                else {
                    System.out.println("Invalid choice");
                }
            }
        }
        at1.addVehicle(a1.getName(), a1); //also add a1 to the hash map
    }

    public void printChoices() {
        a1.printChoices();
    }
    public float calculatePrice() {
        return a1.getTotalPrice();
    }
}
