package TotalsCollector;

import ParsingCSV.Domain.StationFromCSV;
import ParsingJson.Domain.StationFromJson;
import ParsingWeb.Domain.StationFromWeb;
import TotalsCollector.Domain.StationsToJson;
import FileSearch.FileSearcher;
import ParsingCSV.CSVParser;
import ParsingJson.JsonParser;
import ParsingWeb.Domain.LineFromWeb;
import ParsingWeb.WebParser;
import org.jsoup.nodes.Document;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CollectorAll {
    private static ArrayList<LineFromWeb> listLineWeb;
    private static ArrayList<StationFromWeb> listStationWeb;
    private static ArrayList<StationFromJson> listJsonStation;
    private static ArrayList<StationFromCSV> listCSVStations;

    private static void gettingInfo() {
        Document doc = WebParser.parsUrl("https://skillbox-java.github.io/");

        listLineWeb = WebParser.parsLines(doc);
        listStationWeb = WebParser.parsStation(doc);

        List<File> listJson = FileSearcher.searchJsonFiles("src/data/stations-data");
        listJsonStation = new ArrayList<>();
        for (File file : listJson) {
            ArrayList<StationFromJson> proxy = JsonParser.ParsToJson(file.toString());
            listJsonStation.addAll(proxy);
        }

        List<File> listCSV = FileSearcher.searchCsvFiles("src/data/stations-data");
        listCSVStations = new ArrayList<>();
        for (File file : listCSV) {
            ArrayList<StationFromCSV> proxy = CSVParser.parseCSV(file.toString());
            listCSVStations.addAll(proxy);
        }
    }


    public static List<StationsToJson> createStationsList() {
        gettingInfo();
        List<StationsToJson> stations = new ArrayList<>();

        for (StationFromWeb stationWeb : listStationWeb) {
            String name = stationWeb.getName();
            String line = findLineName(stationWeb.getLine());
            boolean hasConnection = stationWeb.isHasTransitions();
            String date = "";
            String depth = "";

            for (StationFromJson jsonStation : listJsonStation) {
                if (jsonStation.getStation_name().equals(name)) {
                    depth = jsonStation.getDepth();
                }
            }

            for (StationFromCSV csvStation : listCSVStations) {
                if (csvStation.getName().equals(name)) {
                    date = csvStation.getDate();
                }
            }

            StationsToJson station = new StationsToJson(name, line, date, depth, hasConnection);
            stations.add(station);
        }
        return stations;
    }

    private static String findLineName(String lineNumber) {
        for (LineFromWeb lineWeb : listLineWeb) {
            if (lineWeb.getNumberLine().equals(lineNumber)) {
                return lineWeb.getNameLine();
            }
        }
        return null;
    }
}
