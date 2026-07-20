package labs.examples.ArrayOptions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Logger {

    private static final String File_Path = "C:\\Users\\Kael\\CSC_151_Kael_Daniel_2nd\\src\\labs\\examples\\ArrayOptions\\Files\\";
    private static final String Error_Logger_File = File_Path + "api_error.log";

    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader reader = openErrorLog();
        countErrors(reader);
        reader.close();
    }

    public static BufferedReader openErrorLog() throws FileNotFoundException, IOException {
        File file = new File(Error_Logger_File);
        return new BufferedReader(new FileReader(file));
    }

    public static void countErrors(BufferedReader reader) throws IOException {
        int[] counts = new int[3];
        String line;

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(" ");
            if (parts.length > 2) {
                String type = parts[2];

                if (type.equals("[ERROR]")) {
                    counts[0]++;
                } else if (type.equals("[WARN]")) {
                    counts[1]++;
                } else if (type.equals("[INFO]")) {
                    counts[2]++;
                }
            }
        }

        System.out.println("[ERROR]: " + counts[0]);
        System.out.println("[WARN]: " + counts[1]);
        System.out.println("[INFO]: " + counts[2]);
    }
}