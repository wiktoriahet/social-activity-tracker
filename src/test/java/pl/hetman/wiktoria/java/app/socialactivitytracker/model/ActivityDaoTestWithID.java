package pl.hetman.wiktoria.java.app.socialactivitytracker.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.hetman.wiktoria.java.app.socialactivitytracker.model.dao.UniqueIdGenerator;

import static org.junit.jupiter.api.Assertions.*;

class ActivityDaoTestWithID {

    @Test
    void save() {
        //given
        ActivityDao activityDao = new ActivityDao();
        ActivityTypeModel activityTypeModel = new ActivityTypeModel();

        activityTypeModel.setName("reading");
        activityTypeModel.setCustom(false);

        ActivityModel activityModel = new ActivityModel();

        activityModel.setId(UniqueIdGenerator.generateId());
        activityModel.chooseActivityType(activityTypeModel);
        activityModel.begin();
        activityModel.end();
        String duration = activityModel.duration();
        activityModel.setLabel("today's reading");

        //when
        activityDao.save(activityModel);

        //then
        Assertions.assertNotNull(activityModel, "activityModel is Null");
    }
}