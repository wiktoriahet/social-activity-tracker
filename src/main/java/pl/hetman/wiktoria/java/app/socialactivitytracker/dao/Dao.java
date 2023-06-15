package pl.hetman.wiktoria.java.app.socialactivitytracker.dao;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {

    Optional<T> save(T t);

    void update(T t);

    void delete(T t);

    Optional<T> read(Long id);

    List<T> list (T t);

}
