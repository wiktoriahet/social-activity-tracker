package pl.hetman.wiktoria.java.app.socialactivitytracker.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.hetman.wiktoria.java.app.socialactivitytracker.api.exception.ActivityException;
import pl.hetman.wiktoria.java.app.socialactivitytracker.controller.model.ActivityModel;
import pl.hetman.wiktoria.java.app.socialactivitytracker.controller.model.ActivityTypeModel;
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
        Optional<ActivityModel> readActivityModel = defaultActivityDao.read(-99L);

        //then
        Assertions.assertNotNull(readActivityModel, "activityModel is not null");

    }

    @Test
    void createAndRead() throws ActivityException {
        //given
        UserDao userDao = new UserDao();
        DefaultActivityDao defaultActivityDao = new DefaultActivityDao(userDao);
        ActivityModel activityModel = new ActivityModel();
        activityModel.setLabel(ACTIVITY_MODEL_LABEL_KAYAK);

        //when

        Optional<ActivityModel> savedActivityModel = defaultActivityDao.create(activityModel);
        Optional<ActivityModel> readActivityModel = defaultActivityDao.read(savedActivityModel.get().getId());
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
        ActivityTypeModel activityTypeModel = new ActivityTypeModel();

        activityTypeModel.setName("walking");
        activityTypeModel.setCustom(true);

        ActivityModel activityModel = new ActivityModel();

        activityModel.setId(4L);
        activityModel.chooseActivityType(activityTypeModel);
        activityModel.begin();
        activityModel.end();
        activityModel.duration();
        activityModel.setLabel("today's walking");

        defaultActivityDao.create(activityModel);

        //dane do modyfikacji
        activityTypeModel.setName("jogging");
        activityTypeModel.setCustom(true);
        activityModel.setLabel("today's jogging");
        activityModel.begin();
        activityModel.end();
        activityModel.duration();

        //when
        defaultActivityDao.update(activityModel);

        //then

    }

    @Test
    void delete() throws ActivityException {
        //given
        //utworzona aktywność do usunięcia
        ActivityModel activityModel = new ActivityModel();
        UserDao userDao = new UserDao();
        DefaultActivityDao defaultActivityDao = new DefaultActivityDao(userDao);
        ActivityTypeModel activityTypeModel = new ActivityTypeModel();

        activityTypeModel.setName("flying");
        activityTypeModel.setCustom(true);

        activityModel.setId(5L);
        activityModel.chooseActivityType(activityTypeModel);
        activityModel.begin();
        activityModel.end();
        activityModel.duration();
        activityModel.setLabel("today's flying");

        defaultActivityDao.create(activityModel);

        //when
        defaultActivityDao.delete(activityModel);

        //then
    }

}