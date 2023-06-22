package pl.hetman.wiktoria.java.app.socialactivitytracker.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.hetman.wiktoria.java.app.socialactivitytracker.api.exception.ActivityException;
import pl.hetman.wiktoria.java.app.socialactivitytracker.dao.ConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;

class ConnectionManagerTest {

    @Test
    void getConnection() throws ActivityException {
        //given


        //when
        Connection connection = ConnectionManager.getInstance().getConnection();

        //then
        Assertions.assertNotNull(connection, "Connection is null");

    }
}