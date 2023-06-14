package pl.hetman.wiktoria.java.app.socialactivitytracker.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.hetman.wiktoria.java.app.socialactivitytracker.controller.model.ActivityModel;
import pl.hetman.wiktoria.java.app.socialactivitytracker.controller.model.ActivityTypeModel;

import java.util.Optional;

class ActivityDaoTestWithID {

    @Test
    void save() {
        //given
        ActivityDao activityDao = new ActivityDao();
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
        Optional<ActivityModel> savedActivityModel = activityDao.save(activityModel);
        //ActivityModel savedActivityModel = activityDao.save(activityModel);

        //then

        Assertions.assertAll(
                ()->Assertions.assertNotNull(savedActivityModel, "activityModel is Null"),
                ()->Assertions.assertNotNull(savedActivityModel.get().getId(), "ID is Null")
        );
    }
}