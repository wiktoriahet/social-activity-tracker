package pl.hetman.wiktoria.java.app.socialactivitytracker.dao;

import pl.hetman.wiktoria.java.app.socialactivitytracker.api.exception.ActivityException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

public class DatabaseCleanUpManager implements DatabaseCleanUp{

    private static final Logger LOGGER =
            Logger.getLogger(DatabaseCleanUpManager.class.getName());

    @Override
    public void deleteTable() throws ActivityException {
        LOGGER.info("deleteTable()");
        String queryString = "TRUNCATE TABLE ACTIVITIES_COPY_TWO";

        try(Connection connection = ConnectionManager.getInstance().getConnection();){
            PreparedStatement preparedStatement = connection.prepareStatement(queryString);
            preparedStatement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }

        LOGGER.info("deleteTable(...)");

    }
}
