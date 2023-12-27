package pl.hetman.wiktoria.java.app.socialactivitytracker.dao.jdbc;

import pl.hetman.wiktoria.java.app.socialactivitytracker.api.exception.ActivityException;

import java.util.List;
import java.util.Optional;

public interface DefaultDao<T> {

    Optional<T> create(T t) throws ActivityException;

    Optional<T> read(Long id) throws ActivityException;

    void update(T t) throws ActivityException;

    void delete(T t) throws ActivityException;

    List<T> list ()throws ActivityException;

}
