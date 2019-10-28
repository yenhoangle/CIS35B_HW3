package exception;
import model.Automotive;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AutoException extends Exception{
    private int errno;
    private String errMessage;
    private Automotive auto;

    //messages for logging purposes
    private static String BAD_FILENAME = "Invalid Filename";
    private static String BAD_AUTO_NAME = "Invalid Auto Name";
    private static String BAD_BASE = "Invalid Base Price";
    private static String BAD_OPSET_NAME = "Invalid Option Set Name";
    private static String BAD_OP_NAME = "Invalid Option Name";
    private static String UNEXPECTED_EXCEPTION = "Unexpected Exception";

    //constructors
    public AutoException() {
        //super();
    }

    public AutoException(int errno) {
        //super();
        this.errno = errno;
        //default message
        this.errMessage = BAD_FILENAME;
    }

    //getters
    public int getErrNo() {
        return errno;
    }
    public String getErrMessage() {
        return errMessage;
    }

    //setters
    public void setErrNo(int errno) {
        this.errno = errno;
    }
    public void setErrMessage(String message) {
        errMessage = message;
    }
    public void setAuto(Automotive auto) {this.auto = auto; }

    //TODO FIX METHOD
    public void fix(int errno, Automotive car) {

    }

    //logger method to write error to a file
    public void log() {
        String filename = "C:\\Users\\Arteh\\IdeaProjects\\CIS35B_HW3\\textfiles\\log.txt";
        try {
            //creates a timestamp
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            String formattedTime = formatter.format(date);
            //sets file writer to append mode
            FileWriter fw = new FileWriter(filename, true);
            PrintWriter writer = new PrintWriter(fw);
            writer.printf("\n - Error occurred at [ %s ] Code %d: - %s\n", formattedTime, errno, errMessage);
            writer.close();
            fw.close();
        } catch(IOException e) {
            printStackTrace();
        }
    }







}
