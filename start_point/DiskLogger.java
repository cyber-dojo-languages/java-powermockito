import java.io.*;

public final class DiskLogger {

    public static DiskLogger getInstance() {
        return singleton;
    }

    public void log(String line) {
        Boolean append;
        try (FileWriter fw = new FileWriter("hiker.log", append=true)) {
            fw.write(line + "\n");
        }
        catch (IOException failure) {
            throw new RuntimeException(failure);
        }
    }

    private DiskLogger() {
    }

    private static DiskLogger singleton = new DiskLogger();
}
