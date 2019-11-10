package driver;

import adapter.BuildAuto;
import adapter.ConfigureAuto;
import adapter.CreateAuto;
import adapter.UpdateAuto;
import exception.AutoException;
import util.FileIO;

public class driver3 {
    public static void main(String[] args) throws AutoException {
        try {
            boolean complete = false;
            String file = "C:\\Users\\Arteh\\IdeaProjects\\CIS35B_HW2\\textfiles\\missingAutoName.txt";
            //a different file for a new car
            String file2 = ""; //TODO: make a file
            CreateAuto a1 = new BuildAuto();
            CreateAuto a2 = new BuildAuto();
            UpdateAuto ua = new BuildAuto();
            ConfigureAuto ca = new BuildAuto();

            FileIO fileIO = new FileIO();
            //attempting to build the car
            System.out.println("Attempting to build the cars");
            a1.buildAuto(file);
            a2.buildAuto(file2);
            System.out.println("\nPrinting the first auto after building");
            a1.printAuto("");
            System.out.println("\nPrinting the second auto after building");
            a2.printAuto("");

            // update the Automobile's options
            System.out.println("\nUpdating car's option set name");
            ua.updateOptionSetName("Ford Focus Wagon ZTW", "Color", "Colour");
            System.out.println("Updating car's option price");
            ua.updateOptionPrice("Ford Focus Wagon ZTW",
                    "Transmission", "Manual", -800);
            System.out.println("\nPrinting the auto after updating");
            a1.printAuto("");
            ca.selectChoices();
            float price = ca.calculatePrice();
            System.out.println("Total cost after selecting option is: " + price);
        } catch (AutoException ae) {

        }
    }
}
