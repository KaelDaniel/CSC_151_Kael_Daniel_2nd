package labs.examples.ArrayOptions;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files; // is used to read the contents of a file as if the the file is a stream of data
import java.nio.file.Path; // is used to represent a file in a file system
import java.nio.file.Paths; // is used to create Path objects

public class FileOperater {
    private static final Path PROJECT_ROOT = Paths.get("").toAbsolutePath(); // is used to get the current working directory of the project
    private static final Path FILES_DIRECTORY = PROJECT_ROOT.resolve("Files"); // is used to create a Path object that represents the "Files" directory in the project root
    private static final Path DATA_FILE = resolveExistingFile("users.csv"); // is used to create a Path object that represents the "users.csv" file in the project root or in the "Files" directory
    private static final Path ERROR_LOG_FILE = resolveExistingFile("api_error.log"); // is used to create a Path object that represents the "api_error.log" file in the project root or in the "Files" directory

    public static void main(String[] args) throws IOException {
        Files.createDirectories(FILES_DIRECTORY); // is used to create the "Files" directory if it does not exist
        open_CSV_File();
        display_Error_Logs();
    }

    private static Path resolveExistingFile(String fileName) {
        Path[] candidates = { // is used to create an array of Path objects that represent the possible locations of the file
                FILES_DIRECTORY.resolve(fileName),
                PROJECT_ROOT.resolve(fileName),
                Paths.get(fileName).toAbsolutePath()
        };

        for (Path candidate : candidates) { // is used to iterate over the array of Path objects and check if the file exists and is a regular file
            if (Files.exists(candidate) && Files.isRegularFile(candidate)) {
                return candidate;
            }
        }

        return FILES_DIRECTORY.resolve(fileName); // is used to return the Path object that represents the "Files" directory and the file name if the file does not exist in any of the other locations
    }

    private static void open_CSV_File() throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(DATA_FILE)) { // is used to create a BufferedReader object that reads the contents of the "users.csv" file as if it is a stream of data
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");

                String name = values[0]; // prints out the details of the csv file
                int math = Integer.parseInt(values[1]);
                int sci = Integer.parseInt(values[2]);
                int ela = Integer.parseInt(values[3]);
                float average = (math + sci + ela) / 3f;
                System.out.println(name + ": " + average);
            }
        }
    }

    private static void display_Error_Logs() throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(ERROR_LOG_FILE)) { // is used to create a BufferedReader object that reads the contents of the "api_error.log" file as if it is a stream of data
            String error_line;
            while ((error_line = reader.readLine()) != null) {
                String[] error_reports = error_line.split(" "); // prints out the error logs data

                String dates = error_reports[0];
                String time = error_reports[1];
                String error_type = error_reports[2];
                String error_version = error_reports[3];

                System.out.println(dates + " " + time + ": " + error_type + " " + error_version);
            }
        }
    }
}
