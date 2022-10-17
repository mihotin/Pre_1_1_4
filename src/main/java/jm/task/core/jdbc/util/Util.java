package jm.task.core.jdbc.util;
import jm.task.core.jdbc.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;


public class Util {
    private static volatile Util INSTANCE;
    private static final String URL = "jdbc:mysql://localhost:3306/mydbpp113";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private Connection connection;
    private SessionFactory sessionFactory;
    private Util() {
        try {
            this.connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                Properties settings = new Properties();
                settings.put(Environment.URL, URL);
                settings.put(Environment.USER, USERNAME);
                settings.put(Environment.PASS, PASSWORD);
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
                settings.put(Environment.SHOW_SQL, "true");
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                settings.put(Environment.HBM2DDL_AUTO, "none");

                configuration.setProperties(settings);
                configuration.addAnnotatedClass(User.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
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
