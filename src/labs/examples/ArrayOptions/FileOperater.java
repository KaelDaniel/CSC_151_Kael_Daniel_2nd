package labs.examples.ArrayOptions;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileOperater {
    private static final Path PROJECT_ROOT = Paths.get("").toAbsolutePath();
    private static final Path FILES_DIRECTORY = PROJECT_ROOT.resolve("Files");
    private static final Path DATA_FILE = resolveExistingFile("users.csv");
    private static final Path ERROR_LOG_FILE = resolveExistingFile("api_error.log");

    public static void main(String[] args) throws IOException {
        Files.createDirectories(FILES_DIRECTORY);
        open_CSV_File();
        display_Error_Logs();
    }

    private static Path resolveExistingFile(String fileName) {
        Path[] candidates = {
                FILES_DIRECTORY.resolve(fileName),
                PROJECT_ROOT.resolve(fileName),
                Paths.get(fileName).toAbsolutePath()
        };

        for (Path candidate : candidates) {
            if (Files.exists(candidate) && Files.isRegularFile(candidate)) {
                return candidate;
            }
        }

        return FILES_DIRECTORY.resolve(fileName);
    }

    private static void open_CSV_File() throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(DATA_FILE)) {
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");

                String name = values[0];
                int math = Integer.parseInt(values[1]);
                int sci = Integer.parseInt(values[2]);
                int ela = Integer.parseInt(values[3]);
                float average = (math + sci + ela) / 3f;
                System.out.println(name + ": " + average);
            }
        }
    }

    private static void display_Error_Logs() throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(ERROR_LOG_FILE)) {
            String error_line;
            while ((error_line = reader.readLine()) != null) {
                String[] error_reports = error_line.split(" ");

                String dates = error_reports[0];
                String time = error_reports[1];
                String error_type = error_reports[2];
                String error_version = error_reports[3];

                System.out.println(dates + " " + time + ": " + error_type + " " + error_version);
            }
        }
    }
}
