package util;
import java.util.*;
import java.io.*;

import exception.AutoException;
import model.Automotive;
import model.OptionSet;

public class FileIO {
    public Automotive buildAutoObject(String filename) throws  AutoException {
        try {
            try {
                File testFile = new File(filename);
                if (!testFile.exists() || testFile.length() == 0) {
                    throw new AutoException(1);
                }
            } catch (AutoException ae) {
                ae.log();
                System.out.println("Bad file, please check file and run the program again");
                System.exit(0);
            }

            FileReader fileReader = new FileReader(filename);
            BufferedReader buffer = new BufferedReader(fileReader);
            //creates a boolean value to keep track of end of file
            boolean eof = false;
            //first line has auto make, model, base price, and size of opset array
            String autoString = buffer.readLine();
            //file is empty
            try {
                if (autoString.isEmpty() || autoString.equals(" ")) {
                    throw new AutoException(1);
                }
            } catch (AutoException ae) {

            }
            String[] baseAuto = autoString.split(":");
            String autoMake = baseAuto[0];
            String autoModel = baseAuto[1];
            Float basePrice = Float.parseFloat((baseAuto[2]));
            int opsetNum = Integer.parseInt((baseAuto[3]));

            Automotive auto = new Automotive();

            //throw exception if make is empty
            try {
                if (baseAuto[0].equals(" ") || baseAuto[0].isEmpty()) {
                    throw new AutoException(2);
                }
            } catch (AutoException ae) {
                ae.fix(2, auto);

            }
            //throw exception if model is empty
            try {
                if (baseAuto[1].equals(" ") || baseAuto[0].isEmpty()) {
                    throw new AutoException(6);
                }
            } catch (AutoException ae) {
                ae.fix(6, auto);

            }
            //throw exception if base price is negative
            try {
                if (basePrice < 0) {
                    throw new AutoException(3);
                }
            } catch (AutoException ae) {
                ae.fix(3, auto);
                ae.log();
            }

            //TODO: FINISH IO

        } catch (FileNotFoundException fnf) {
            System.out.println("FNF");
            throw new AutoException(1);
        } catch (NullPointerException npe) {
            System.out.println("NPE");
        } catch (IOException e) {
            System.out.println("Error");
        }
        return null;
    }
}
