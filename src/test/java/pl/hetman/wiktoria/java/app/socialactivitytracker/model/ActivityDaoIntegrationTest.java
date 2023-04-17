package pl.hetman.wiktoria.java.app.socialactivitytracker.model;

import org.junit.jupiter.api.Test;

class ActivityDaoIntegrationTest {

    @Test
    void update(){
        //given

        //utworzona aktywność do zapisania
        ActivityDao activityDao = new ActivityDao();
        ActivityTypeModel activityTypeModel = new ActivityTypeModel();

        activityTypeModel.setName("flying");
        activityTypeModel.setCustom(true);

        ActivityModel activityModel = new ActivityModel();

        activityModel.setId(3L);
        activityModel.chooseActivityType(activityTypeModel);
        activityModel.begin();
        activityModel.end();
        String duration = activityModel.duration();
        activityModel.setLabel("today's flying");

        activityDao.save(activityModel);

        //dane do modyfikacji
        activityTypeModel.setName("running");
        activityTypeModel.setCustom(true);
        activityModel.setLabel("today's running");
        activityModel.begin();
        activityModel.end();
        duration = activityModel.duration();

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

        activityModel.setId(4L);
        activityModel.chooseActivityType(activityTypeModel);
        activityModel.begin();
        activityModel.end();
        String duration = activityModel.duration();
        activityModel.setLabel("today's flying");

        activityDao.save(activityModel);

        //when
        activityDao.delete(activityModel);

        //then

    }
    // TODO: 13.04.2023 dookńczyć testy integracyjne dla metody update i delete (coś utworzyć zanim się zmodyfikuje itp) 

}