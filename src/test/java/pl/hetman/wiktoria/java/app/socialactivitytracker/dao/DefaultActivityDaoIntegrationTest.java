package pl.hetman.wiktoria.java.app.socialactivitytracker.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.hetman.wiktoria.java.app.socialactivitytracker.api.exception.ActivityException;
import pl.hetman.wiktoria.java.app.socialactivitytracker.dao.entity.ActivityEntity;
import pl.hetman.wiktoria.java.app.socialactivitytracker.dao.entity.ActivityTypeEntity;
import pl.hetman.wiktoria.java.app.socialactivitytracker.dao.jdbc.DefaultActivityDao;
import pl.hetman.wiktoria.java.app.socialactivitytracker.dao.jdbc.UserDao;

import java.util.Optional;

class DefaultActivityDaoIntegrationTest {

    public static final long ACTIVITY_MODEL_ID_55 = 55L;
    public static final String ACTIVITY_MODEL_LABEL_KAYAK = "today's kayaking";

    @Test
   void read() throws ActivityException{
       //given
        UserDao userDao = new UserDao();
        DefaultActivityDao defaultActivityDao = new DefaultActivityDao(userDao);

        //when
        Optional<ActivityEntity> readActivityModel = defaultActivityDao.read(-99L);

        //then
        Assertions.assertNotNull(readActivityModel, "activityModel is not null");

    }

    @Test
    void createAndRead() throws ActivityException {
        //given
        UserDao userDao = new UserDao();
        DefaultActivityDao defaultActivityDao = new DefaultActivityDao(userDao);
        ActivityEntity activityEntity = new ActivityEntity();
        activityEntity.setLabel(ACTIVITY_MODEL_LABEL_KAYAK);

        //when

        Optional<ActivityEntity> savedActivityModel = defaultActivityDao.create(activityEntity);
        Optional<ActivityEntity> readActivityModel = defaultActivityDao.read(savedActivityModel.get().getId());
        System.out.println(readActivityModel);

        //then
        Assertions.assertAll(
                ()->Assertions.assertNotNull(readActivityModel, "activityModel is null"),
                ()->Assertions.assertEquals(ACTIVITY_MODEL_LABEL_KAYAK, readActivityModel.get().getLabel(), "Label not equals")
        );
    }

    @Test
    void update() throws ActivityException {
        //given

        //utworzona aktywność do zapisania
        UserDao userDao = new UserDao();
        DefaultActivityDao defaultActivityDao = new DefaultActivityDao(userDao);
        ActivityTypeEntity activityTypeEntity = new ActivityTypeEntity();

        activityTypeEntity.setName("walking");
        activityTypeEntity.setCustom(true);

        ActivityEntity activityEntity = new ActivityEntity();

        activityEntity.setId(4L);
        activityEntity.chooseActivityType(activityTypeEntity);
        activityEntity.begin();
        activityEntity.end();
        activityEntity.duration();
        activityEntity.setLabel("today's walking");

        defaultActivityDao.create(activityEntity);

        //dane do modyfikacji
        activityTypeEntity.setName("jogging");
        activityTypeEntity.setCustom(true);
        activityEntity.setLabel("today's jogging");
        activityEntity.begin();
        activityEntity.end();
        activityEntity.duration();

        //when
        defaultActivityDao.update(activityEntity);

        //then

    }

    @Test
    void delete() throws ActivityException {
        //given
        //utworzona aktywność do usunięcia
        ActivityEntity activityEntity = new ActivityEntity();
        UserDao userDao = new UserDao();
        DefaultActivityDao defaultActivityDao = new DefaultActivityDao(userDao);
        ActivityTypeEntity activityTypeEntity = new ActivityTypeEntity();

        activityTypeEntity.setName("flying");
        activityTypeEntity.setCustom(true);

        activityEntity.setId(5L);
        activityEntity.chooseActivityType(activityTypeEntity);
        activityEntity.begin();
        activityEntity.end();
        activityEntity.duration();
        activityEntity.setLabel("today's flying");

        defaultActivityDao.create(activityEntity);

        //when
        defaultActivityDao.delete(activityEntity);

        //then
    }

}