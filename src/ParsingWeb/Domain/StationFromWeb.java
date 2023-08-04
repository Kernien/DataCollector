package ParsingWeb.Domain;

public class StationFromWeb {
    private String name;
    private String line;
    private boolean hasTransitions;

    public StationFromWeb(String name, String line, boolean hasTransitions) {
        this.name = name;
        this.line = line;
        this.hasTransitions = hasTransitions;
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

    public boolean isHasTransitions() {
        return hasTransitions;
    }

    public void setHasTransitions(boolean hasTransitions) {
        this.hasTransitions = hasTransitions;
    }

    @Override
    public String toString() {
        return "Station name: " + this.name
                + ", Line: " + this.line
                + ", Has transitions: " + this.hasTransitions;
    }
}
