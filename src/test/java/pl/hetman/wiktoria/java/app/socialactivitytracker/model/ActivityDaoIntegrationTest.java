package pl.hetman.wiktoria.java.app.socialactivitytracker.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.hetman.wiktoria.java.app.socialactivitytracker.model.dao.UniqueIdGenerator;

class ActivityDaoIntegrationTest {

    public static final long ACTIVITY_MODEL_ID_55 = 55L;
    public static final String ACTIVITY_MODEL_LABEL_JUMP = "today's jumping";

//    @Test
//    void read(){
//        //given
//        ActivityDao activityDao = new ActivityDao();
//
//        //when
//        ActivityModel activityModel = activityDao.read(-99L);
//
//        //then
//        Assertions.assertNull(activityModel, "activityModel is not null");
//
//    }

//    @Test
//    void createAndRead(){
//        //given
//        ActivityDao activityDao = new ActivityDao();
//        ActivityModel activityModel = new ActivityModel();
//        activityModel.setLabel(ACTIVITY_MODEL_LABEL_JUMP);
//        //activityModel.setId(UniqueIdGenerator.generateId());
//
//        //when
//
//        ActivityModel savedActivityModel = activityDao.save(activityModel);
//        ActivityModel readActivityModel = activityDao.read(savedActivityModel.getId());
//        System.out.println(readActivityModel);
//
//        //then
//        Assertions.assertAll(
//                ()->Assertions.assertNotNull(readActivityModel, "activityModel is null"),
//                ()->Assertions.assertEquals(ACTIVITY_MODEL_LABEL_JUMP, readActivityModel.getLabel(), "Label not equals")
//        );
//    }

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

}