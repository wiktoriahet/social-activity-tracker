package pl.hetman.wiktoria.java.app.socialactivitytracker.dao;

import org.junit.jupiter.api.Test;
import pl.hetman.wiktoria.java.app.socialactivitytracker.api.exception.ActivityException;
import pl.hetman.wiktoria.java.app.socialactivitytracker.dao.DatabaseCleanUpManager;

class DatabaseCleanUpManagerTest {

    @Test
    void deleteTable() throws ActivityException {
        //given
        DatabaseCleanUpManager databaseCleanUpManager = new DatabaseCleanUpManager();

        //when
        databaseCleanUpManager.deleteTable();

        //then

    }
}