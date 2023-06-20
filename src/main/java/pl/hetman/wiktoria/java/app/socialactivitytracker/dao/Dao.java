package pl.hetman.wiktoria.java.app.socialactivitytracker.dao;

import pl.hetman.wiktoria.java.app.socialactivitytracker.api.exception.ActivityException;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {

    Optional<T> create(T t) throws ActivityException;

    Optional<T> read(Long id);

    void update(T t);

    void delete(T t);

    List<T> list ();

}
