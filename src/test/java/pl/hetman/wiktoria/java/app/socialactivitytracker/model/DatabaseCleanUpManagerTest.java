package pl.hetman.wiktoria.java.app.socialactivitytracker.model;

import org.junit.jupiter.api.Test;
import pl.hetman.wiktoria.java.app.socialactivitytracker.dao.DatabaseCleanUpManager;

class DatabaseCleanUpManagerTest {

    // TODO: 28.05.2023 truncate table test

    @Test
    void deleteTable() {
        //given
        DatabaseCleanUpManager databaseCleanUpManager = new DatabaseCleanUpManager();

        //when
        databaseCleanUpManager.deleteTable();

        //then

    }
}