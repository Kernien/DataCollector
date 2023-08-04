package ParsingCSV;

import ParsingCSV.Domain.StationFromCSV;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVParser {
    public static ArrayList<StationFromCSV> parseCSV(String filePath) {
        ArrayList<StationFromCSV> stations = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                String name = values[0];
                String date = values[1];
                stations.add(new StationFromCSV(name, date));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stations;
    }
}
