package labs.examples.ArrayOptions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Logger {

    private static final String File_Path = "C:\\Users\\Kael\\CSC_151_Kael_Daniel_2nd\\src\\labs\\examples\\ArrayOptions\\Files\\"; // sets up the file path way for the program to follow with line 12 as a continuation for the api_error.log file.
    private static final String Error_Logger_File = File_Path + "api_error.log";
    private static final String Http_Logger_File = File_Path + "http_access.log";

    public static void main(String[] args) throws FileNotFoundException, IOException { //runs the methods and closes the file after each method is over to not cuase problems in the future.
        BufferedReader reader = openErrorLog();
        countErrors(reader);
        reader.close();
        BufferedReader file2 = openErrorLog();
        getMemoryLimitExceededCount(file2);
        file2.close();
        BufferedReader file3 = openErrorLog();
        getDiskSpaceErrors(file3);
        file3.close();
    }

    public static BufferedReader openErrorLog() throws FileNotFoundException, IOException { //opens the file without a argument, and returns the buffered reader for future use
        File file = new File(Error_Logger_File);
        return new BufferedReader(new FileReader(file));
    }

    public static void countErrors(BufferedReader reader) throws IOException {
        int[] counts = new int[4]; //makes the array for the four types of errors
        String errorlines;

        while ((errorlines = reader.readLine()) != null) {
            String[] parts = errorlines.split(" "); //splits the line into parts to be able to check the type of error in the line
            if (parts.length > 2) {
                String type = parts[2];

                if (type.equals("[ERROR]")) { //if and if/else statements that catch the rror types and adds a count for them
                    counts[0]++;
                } else if (type.equals("[WARN]")) {
                    counts[1]++;
                } else if (type.equals("[INFO]")) {
                    counts[2]++;
                } else if (type.equals("[DEBUG]")) {
                    counts[3]++;  //sad that there are no debugs, but eh
                }  
            }
        }

        System.out.println("[ERROR]: " + counts[0]); //prints out the reulsts
        System.out.println("[WARN]: " + counts[1]);
        System.out.println("[INFO]: " + counts[2]);
        System.out.println("[DEBUG]: " + counts[3]);
    }
    public static void getMemoryLimitExceededCount(BufferedReader file2) { //this is meant to get the endpoints
        int memory_Limit = 0; //a memory limit counter
        String error_Line = "";

        try {            
            
            while ((error_Line = file2.readLine()) != null) { //reads each line
                if (error_Line.indexOf("Memory limit exceeded") >= 0) { //checks for the words "memort limit exceeded"
                    memory_Limit++; //and then adds it to the counts
                    int endpointStart = error_Line.indexOf("Endpoint:"); //this then finds the end points
                    System.out.println("Memory Limit Exceeded Count: " + memory_Limit + " | Endpoint: "); // prints out the counts and end point like it is numbering them as they pop up
                    if (endpointStart >= 0) {
                        String endpoint = error_Line.substring(endpointStart + 10).trim(); //this makes the end point look good by trimming it
                        System.out.println(endpoint);
                    }
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void getDiskSpaceErrors(BufferedReader file3) { // this is meant to get the api addresses
        int memory_Limit = 0; //a memory limit counter
        String error_Line = "";
        int lineNumber = 0; //used to record which line the errors apear on

        try {
            while ((error_Line = file3.readLine()) != null) { //reads each line
                lineNumber++; // keeps track of the line number for the errors
                if (error_Line.indexOf("Disk space") >= 0) { //checks for the words "disk space"
                    memory_Limit++; //and then adds it to the counts
                    String[] parts = error_Line.split(" "); //this splits the lines to make it easier to find the ip address
                    String apiAddress = "Not found";
                    if (parts.length > 2) {
                        apiAddress = parts[3]; //the IP address is the fourth part in each line
                    }
                    System.out.println("Disk Space Errors Count: " + memory_Limit + " | API Address: " + apiAddress + " | Line: " + lineNumber); // prints out the number of errors, the addresses, and the lines they apear on
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static BufferedReader openErrorLog(BufferedReader HTTP_Access) throws FileNotFoundException { //just an overloaded version of the first one
        File HTTP_Access1 = new File(Http_Logger_File); 
        return new BufferedReader(new FileReader(HTTP_Access1)); 
    }
}