package pl.hetman.wiktoria.java.app.socialactivitytracker.dao.jdbc;

import pl.hetman.wiktoria.java.app.socialactivitytracker.api.exception.ActivityException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionManager {
    private static final Logger LOGGER = Logger.getLogger(ConnectionManager.class.getName());

    private String driverClassName = "org.h2.Driver";
    private String connectionUrl;
    private String dbUser;
    private String dbPwd;

    private static ConnectionManager connectionManager = null;

    private ConnectionManager() {
        CredentialsProperties credentialsProperties = new CredentialsProperties();
        try {
            Class.forName(driverClassName);
            connectionUrl = credentialsProperties.getProperty("database");
            dbUser = credentialsProperties.getProperty("dbuser");
            dbPwd = credentialsProperties.getProperty("dbpassword");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws ActivityException {
        LOGGER.info("getConnection()");
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Problem with connection", e);
            throw new ActivityException("Problem with connection", e);
        } catch (RuntimeException e){
            LOGGER.log(Level.SEVERE, "Runtime problem with connection", e);
            throw new ActivityException("Runtime problem with connection", e);
        }
        LOGGER.info("getConnection(...) = " + connection);
        return connection;
    }

    public static ConnectionManager getInstance() {
        LOGGER.info("getInstance()");
        if (connectionManager == null) {
            connectionManager = new ConnectionManager();
        }
        LOGGER.info("getInstance(...)");
        return connectionManager;
    }
}
