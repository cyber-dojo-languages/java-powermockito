import java.util.ArrayList;

public class FakeLogger {

    public void log(String line) {
        lines.add(line);
    }

    public Boolean endsWith(String line) {
        return lines.get(lines.size() - 1).equals(line);
    }

    private ArrayList<String> lines = new ArrayList<String>();
}
