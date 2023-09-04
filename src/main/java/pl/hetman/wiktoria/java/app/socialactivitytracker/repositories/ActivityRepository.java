package pl.hetman.wiktoria.java.app.socialactivitytracker.repositories;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import pl.hetman.wiktoria.java.app.socialactivitytracker.controller.model.ActivityModel;

import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class ActivityRepository {

    //analogicznie do ActivityDao, tylko z hibernate
    //dla frameworkow sa repository (tu dla springa), dla innych dao

    private static final Logger LOGGER = Logger.getLogger(ActivityRepository.class.getName());
    private static final SessionFactory SESSION_FACTORY;

    static {
        SESSION_FACTORY = SessionFactoryManager.getInstance().getSessionFactory();
    }


    public ActivityModel create(ActivityModel activityModel) {
        LOGGER.info("create(" + activityModel + ")");
        Session session = SESSION_FACTORY.openSession();
        session.getTransaction().begin();
        session.persist(activityModel);
        session.getTransaction().commit();
        LOGGER.info("create(...) = " + activityModel);

        return activityModel;
    }

//    public ActivityModel read(Long id) {
//        LOGGER.info("read(" + id + ")");
//        Session session = SESSION_FACTORY.openSession();
//        session.getTransaction().begin();
//        ActivityModel activityModel = session.get(ActivityModel.class, id);
//        session.getTransaction().commit();
//        LOGGER.info("read(...) = " + activityModel);
//
//        return activityModel;
//    }

//    public ActivityModel update(ActivityModel activityModel) {
//        LOGGER.info("update(" + activityModel + ")");
//        Session session = SESSION_FACTORY.openSession();
//        session.getTransaction().begin();
//        session.merge(activityModel);
//        session.getTransaction().commit();
//        LOGGER.info("update(...) = " + activityModel);
//
//        return activityModel;
//    }

//    public boolean delete(ActivityModel activityModel) {
//        LOGGER.info("delete(" + activityModel + ")");
//        boolean deleted;
//
//        Session session = SESSION_FACTORY.openSession();
//        try {
//            session.getTransaction().begin();
//            session.remove(activityModel);
//            session.getTransaction().commit();
//
//            deleted = true;
//            return deleted;
//        } catch (HibernateException e) {
//            LOGGER.log(Level.SEVERE, "Error while deleting Activity", e);
//            deleted = false;
//            session.getTransaction().rollback();
//        } catch (Exception e) {
//            LOGGER.log(Level.SEVERE, "Error while deleting Activity", e);
//            deleted = false;
//            session.getTransaction().rollback();
//        }
//        LOGGER.info("delete(...) = " + activityModel);
//        return deleted;
//    }

}
