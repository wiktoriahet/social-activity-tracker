package pl.hetman.wiktoria.java.app.socialactivitytracker.dao.jdbc;

import pl.hetman.wiktoria.java.app.socialactivitytracker.dao.entity.ActivityEntity;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

public class DefaultActivityTypeDao implements DefaultDao<ActivityEntity> {

    private static final Logger LOGGER = Logger.getLogger(DefaultActivityTypeDao.class.getName());

    @Override
    public Optional<ActivityEntity> create(ActivityEntity activityEntity) {
        LOGGER.info("create(" + activityEntity + ")");
        LOGGER.info("create(...)");
        return Optional.empty();
    }

    @Override
    public void update(ActivityEntity activityEntity) {
        LOGGER.info("update(" + activityEntity + ")");
        LOGGER.info("update(...)");
    }

    @Override
    public void delete(ActivityEntity activityEntity) {
        LOGGER.info("delete(" + activityEntity + ")");
        LOGGER.info("delete(...)");
    }

    @Override
    public Optional<ActivityEntity> read(Long id) {
        LOGGER.info("read(" + id + ")");
        LOGGER.info("read(...)");
        return Optional.empty();
    }

    @Override
    public List<ActivityEntity> list() {
        LOGGER.info("list()");
        LOGGER.info("list(...)");
        return null;
    }
}
