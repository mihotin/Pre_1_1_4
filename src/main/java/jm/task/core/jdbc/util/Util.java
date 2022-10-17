package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static volatile Util INSTANCE;
    private static final String URL = "jdbc:mysql://localhost:3306/mydbpp113";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private Connection connection;


    private Util() {
        try {
            this.connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static Util getInstance() {
        if (INSTANCE == null) {
            synchronized (Util.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Util();
                }
            }
        }
        return INSTANCE;
    }
}
