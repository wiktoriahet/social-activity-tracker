package pl.hetman.wiktoria.java.app.socialactivitytracker.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ActivityDaoIntegrationTest {

    public static final long ACTIVITY_MODEL_ID_55 = 55L;

    @Test
    void read(){
        //given
        ActivityDao activityDao = new ActivityDao();

        //when
        ActivityModel activityModel = activityDao.read(-99L);

        //then
        Assertions.assertNull(activityModel, "activityModel is not null");

    }

    @Test
    void createAndRead(){
        //given
        ActivityDao activityDao = new ActivityDao();
        ActivityModel activityModel = new ActivityModel();
        activityModel.setId(ACTIVITY_MODEL_ID_55);
        activityModel.setLabel("flying");

        //when

        activityDao.save(activityModel);
        ActivityModel readActivityModel = activityDao.read(ACTIVITY_MODEL_ID_55);

        //then
        Assertions.assertNotNull(readActivityModel, "activityModel is null");

    }

    @Test
    void update(){
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

        activityDao.save(activityModel);

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
    void delete(){
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

        activityDao.save(activityModel);

        //when
        activityDao.delete(activityModel);

        //then
    }
    // TODO: 13.04.2023 dookńczyć testy integracyjne dla metody update i delete (coś utworzyć zanim się zmodyfikuje itp) 

}