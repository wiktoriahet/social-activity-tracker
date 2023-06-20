package pl.hetman.wiktoria.java.app.socialactivitytracker.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.hetman.wiktoria.java.app.socialactivitytracker.api.exception.ActivityException;
import pl.hetman.wiktoria.java.app.socialactivitytracker.controller.model.ActivityModel;
import pl.hetman.wiktoria.java.app.socialactivitytracker.controller.model.ActivityTypeModel;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ActivityDaoOptionalsTest {

    public static final String ACTIVITY_MODEL_LABEL_DANCE = "today's dancing";

    @Test
    void save() throws ActivityException {
        //given
        ActivityDao activityDao = new ActivityDao();

        ActivityTypeModel activityTypeModel = new ActivityTypeModel();
        activityTypeModel.setName("playing zbijak");
        activityTypeModel.setCustom(false);

        ActivityModel activityModel = new ActivityModel();
        activityModel.chooseActivityType(activityTypeModel);
        activityModel.begin();
        activityModel.setLabel("today's zbijak");

        //when
        Optional<ActivityModel> savedActivity = activityDao.create(activityModel);

        //then
        Assertions.assertAll(
                ()-> assertTrue(savedActivity.isPresent(), "Optional is not present"),
                ()-> assertNotNull(savedActivity, "Optional is null")
        );
    }

}