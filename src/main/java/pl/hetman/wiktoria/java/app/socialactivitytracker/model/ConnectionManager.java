package pl.hetman.wiktoria.java.app.socialactivitytracker.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    String driverClassName = "org.h2.Driver";
    String connectionUrl = "jdbc:h2:~/test";
    String dbUser = "sa";
    String dbPwd = "";

    private static ConnectionManager connectionManager = null;

    private ConnectionManager(){
        try{
            Class.forName(driverClassName);
        } catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        Connection conn = null;
        conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
        return conn;
    }

    public static ConnectionManager getInstance(){
        if(connectionManager ==null){
            connectionManager = new ConnectionManager();
        }
        return connectionManager;
    }
}
