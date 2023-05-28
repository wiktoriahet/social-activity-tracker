package pl.hetman.wiktoria.java.app.socialactivitytracker.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseCleanUpManager implements DatabaseCleanUp{

    // TODO: 28.05.2023 truncate table

    @Override
    public void deleteTable() {
        String queryString = "TRUNCATE TABLE ACTIVITIES_COPY_TWO";

        try(Connection connection = ConnectionManager.getInstance().getConnection();){
            PreparedStatement preparedStatement = connection.prepareStatement(queryString);
            preparedStatement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }

    }
}
