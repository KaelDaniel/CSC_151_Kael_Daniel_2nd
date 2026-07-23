package labs.examples.ArrayOptions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

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
        BufferedReader file4 = openErrorLog(Http_Logger_File); //opens the http_access.log file
        getGMTOffset(file4);
        file4.close();
        BufferedReader file5 = openErrorLog(Http_Logger_File); //opens the http_access.log file again for the last method
        getHTTPCodes(file5);
        file5.close();
        BufferedReader file6 = openErrorLog(Http_Logger_File); //opens the http_access.log file again for the last method
        getResponseSize(file6);
        file6.close();
        BufferedReader file7 = openErrorLog(Http_Logger_File); //opens the http_access.log file again for the last method
        groupHTTPMethodsAndEndPoints(file7);
        file7.close();
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
    private static BufferedReader openErrorLog(String filePath) throws FileNotFoundException { //just an overloaded version of the first one
        File file = new File(filePath);
        return new BufferedReader(new FileReader(file));
    }

    public static void getGMTOffset(BufferedReader File4) { //this is meant to get the GMT offset from the http_access.log file
        String error_line;
        int positive = 0; //counters
        int negative = 0;
        try {
            while ((error_line = File4.readLine()) != null) {
                if (error_line.contains("+0000")) { //counts the positives
                    positive++;
                } else if (error_line.contains("-0500")) { //and this one counts the negatives
                    negative++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Positive GMOffset count: " + positive); //this one is really simple, and hard to think about how to make it different from last time
        System.out.println("Negative GMOffset count: " + negative);
    }
        private static void getHTTPCodes(BufferedReader file) {
        String error_Line;
        int count2xx = 0; //counters for the different types of errors
        int count3xx = 0;
        int count5xx = 0;
        int totalLines = 0;

        try {
            while ((error_Line = file.readLine()) != null) {
                totalLines++;
                String[] parts = error_Line.split(" "); // cuts the lines into parts for easier searching 

                for (String part : parts) { // checks each line to see if it has the deired error codes, and adds to the counts if it does
                    if (part.matches("2\\d\\d")) {
                        count2xx++;
                    } else if (part.matches("3\\d\\d")) {
                        count3xx++;
                    } else if (part.matches("5\\d\\d")) {
                        count5xx++;
                    }
                }
            }

            System.out.println("2xx Errors: " + count2xx); // prints everything out
            System.out.println("3xx Errors: " + count3xx);
            System.out.println("5xx Errors: " + count5xx);
            System.out.println("Total lines read: " + totalLines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static void getResponseSize(BufferedReader file){
    String error_Line;
    int linesUnder3900 = 0; // Counter for response sizes under 3900
    try{
        while ((error_Line = file.readLine()) != null){
            String[] responseParts = error_Line.split(" "); // splits the lines for searching
            if (responseParts.length > 9) { // checks if the line has enough parts
                int value = Integer.parseInt(responseParts[9]); // gets the response size from the 10th part of the line
                if (value < 3900) {
                    linesUnder3900++;
                }
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    System.out.println("Lines with response size under 3900: " + linesUnder3900); //so this one is also really simple, and hard to change without breaking it
    }
    static void groupHTTPMethodsAndEndPoints(BufferedReader file){
    String error_Line;
    Set<String> methods = new HashSet<>(); // Set to store unique HTTP methods
    try{
        while ((error_Line = file.readLine()) != null){
            String[] parts = error_Line.split(" "); // Split the line by spaces to isolate the HTTP method
            if (parts.length > 5) {
                methods.add(parts[5]); // adds the HTTP method to the set once
            }
        }
        System.err.println("HTTP Methods:");
        for (String method : methods) {
            System.err.println(method); // Print out each unique method
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    }
}