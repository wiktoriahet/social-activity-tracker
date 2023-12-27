package pl.hetman.wiktoria.java.app.socialactivitytracker.dao.hibernate.repository;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import pl.hetman.wiktoria.java.app.socialactivitytracker.api.exception.ActivityException;
import pl.hetman.wiktoria.java.app.socialactivitytracker.dao.entity.ActivityEntity;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class DefaultActivityRepository implements DefaultRepository<ActivityEntity> {

    //analogicznie do ActivityDao, tylko z hibernate
    //dla frameworkow sa repository (tu dla springa), dla innych dao

    private static final Logger LOGGER = Logger.getLogger(DefaultActivityRepository.class.getName());
    private static final SessionFactory SESSION_FACTORY;

    static {
        SESSION_FACTORY = SessionFactoryManager.getInstance().getSessionFactory();
    }


    public Optional<ActivityEntity> create(ActivityEntity activityEntity) {
        LOGGER.info("create(" + activityEntity + ")");
        Session session = SESSION_FACTORY.openSession();
        session.getTransaction().begin();
        session.save(activityEntity);
        session.getTransaction().commit();
        LOGGER.info("create(...) = " + activityEntity);

        return Optional.of(activityEntity);
    }

    public Optional<ActivityEntity> read(Long id) {
        LOGGER.info("read(" + id + ")");
        Session session = SESSION_FACTORY.openSession();
        session.getTransaction().begin();
        ActivityEntity activityEntity = session.get(ActivityEntity.class, id);
        session.getTransaction().commit();
        LOGGER.info("read(...) = " + activityEntity);

        return Optional.of(activityEntity);
    }

    public Optional<ActivityEntity> update(ActivityEntity activityEntity) {
        LOGGER.info("update(" + activityEntity + ")");
        Session session = SESSION_FACTORY.openSession();
        session.getTransaction().begin();
        session.merge(activityEntity);
        session.getTransaction().commit();
        LOGGER.info("update(...) = " + activityEntity);

        return Optional.of(activityEntity);
    }

    public boolean delete(ActivityEntity activityEntity) {
        LOGGER.info("delete(" + activityEntity + ")");
        boolean deleted;

        Session session = SESSION_FACTORY.openSession();
        try {
            session.getTransaction().begin();
            session.remove(activityEntity);
            session.getTransaction().commit();

            deleted = true;
            return deleted;
        } catch (HibernateException e) {
            LOGGER.log(Level.SEVERE, "Error while deleting Activity", e);
            deleted = false;
            session.getTransaction().rollback();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error while deleting Activity", e);
            deleted = false;
            session.getTransaction().rollback();
        }
        LOGGER.info("delete(...) = " + activityEntity);
        return deleted;
    }

    @Override
    public List<ActivityEntity> list() throws ActivityException {
        return null;
    }

}
