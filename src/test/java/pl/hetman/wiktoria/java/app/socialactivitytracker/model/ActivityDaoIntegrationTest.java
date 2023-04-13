package pl.hetman.wiktoria.java.app.socialactivitytracker.model;

import org.junit.jupiter.api.Test;

class ActivityDaoIntegrationTest {

    @Test
    void update(){
        //given

        ActivityDao activityDao = new ActivityDao();

        ActivityTypeModel activityTypeModel = new ActivityTypeModel();
        activityTypeModel.setName("flying");
        activityTypeModel.setCustom(true);

        ActivityModel activityModel = new ActivityModel();
        activityModel.chooseActivityType(activityTypeModel);
        activityModel.begin();
        activityModel.end();
        String duration = activityModel.duration();
        activityModel.setLabel("today flying");

        String[] params = {activityTypeModel.getName(),
                String.valueOf(activityTypeModel.isCustom()),
                activityModel.getLabel(), null, null, null};

        //when

        activityDao.update(activityModel, "bowling");

        //then

    }

    @Test
    void delete(){
        //given
        ActivityModel activityModel = new ActivityModel();
        ActivityDao activityDao = new ActivityDao();
        String name = "flying";
        //when
        activityDao.delete(activityModel, name);

        //then

    }

}