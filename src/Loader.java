import ParsingWeb.Domain.LineFromWeb;
import ParsingWeb.Domain.StationFromWeb;
import ParsingWeb.WebParser;
import WebCollector.CollectorWeb;
import TotalsCollector.Domain.StationsToJson;
import WebCollector.Domain.MetroMap;
import org.jsoup.nodes.Document;

import TotalsCollector.CollectorAll;

import java.util.ArrayList;
import java.util.List;

public class Loader {
    public static void main(String[] args) {
        Document doc = WebParser.parsUrl("https://skillbox-java.github.io/");
        MetroMap listLineWeb = CollectorWeb.createMetroMap();
        WebCollector.JsonMakerFromWeb.createMetroJson(listLineWeb, "src/data/stationsWeb.json");

        List<StationsToJson> list = CollectorAll.createStationsList();
        TotalsCollector.JsonMaker.createStationsJson(list, "src/data/stationsTotal.json");

    }
}
