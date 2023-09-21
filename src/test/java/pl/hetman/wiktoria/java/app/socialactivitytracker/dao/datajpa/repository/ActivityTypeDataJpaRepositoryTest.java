package pl.hetman.wiktoria.java.app.socialactivitytracker.dao.datajpa.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.hetman.wiktoria.java.app.socialactivitytracker.controller.model.ActivityTypeModel;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ActivityTypeDataJpaRepositoryTest {

    private static final String ACTIVITY_NAME_FISHING = "Fishing";
    private static final String ACTIVITY_NAME_SNORKELING = "Snorkeling";

    @Autowired
    private ActivityTypeDataJpaRepository activityTypeDataJpaRepository;

    @Test
    public void create() {
        //given
        ActivityTypeModel activityTypeModel = new ActivityTypeModel();
        activityTypeModel.setCustom(true);
        activityTypeModel.setName(ACTIVITY_NAME_SNORKELING);

        //when
        ActivityTypeModel savedActivityTypeModel = activityTypeDataJpaRepository.save(activityTypeModel);

        //then
        Assertions.assertNotNull(savedActivityTypeModel, "savedActivityTypeModel is null");

    }

    @Test
    public void read(){
        //given
        ActivityTypeModel activityTypeModel = new ActivityTypeModel();
        activityTypeModel.setCustom(true);
        activityTypeModel.setName(ACTIVITY_NAME_SNORKELING);
        ActivityTypeModel savedActivityTypeModel = activityTypeDataJpaRepository.save(activityTypeModel);

        //when
        Optional<ActivityTypeModel> readActivityTypeModel = activityTypeDataJpaRepository.findById(savedActivityTypeModel.getId());

        //then
        Assertions.assertNotNull(readActivityTypeModel, "readActivityTypeModel is null");

    }

    @Test
    public void update(){
        //given
        ActivityTypeModel activityTypeModel = new ActivityTypeModel();
        activityTypeModel.setCustom(true);
        activityTypeModel.setName(ACTIVITY_NAME_SNORKELING);
        ActivityTypeModel savedActivityTypeModel = activityTypeDataJpaRepository.save(activityTypeModel);
        ActivityTypeModel updateActivityTypeModel = new ActivityTypeModel();
        updateActivityTypeModel.setName(ACTIVITY_NAME_FISHING);
        updateActivityTypeModel.setId(savedActivityTypeModel.getId());

        //when
        ActivityTypeModel updatedActivityTypeModel = activityTypeDataJpaRepository.save(updateActivityTypeModel);

        //then
        Assertions.assertNotNull(updatedActivityTypeModel, "updatedActivityTypeModel is null");


    }

    @Test
    public void delete(){
        //given
        ActivityTypeModel activityTypeModel = new ActivityTypeModel();
        activityTypeModel.setCustom(true);
        activityTypeModel.setName(ACTIVITY_NAME_SNORKELING);

        //when
        ActivityTypeModel savedActivityTypeModel = activityTypeDataJpaRepository.save(activityTypeModel);
        activityTypeDataJpaRepository.delete(savedActivityTypeModel);

        //then
        //Assertions.assertNull(savedActivityTypeModel, "savedActivityTypeModel is not null");

    }
}