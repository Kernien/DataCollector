package ParsingCSV.Domain;

public class StationFromCSV {
    private String name;
    private String date;

    public StationFromCSV(String name, String date) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Station [name=" + name + ", date=" + date + "]";
    }
}
