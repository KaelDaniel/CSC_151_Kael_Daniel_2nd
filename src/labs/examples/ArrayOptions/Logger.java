package labs.examples.ArrayOptions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;



public class Logger{

    private static final String File_Path = "T:\\CSC_151_Kael_Daniel\\src\\labs\\example\\fileOperations\\";
    private static final String Error_Logger_File = File_Path + "logs\\csv_error.log";
    private static final String Api_Logger_File = File_Path + "logs\\api_error.log";
    private static final String Http_Logger_File = File_Path + "logs\\http_access.log";

    public static void main(BufferedReader reader) throws IOException {
        openErrorLog();
    } 
    
    public static BufferedReader openErrorLog() throws FileNotFoundException, IOException{
        File csv_error = new File(Error_Logger_File);
        return new BufferedReader(new FileReader(csv_error));
    }
    public static void getCountOfErrorTypes(BufferedReader reader) throws IOException {
        List<String> logLevels = new ArrayList<>(); // creates a new list to store the log levels found in the error log file
        String error_Line;
        while ((error_Line = reader.readLine()) != null) { // reads each line of the error log file until reaching the end
            String[] error_count = error_Line.split(" ");
            if (error_count.length > 2) { // checks if the line has at least 3 splits
                logLevels.add(error_count[2]); // adds the 3rd section to the array list, which would be the error types
            }
        }
    }
}