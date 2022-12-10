package task1;

import lombok.AllArgsConstructor;

import java.sql.SQLException;

@AllArgsConstructor
public class TimedDocument implements Document{

    private Document instance;
    @Override
    public String parse() throws SQLException {
        long start = System.nanoTime();
        String data = instance.parse();
        long end = System.nanoTime();
        return String.valueOf((end - start));
    }

    @Override
    public String getGcsPath() {
        return instance.getGcsPath();
    }
}
