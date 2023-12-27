package pl.hetman.wiktoria.java.app.socialactivitytracker.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.hetman.wiktoria.java.app.socialactivitytracker.api.exception.ActivityException;
import pl.hetman.wiktoria.java.app.socialactivitytracker.controller.model.ActivityModel;
import pl.hetman.wiktoria.java.app.socialactivitytracker.controller.model.ActivityTypeModel;
import pl.hetman.wiktoria.java.app.socialactivitytracker.dao.jdbc.DefaultActivityDao;
import pl.hetman.wiktoria.java.app.socialactivitytracker.dao.jdbc.UserDao;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class DefaultActivityDaoOptionalsTest {

    public static final String ACTIVITY_MODEL_LABEL_DANCE = "today's dancing";

    @Test
    void save() throws ActivityException {
        //given
        UserDao userDao = new UserDao();
        DefaultActivityDao defaultActivityDao = new DefaultActivityDao(userDao);

        ActivityTypeModel activityTypeModel = new ActivityTypeModel();
        activityTypeModel.setName("playing zbijak");
        activityTypeModel.setCustom(false);

        ActivityModel activityModel = new ActivityModel();
        activityModel.chooseActivityType(activityTypeModel);
        activityModel.begin();
        activityModel.setLabel("today's zbijak");

        //when
        Optional<ActivityModel> savedActivity = defaultActivityDao.create(activityModel);

        //then
        Assertions.assertAll(
                ()-> assertTrue(savedActivity.isPresent(), "Optional is not present"),
                ()-> assertNotNull(savedActivity, "Optional is null")
        );
    }

}