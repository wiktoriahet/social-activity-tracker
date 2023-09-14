package pl.hetman.wiktoria.java.app.socialactivitytracker.repositories;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

@Component
//@Scope(value = SCOPE_PROTOTYPE)
public class SessionFactoryManager {

    private static final Logger LOGGER = Logger.getLogger(SessionFactoryManager.class.getName());
    private static SessionFactoryManager INSTANCE;
    private SessionFactory sessionFactory;

    private SessionFactoryManager() {
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();

        try {
            sessionFactory = new MetadataSources(serviceRegistry)
                    .buildMetadata()
                    .buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(serviceRegistry);
        }
    }

    public static SessionFactoryManager getInstance() {
        LOGGER.info("getInstance()");
        if (INSTANCE == null) {
            INSTANCE = new SessionFactoryManager();
        }
        LOGGER.info("getInstance(...) = " + INSTANCE);
        return INSTANCE;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
