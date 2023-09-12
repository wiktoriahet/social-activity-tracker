package pl.hetman.wiktoria.java.app.socialactivitytracker.repositories;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pl.hetman.wiktoria.java.app.socialactivitytracker.api.exception.ActivityException;
import pl.hetman.wiktoria.java.app.socialactivitytracker.controller.model.ActivityModel;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ActivityTypeRepository implements Repository<ActivityModel>{

    private static final Logger LOGGER = Logger.getLogger(ActivityTypeRepository.class.getName());
    private static final SessionFactory SESSION_FACTORY;

    static {
        SESSION_FACTORY = SessionFactoryManager.getInstance().getSessionFactory();
    }

    @Override
    public Optional<ActivityModel> create(ActivityModel activityModel) throws ActivityException {
        LOGGER.info("create(" + activityModel + ")");
        LOGGER.info("create(...) = " + activityModel);
        return Optional.of(activityModel);
    }

    @Override
    public Optional<ActivityModel> read(Long id) throws ActivityException {
        LOGGER.info("read(" + id + ")");
        LOGGER.info("read(...)");
        return Optional.empty();
    }

    @Override
    public Optional<ActivityModel> update(ActivityModel activityModel) throws ActivityException {
        LOGGER.info("update(" + activityModel + ")");
        LOGGER.info("update(...) = " + activityModel);

        return Optional.of(activityModel);
    }

    @Override
    public boolean delete(ActivityModel activityModel) throws ActivityException {
        LOGGER.info("delete(" + activityModel + ")");
        LOGGER.info("delete(...)");
        return true;
    }

    @Override
    public List<ActivityModel> list() throws ActivityException {
        return null;
    }
}
