package pl.hetman.wiktoria.java.app.socialactivitytracker.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.hetman.wiktoria.java.app.socialactivitytracker.dao.ActivityDao;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ActivityDaoOptionalsTest {

    public static final String ACTIVITY_MODEL_LABEL_DANCE = "today's dancing";

    @Test
    void save() {
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
        Optional<ActivityModel> savedActivity = activityDao.save(activityModel);

        //then
//        Assertions.assertAll(
//                ()-> assertTrue(savedActivity.isEmpty(), "Optional is present"),
//                ()-> assertNull(savedActivity, "Optional is not null")
//        );

        Assertions.assertAll(
                ()-> assertTrue(savedActivity.isPresent(), "Optional is not present"),
                ()-> assertNotNull(savedActivity, "Optional is null")
        );
    }

    @Test
    void createAndRead(){
        //given
        ActivityDao activityDao = new ActivityDao();
        ActivityModel activityModel = new ActivityModel();
        activityModel.setLabel(ACTIVITY_MODEL_LABEL_DANCE);

        //when

        Optional<ActivityModel> savedActivityModel = activityDao.save(activityModel);
        Optional<ActivityModel> readActivityModel = activityDao.read(savedActivityModel.get().getId());
        System.out.println(readActivityModel);

        //then
        Assertions.assertAll(
                ()->Assertions.assertNotNull(readActivityModel, "activityModel is null"),
                ()->Assertions.assertEquals(ACTIVITY_MODEL_LABEL_DANCE, readActivityModel.get().getLabel(), "Label not equals")
        );


    }
}