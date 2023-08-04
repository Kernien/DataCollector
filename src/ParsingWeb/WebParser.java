package ParsingWeb;

import ParsingWeb.Domain.LineFromWeb;
import ParsingWeb.Domain.StationFromWeb;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class WebParser {
    public static void parsAll() {
        Document doc = parsUrl("https://skillbox-java.github.io/");
        parsLines(doc);
        parsStation(doc);
    }

    public static Document parsUrl(String url) {
        try {
            Document doc = Jsoup.connect("https://skillbox-java.github.io/").get();
            return doc;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<LineFromWeb> parsLines(Document doc) {
        Elements lines = doc.select("span.js-metro-line");
        ArrayList<LineFromWeb> lineList = new ArrayList<>();
        for (Element element : lines) {
            var nameLine = element.text();
            var numberLine = element.select("span.js-metro-line.t-metrostation-list-header.t-icon-metroln").attr("data-line");
            lineList.add(new LineFromWeb(nameLine, numberLine));
        }
        return lineList;
    }

    public static ArrayList<StationFromWeb> parsStation(Document doc) {
        ArrayList<StationFromWeb> lineStation = new ArrayList<>();
        Elements lineElements = doc.select("div.js-depend");

        for (Element lineElement : lineElements) {
            String lineNumber = lineElement.attr("data-depend-set").replace("lines-", "");

            Elements stationElements = lineElement.select("p.single-station");

            for (Element stationElement : stationElements) {
                String stationName = stationElement.selectFirst("span.name").text();
                boolean hasTransitions = !stationElement.select("span.t-icon-metroln").isEmpty();

                StationFromWeb station = new StationFromWeb(stationName, lineNumber, hasTransitions);

                lineStation.add(station);
            }
        }
        return lineStation;
    }
}
