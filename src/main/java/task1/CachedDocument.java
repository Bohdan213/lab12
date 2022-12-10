package task1;

import com.google.cloud.vision.v1.*;
import lombok.AllArgsConstructor;

import javax.print.Doc;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
public class CachedDocument implements Document{
    private Document instance;
    private DBConnection connection;
    {
        try {
            connection = DBConnection.getInstance();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public CachedDocument(Document instance) {
        this.instance = instance;
    }
    @Override
    public String parse() throws SQLException {
        String responce = connection.isExist(instance.getGcsPath());
        if (responce.length() != 0) {
            return responce;
        } else {
            String data = instance.parse();
            connection.getData(instance.getGcsPath(), data);
            return data;
        }
    }

    @Override
    public String getGcsPath() {
        return instance.getGcsPath();
    }
}
