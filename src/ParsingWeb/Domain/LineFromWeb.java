package ParsingWeb.Domain;

public class LineFromWeb {
    private String nameLine;
    private String numberLine;

    public LineFromWeb(String nameLine, String numberLine) {
        this.nameLine = nameLine;
        this.numberLine = numberLine;
    }

    public String getNameLine() {
        return nameLine;
    }

    public void setNameLine(String nameLine) {
        this.nameLine = nameLine;
    }

    public String getNumberLine() {
        return numberLine;
    }

    public void setNumberLine(String numberLine) {
        this.numberLine = numberLine;
    }

    @Override
    public String toString() {
        return "Line{" +
                "nameLine='" + nameLine + '\'' +
                ", numberLine=" + numberLine +
                '}';
    }
}
