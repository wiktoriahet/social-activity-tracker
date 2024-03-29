package pl.hetman.wiktoria.java.app.socialactivitytracker.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.hetman.wiktoria.java.app.socialactivitytracker.api.exception.ActivityException;
import pl.hetman.wiktoria.java.app.socialactivitytracker.controller.model.ActivityModel;
import pl.hetman.wiktoria.java.app.socialactivitytracker.controller.model.ActivityTypeModel;
import pl.hetman.wiktoria.java.app.socialactivitytracker.dao.jdbc.DefaultActivityDao;
import pl.hetman.wiktoria.java.app.socialactivitytracker.dao.jdbc.UserDao;

import java.util.Optional;

class DefaultActivityDaoTestWithID {

    @Test
    void save() throws ActivityException {
        //given
        UserDao userDao = new UserDao();
        DefaultActivityDao defaultActivityDao = new DefaultActivityDao(userDao);
        ActivityTypeModel activityTypeModel = new ActivityTypeModel();

        activityTypeModel.setName("cycling");
        activityTypeModel.setCustom(false);

        ActivityModel activityModel = new ActivityModel();

        //activityModel.setId(UniqueIdGenerator.generateId());
        activityModel.chooseActivityType(activityTypeModel);
        activityModel.begin();
        activityModel.end();
        String duration = activityModel.duration();
        activityModel.setLabel("today's cycling");

        //when
        Optional<ActivityModel> savedActivityModel = defaultActivityDao.create(activityModel);
        //ActivityModel savedActivityModel = activityDao.create(activityModel);

        //then

        Assertions.assertAll(
                ()->Assertions.assertNotNull(savedActivityModel, "activityModel is Null"),
                ()->Assertions.assertNotNull(savedActivityModel.get().getId(), "ID is Null")
        );
    }
}