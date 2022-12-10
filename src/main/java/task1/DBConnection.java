package task1;

import java.sql.*;

public class DBConnection {
    private static DBConnection dbconnection;

    private Connection connection;
    private DBConnection() throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:db.sqlite3");
        Statement stmt = connection.createStatement();
        String query = "create table if not exists images\n" +
                "(\n" +
                "id    integer primary key autoincrement,\n" +
                "path text,\n" +
                "data blob\n" +
                ")";
        stmt.executeUpdate(query);
        stmt.close();
    }

    public String isExist(String path) throws SQLException {
        Statement stmt = connection.createStatement();
        String query = String.format("SELECT * FROM images WHERE path = '" + path + "';");
        ResultSet response = stmt.executeQuery(query);
        String data = "";
        if (response.next()) {
            data = new String(response.getBytes("data"));
        }
        stmt.close();
        return data;
    }

    public void getData(String path, String data) throws SQLException {
        String query = "INSERT INTO images (path, data) VALUES (?, ?);";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, path);
        stmt.setString(2, data);
        stmt.executeUpdate();
        stmt.close();
    }
    public static DBConnection getInstance() throws SQLException {
        if (dbconnection == null) {
            dbconnection = new DBConnection();
        }
        return dbconnection;
    }
}
