package pl.hetman.wiktoria.java.app.socialactivitytracker.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.hetman.wiktoria.java.app.socialactivitytracker.api.exception.ActivityException;
import pl.hetman.wiktoria.java.app.socialactivitytracker.controller.model.ActivityModel;
import pl.hetman.wiktoria.java.app.socialactivitytracker.controller.model.ActivityTypeModel;

import java.util.Optional;

class ActivityDaoIntegrationTest {

    public static final long ACTIVITY_MODEL_ID_55 = 55L;
    public static final String ACTIVITY_MODEL_LABEL_JUMP = "today's jumping";

    @Test
   void read() throws ActivityException{
       //given
        ActivityDao activityDao = new ActivityDao();

        //when
        Optional<ActivityModel> readActivityModel = activityDao.read(-99L);

        //then
        Assertions.assertNotNull(readActivityModel, "activityModel is not null");

    }

    @Test
    void createAndRead() throws ActivityException {
        //given
        ActivityDao activityDao = new ActivityDao();
        ActivityModel activityModel = new ActivityModel();
        activityModel.setLabel(ACTIVITY_MODEL_LABEL_JUMP);

        //when

        Optional<ActivityModel> savedActivityModel = activityDao.create(activityModel);
        Optional<ActivityModel> readActivityModel = activityDao.read(savedActivityModel.get().getId());
        System.out.println(readActivityModel);

        //then
        Assertions.assertAll(
                ()->Assertions.assertNotNull(readActivityModel, "activityModel is null"),
                ()->Assertions.assertEquals(ACTIVITY_MODEL_LABEL_JUMP, readActivityModel.get().getLabel(), "Label not equals")
        );
    }

    @Test
    void update() throws ActivityException {
        //given

        //utworzona aktywność do zapisania
        ActivityDao activityDao = new ActivityDao();
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

        activityDao.create(activityModel);

        //dane do modyfikacji
        activityTypeModel.setName("jogging");
        activityTypeModel.setCustom(true);
        activityModel.setLabel("today's jogging");
        activityModel.begin();
        activityModel.end();
        activityModel.duration();

        //when
        activityDao.update(activityModel);

        //then

    }

    @Test
    void delete() throws ActivityException {
        //given
        //utworzona aktywność do usunięcia
        ActivityModel activityModel = new ActivityModel();
        ActivityDao activityDao = new ActivityDao();
        ActivityTypeModel activityTypeModel = new ActivityTypeModel();

        activityTypeModel.setName("flying");
        activityTypeModel.setCustom(true);

        activityModel.setId(5L);
        activityModel.chooseActivityType(activityTypeModel);
        activityModel.begin();
        activityModel.end();
        activityModel.duration();
        activityModel.setLabel("today's flying");

        activityDao.create(activityModel);

        //when
        activityDao.delete(activityModel);

        //then
    }

}