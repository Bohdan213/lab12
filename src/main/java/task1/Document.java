package task1;

import lombok.Getter;

import java.sql.SQLException;
public interface Document {
    String parse() throws SQLException;
    String getGcsPath();
}
