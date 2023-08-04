package ParsingJson.Domain;

public class StationFromJson {
    private String station_name;
    private String depth;

    public StationFromJson() {}

    public StationFromJson(String station_name, String depth) {
        this.station_name = station_name;
        this.depth = depth;
    }

    public String getStation_name() {
        return station_name;
    }

    public void setStation_name(String station_name) {
        this.station_name = station_name;
    }

    public String getDepth() {
        return depth;
    }

    public void setDepth(String depth) {
        this.depth = depth;
    }

    @Override
    public String toString() {
        return "Station{" +
                "station_name='" + station_name + '\'' +
                ", depth='" + depth + '\'' +
                '}';
    }
}
