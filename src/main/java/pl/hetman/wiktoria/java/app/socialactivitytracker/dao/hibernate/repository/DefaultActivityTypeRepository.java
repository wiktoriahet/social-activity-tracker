package pl.hetman.wiktoria.java.app.socialactivitytracker.dao.hibernate.repository;

import org.hibernate.SessionFactory;
import pl.hetman.wiktoria.java.app.socialactivitytracker.api.exception.ActivityException;
import pl.hetman.wiktoria.java.app.socialactivitytracker.dao.entity.ActivityEntity;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

public class DefaultActivityTypeRepository implements DefaultRepository<ActivityEntity> {

    private static final Logger LOGGER = Logger.getLogger(DefaultActivityTypeRepository.class.getName());
    private static final SessionFactory SESSION_FACTORY;

    static {
        SESSION_FACTORY = SessionFactoryManager.getInstance().getSessionFactory();
    }

    @Override
    public Optional<ActivityEntity> create(ActivityEntity activityEntity) throws ActivityException {
        LOGGER.info("create(" + activityEntity + ")");
        LOGGER.info("create(...) = " + activityEntity);
        return Optional.of(activityEntity);
    }

    @Override
    public Optional<ActivityEntity> read(Long id) throws ActivityException {
        LOGGER.info("read(" + id + ")");
        LOGGER.info("read(...)");
        return Optional.empty();
    }

    @Override
    public Optional<ActivityEntity> update(ActivityEntity activityEntity) throws ActivityException {
        LOGGER.info("update(" + activityEntity + ")");
        LOGGER.info("update(...) = " + activityEntity);

        return Optional.of(activityEntity);
    }

    @Override
    public boolean delete(ActivityEntity activityEntity) throws ActivityException {
        LOGGER.info("delete(" + activityEntity + ")");
        LOGGER.info("delete(...)");
        return true;
    }

    @Override
    public List<ActivityEntity> list() throws ActivityException {
        return null;
    }
}
