package pl.hetman.wiktoria.java.app.socialactivitytracker.dao;

import org.junit.jupiter.api.Test;
import pl.hetman.wiktoria.java.app.socialactivitytracker.api.exception.ActivityException;
import pl.hetman.wiktoria.java.app.socialactivitytracker.controller.model.ActivityModel;
import pl.hetman.wiktoria.java.app.socialactivitytracker.controller.model.ActivityTypeModel;
import pl.hetman.wiktoria.java.app.socialactivitytracker.dao.jdbc.ActivityDao;
import pl.hetman.wiktoria.java.app.socialactivitytracker.dao.jdbc.UserDao;

class ActivityDaoTest {

    @Test
    void save() throws ActivityException {
        //given
        UserDao userDao = new UserDao();
        ActivityDao activityDao = new ActivityDao(userDao);

        ActivityTypeModel activityTypeModel = new ActivityTypeModel();
        activityTypeModel.setName("swimming");
        activityTypeModel.setCustom(false);

        ActivityModel activityModel = new ActivityModel();
        activityModel.setId(1L);
        activityModel.chooseActivityType(activityTypeModel);
        activityModel.begin();
        activityModel.setLabel("today's swimming");

        //when
        activityDao.create(activityModel);

        //then

    }

    @Test
    void saveWithDuration() throws ActivityException {
        //given
        UserDao userDao = new UserDao();
        ActivityDao activityDao = new ActivityDao(userDao);

        ActivityTypeModel activityTypeModel = new ActivityTypeModel();
        activityTypeModel.setName("running");
        activityTypeModel.setCustom(false);

        ActivityModel activityModel = new ActivityModel();
        activityModel.setId(2L);
        activityModel.chooseActivityType(activityTypeModel);
        activityModel.begin();
        activityModel.end();
        String duration = activityModel.duration();
        activityModel.setLabel("today's running");

        //when
        activityDao.create(activityModel);

        //then

    }

    @Test
    void update() throws ActivityException{
        //given
        UserDao userDao = new UserDao();
        ActivityDao activityDao = new ActivityDao(userDao);

        ActivityTypeModel activityTypeModel = new ActivityTypeModel();
        activityTypeModel.setName("flying");
        activityTypeModel.setCustom(true);

        ActivityModel activityModel = new ActivityModel();
        activityModel.setId(1L);
        activityModel.chooseActivityType(activityTypeModel);
        activityModel.begin();
        activityModel.end();
        String duration = activityModel.duration();
        activityModel.setLabel("today's flying");

        //when
        activityDao.update(activityModel);

        //then

    }

    @Test
    void delete() throws ActivityException{
        //given
        ActivityModel activityModel = new ActivityModel();
        UserDao userDao = new UserDao();
        ActivityDao activityDao = new ActivityDao(userDao);
        activityModel.setId(1L);
        //when
        activityDao.delete(activityModel);

        //then

    }
}