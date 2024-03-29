package pl.hetman.wiktoria.java.app.socialactivitytracker.dao.hibernate.repository;

import pl.hetman.wiktoria.java.app.socialactivitytracker.api.exception.ActivityException;

import java.util.List;
import java.util.Optional;

public interface DefaultRepository<T>{

    Optional<T> create(T t) throws ActivityException;

    Optional<T> read(Long id) throws ActivityException;

    Optional<T> update(T t) throws ActivityException;

    boolean delete(T t) throws ActivityException;

    List<T> list ()throws ActivityException;

}
