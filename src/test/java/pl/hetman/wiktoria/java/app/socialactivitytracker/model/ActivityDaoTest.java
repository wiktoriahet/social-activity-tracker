package pl.hetman.wiktoria.java.app.socialactivitytracker.model;

import org.junit.jupiter.api.Test;
import pl.hetman.wiktoria.java.app.socialactivitytracker.controller.model.ActivityModel;
import pl.hetman.wiktoria.java.app.socialactivitytracker.controller.model.ActivityTypeModel;
import pl.hetman.wiktoria.java.app.socialactivitytracker.dao.ActivityDao;

class ActivityDaoTest {

    @Test
    void save(){
        //given
        ActivityDao activityDao = new ActivityDao();

        ActivityTypeModel activityTypeModel = new ActivityTypeModel();
        activityTypeModel.setName("swimming");
        activityTypeModel.setCustom(false);

        ActivityModel activityModel = new ActivityModel();
        activityModel.setId(1L);
        activityModel.chooseActivityType(activityTypeModel);
        activityModel.begin();
        activityModel.setLabel("today's swimming");

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
        activityModel.setId(2L);
        activityModel.chooseActivityType(activityTypeModel);
        activityModel.begin();
        activityModel.end();
        String duration = activityModel.duration();
        activityModel.setLabel("today's running");

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
        activityModel.setId(1L);
        activityModel.chooseActivityType(activityTypeModel);
        activityModel.begin();
        activityModel.end();
        String duration = activityModel.duration();
        activityModel.setLabel("today's flying");

        //when
        activityDao.update(activityModel);

        //then

    }

    @Test
    void delete(){
        //given
        ActivityModel activityModel = new ActivityModel();
        ActivityDao activityDao = new ActivityDao();
        activityModel.setId(1L);
        //when
        activityDao.delete(activityModel);

        //then

    }

//    @Test
//    void read(){
//        //given
//        ActivityDao activityDao = new ActivityDao();
//
//        //when
//        ActivityModel activityModel = activityDao.read(2L);
//
//        //then
//
//    }

}