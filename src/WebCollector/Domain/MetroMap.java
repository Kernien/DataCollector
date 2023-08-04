package WebCollector.Domain;

import java.util.List;

public class MetroMap {
    private List<LineFromWebToJson> lines;

    public MetroMap(List<LineFromWebToJson> lines) {
        this.lines = lines;
    }

    public List<LineFromWebToJson> getLines() {
        return lines;
    }

    public void setLines(List<LineFromWebToJson> lines) {
        this.lines = lines;
    }
}
