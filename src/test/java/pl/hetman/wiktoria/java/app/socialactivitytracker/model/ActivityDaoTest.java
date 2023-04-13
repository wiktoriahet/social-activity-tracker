package pl.hetman.wiktoria.java.app.socialactivitytracker.model;

import org.junit.jupiter.api.Test;

class ActivityDaoTest {

    @Test
    void save(){
        //given
        ActivityDao activityDao = new ActivityDao();

        ActivityTypeModel activityTypeModel = new ActivityTypeModel();
        activityTypeModel.setName("swimming");
        activityTypeModel.setCustom(false);

        ActivityModel activityModel = new ActivityModel();
        //activityModel.setActivityType(activityTypeModel);
        activityModel.chooseActivityType(activityTypeModel);
        //activityModel.setStart(LocalDateTime.now());
        activityModel.begin();
        //activityModel.setStop(null);
        activityModel.setLabel("today swimming");

        //when
        activityDao.save(activityModel);

        //then

    }

    @Test
    void saveWithDuration(){
        //given
        ActivityDao activityDao = new ActivityDao();

        ActivityTypeModel activityTypeModel = new ActivityTypeModel();
        activityTypeModel.setName("running");
        activityTypeModel.setCustom(false);

        ActivityModel activityModel = new ActivityModel();
        //activityModel.setActivityType(activityTypeModel);
        activityModel.chooseActivityType(activityTypeModel);
        //activityModel.setStart(LocalDateTime.now());
        activityModel.begin();
        //activityModel.setStop(null);
        activityModel.end();
        String duration = activityModel.duration();
        activityModel.setLabel("today running");

        //when
        activityDao.save(activityModel);

        //then

    }

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

    @Test
    void read(){
        //given
        ActivityModel activityModel = new ActivityModel();
        ActivityDao activityDao = new ActivityDao();
        String name = "running";

        //when
        activityDao.read(activityModel, name);

        //then

    }

}