package TotalsCollector.Domain;

public class StationsToJson {
    private String name;
    private String line;
    private String date;
    private String depth;
    private boolean hasConnection;

    public StationsToJson(String name, String line) {
        this.name = name;
        this.line = line;
    }

    public StationsToJson(String name, String line, String date, String depth, boolean hasConnection) {
        this.name = name;
        this.line = line;
        this.date = date;
        this.depth = depth;
        this.hasConnection = hasConnection;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDepth() {
        return depth;
    }

    public void setDepth(String depth) {
        this.depth = depth;
    }

    public boolean isHasConnection() {
        return hasConnection;
    }

    public void setHasConnection(boolean hasConnection) {
        this.hasConnection = hasConnection;
    }

    @Override
    public String toString() {
        return "Stations{" +
                "name='" + name + '\'' +
                ", line='" + line + '\'' +
                ", date='" + date + '\'' +
                ", depth='" + depth + '\'' +
                ", hasConnection=" + hasConnection +
                '}';
    }
}
