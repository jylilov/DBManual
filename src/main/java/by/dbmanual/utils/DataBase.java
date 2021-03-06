package by.dbmanual.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class DataBase {
    private static DataBase singleDataBase;

    private Connection connection = null;
    private Statement statement = null;

    public DataBase()  {
        try {
            connection = DriverManager.getConnection("jdbc:derby:memory:db;create=true");
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static DataBase getDataBase() {
        if (singleDataBase == null) {
            singleDataBase = new DataBase();
        }
        return singleDataBase;
    }

    public void execute(String resourceName) {
        try {

            ScriptRunner runner = new ScriptRunner(connection, true, true);
            runner.setLogWriter(null);
            InputStream resourceAsStream = DataBase.class.getResourceAsStream(resourceName);
            if (resourceAsStream == null) {
                throw new RuntimeException(String.format("Missing %s resource", resourceName));
            }
            runner.runScript(new InputStreamReader(resourceAsStream));
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    public String [][] queryFromResource(String resourceName) throws SQLException{
        return query(StringUtils.stringFromInputStream(DataBase.class.getResourceAsStream(resourceName)));
    }

    public String [][] query(String code) throws SQLException{
        List<String []> list = new ArrayList<>();
        try (ResultSet rs = statement.executeQuery(code)) {
            int length = rs.getMetaData().getColumnCount();
            String [] columnNames = new String[length];
            for (int i = 0; i < length; ++i) {
                columnNames[i] = rs.getMetaData().getColumnLabel(i + 1);
            }
            list.add(columnNames);
            while (rs.next()) {
                String [] record = new String[length];
                for (int i = 0; i < length; ++i) {
                    record[i] = rs.getString(i + 1);
                }
                list.add(record);
            }
        }
        return list.toArray(new String[list.size()][]);
    }

    public static void close() {
        if (singleDataBase != null) {
            try {
                singleDataBase.connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                singleDataBase.statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                DriverManager.getConnection("jdbc:derby:memory:db;shutdown=true");
            } catch (SQLException ignored) {
            }
        }
    }
}
