package FileSearch;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileSearcher {
    private static final String JSON_EXTENSION = ".json";
    private static final String CSV_EXTENSION = ".csv";

    public static List<File> searchJsonFiles(String directoryPath) {
        List<File> filesFound = new ArrayList<>();
        addFiles(directoryPath, JSON_EXTENSION, filesFound);
        return filesFound;
    }

    public static List<File> searchCsvFiles(String directoryPath) {
        List<File> filesFound = new ArrayList<>();
        addFiles(directoryPath, CSV_EXTENSION, filesFound);
        return filesFound;
    }

    public static List<File> searchJsonAndCsvFiles(String directoryPath) {
        List<File> filesFound = new ArrayList<>();
        filesFound.addAll(searchJsonFiles(directoryPath));
        filesFound.addAll(searchCsvFiles(directoryPath));
        return filesFound;
    }

    private static void addFiles(String directoryPath, String fileExtension, List<File> filesFound) {
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    addFiles(file.getPath(), fileExtension, filesFound);
                } else if (file.getName().endsWith(fileExtension)) {
                    filesFound.add(file);
                }
            }
        }
    }
}
