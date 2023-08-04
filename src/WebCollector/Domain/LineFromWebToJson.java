package WebCollector.Domain;

import java.util.List;

public class LineFromWebToJson {
    private String name;
    private List<String> stations;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getStations() {
        return stations;
    }

    public void setStations(List<String> stations) {
        this.stations = stations;
    }

    public LineFromWebToJson(String name, List<String> stations) {
        this.name = name;
        this.stations = stations;
    }
}
