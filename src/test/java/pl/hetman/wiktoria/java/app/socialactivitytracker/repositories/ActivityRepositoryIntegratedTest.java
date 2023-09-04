package pl.hetman.wiktoria.java.app.socialactivitytracker.repositories;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.hetman.wiktoria.java.app.socialactivitytracker.controller.model.ActivityModel;

class ActivityRepositoryIntegratedTest {

    private static final String ACTIVITY_LABEL_RUNNING = "Running";
    public static final String ACTIVITY_LABEL_KAYAKING = "Kayaking";

    public ActivityRepositoryIntegratedTest() {
    }

//    @Test
//    void createAndUpdate() {
//        //given
//        ActivityRepository activityRepository = new ActivityRepository();
//
//        ActivityModel createActivityModel = new ActivityModel();
//        createActivityModel.setLabel(ACTIVITY_LABEL_RUNNING);
//
//        ActivityModel updateActivityModel = new ActivityModel();
//        updateActivityModel.setLabel(ACTIVITY_LABEL_KAYAKING);
//
//        //when
//        ActivityModel createdActivityModel = activityRepository.create(createActivityModel);
//        updateActivityModel.setId(createdActivityModel.getId());
//        ActivityModel updatedActivityModel = activityRepository.update(updateActivityModel);
//
//        //then
//        Assertions.assertAll(
//                () -> Assertions.assertNotNull(updatedActivityModel, "updatedActivityModel is null"),
//                () -> Assertions.assertNotNull(updatedActivityModel.getId(), "updatedActivityModel.getId() is null"),
//                () -> Assertions.assertEquals(ACTIVITY_LABEL_KAYAKING, updatedActivityModel.getLabel(), "updatedActivityModel.getLabel() is not equal"),
//                () -> Assertions.assertNotEquals(ACTIVITY_LABEL_RUNNING, updatedActivityModel.getLabel(), "updatedActivityModel.getLabel() is equal")
//        );
//
//    }
}