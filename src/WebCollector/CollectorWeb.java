package WebCollector;

import ParsingWeb.Domain.LineFromWeb;
import ParsingWeb.Domain.StationFromWeb;
import ParsingWeb.WebParser;
import TotalsCollector.Domain.StationsToJson;
import WebCollector.Domain.LineFromWebToJson;
import WebCollector.Domain.MetroMap;
import org.jsoup.nodes.Document;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollectorWeb {
    private static ArrayList<LineFromWeb> listLineWeb;
    private static ArrayList<StationFromWeb> listStationWeb;

    private static void gettingInfo() {
        Document doc = WebParser.parsUrl("https://skillbox-java.github.io/");
        listLineWeb = WebParser.parsLines(doc);
        listStationWeb = WebParser.parsStation(doc);
    }


    public static MetroMap createMetroMap() {
        gettingInfo();
        Map<String, LineFromWebToJson> linesMap = new HashMap<>();

        for (ParsingWeb.Domain.StationFromWeb stationWeb : listStationWeb) {
            String lineName = findLineName(stationWeb.getLine());
            LineFromWebToJson line = linesMap.getOrDefault(lineName, new LineFromWebToJson(lineName, new ArrayList<>()));
            line.getStations().add(stationWeb.getName());
            linesMap.put(lineName, line);
        }

        return new MetroMap(new ArrayList<>(linesMap.values()));
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
