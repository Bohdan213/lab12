package task1;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Document document = new SmartDocument("gs://oop-course/Geico-2021.png");
        document = new TimedDocument(document);
        System.out.println(document.parse());
        document = new CachedDocument(document);
        System.out.println(document.parse());
    }
}
