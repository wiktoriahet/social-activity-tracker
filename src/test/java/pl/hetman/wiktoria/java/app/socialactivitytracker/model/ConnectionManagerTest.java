package pl.hetman.wiktoria.java.app.socialactivitytracker.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class ConnectionManagerTest {

    @Test
    void getConnection() throws SQLException {
        //given


        //when
        Connection connection = ConnectionManager.getInstance().getConnection();

        //then
        Assertions.assertNotNull(connection, "Connection is null");

    }
}