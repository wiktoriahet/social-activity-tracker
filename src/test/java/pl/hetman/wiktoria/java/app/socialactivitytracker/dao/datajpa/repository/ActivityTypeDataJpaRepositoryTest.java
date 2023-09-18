package pl.hetman.wiktoria.java.app.socialactivitytracker.dao.datajpa.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.hetman.wiktoria.java.app.socialactivitytracker.controller.model.ActivityTypeModel;

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
        ActivityTypeModel readActivityTypeModel = activityTypeDataJpaRepository.getReferenceById(savedActivityTypeModel.getId());

        //then
        Assertions.assertNotNull(readActivityTypeModel, "readActivityTypeModel is null");

    }

    @Test
    public void update(){

    }

    @Test
    public void delete(){

    }
}