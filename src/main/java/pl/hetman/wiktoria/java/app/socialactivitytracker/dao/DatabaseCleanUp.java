package pl.hetman.wiktoria.java.app.socialactivitytracker.dao;

import pl.hetman.wiktoria.java.app.socialactivitytracker.api.exception.ActivityException;

public interface DatabaseCleanUp{
    void deleteTable() throws ActivityException;
}
