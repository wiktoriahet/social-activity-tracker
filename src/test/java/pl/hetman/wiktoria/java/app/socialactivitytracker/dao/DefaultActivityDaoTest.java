package pl.hetman.wiktoria.java.app.socialactivitytracker.dao;

import org.junit.jupiter.api.Test;
import pl.hetman.wiktoria.java.app.socialactivitytracker.api.exception.ActivityException;
import pl.hetman.wiktoria.java.app.socialactivitytracker.dao.entity.ActivityEntity;
import pl.hetman.wiktoria.java.app.socialactivitytracker.dao.entity.ActivityTypeEntity;
import pl.hetman.wiktoria.java.app.socialactivitytracker.dao.jdbc.DefaultActivityDao;
import pl.hetman.wiktoria.java.app.socialactivitytracker.dao.jdbc.UserDao;

class DefaultActivityDaoTest {

    @Test
    void save() throws ActivityException {
        //given
        UserDao userDao = new UserDao();
        DefaultActivityDao defaultActivityDao = new DefaultActivityDao(userDao);

        ActivityTypeEntity activityTypeEntity = new ActivityTypeEntity();
        activityTypeEntity.setName("swimming");
        activityTypeEntity.setCustom(false);

        ActivityEntity activityEntity = new ActivityEntity();
        activityEntity.setId(1L);
        activityEntity.chooseActivityType(activityTypeEntity);
        activityEntity.begin();
        activityEntity.setLabel("today's swimming");

        //when
        defaultActivityDao.create(activityEntity);

        //then

    }

    @Test
    void saveWithDuration() throws ActivityException {
        //given
        UserDao userDao = new UserDao();
        DefaultActivityDao defaultActivityDao = new DefaultActivityDao(userDao);

        ActivityTypeEntity activityTypeEntity = new ActivityTypeEntity();
        activityTypeEntity.setName("running");
        activityTypeEntity.setCustom(false);

        ActivityEntity activityEntity = new ActivityEntity();
        activityEntity.setId(2L);
        activityEntity.chooseActivityType(activityTypeEntity);
        activityEntity.begin();
        activityEntity.end();
        String duration = activityEntity.duration();
        activityEntity.setLabel("today's running");

        //when
        defaultActivityDao.create(activityEntity);

        //then

    }

    @Test
    void update() throws ActivityException{
        //given
        UserDao userDao = new UserDao();
        DefaultActivityDao defaultActivityDao = new DefaultActivityDao(userDao);

        ActivityTypeEntity activityTypeEntity = new ActivityTypeEntity();
        activityTypeEntity.setName("flying");
        activityTypeEntity.setCustom(true);

        ActivityEntity activityEntity = new ActivityEntity();
        activityEntity.setId(1L);
        activityEntity.chooseActivityType(activityTypeEntity);
        activityEntity.begin();
        activityEntity.end();
        String duration = activityEntity.duration();
        activityEntity.setLabel("today's flying");

        //when
        defaultActivityDao.update(activityEntity);

        //then

    }

    @Test
    void delete() throws ActivityException{
        //given
        ActivityEntity activityEntity = new ActivityEntity();
        UserDao userDao = new UserDao();
        DefaultActivityDao defaultActivityDao = new DefaultActivityDao(userDao);
        activityEntity.setId(1L);
        //when
        defaultActivityDao.delete(activityEntity);

        //then

    }
}