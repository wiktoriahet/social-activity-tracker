package pl.hetman.wiktoria.java.app.socialactivitytracker.dao.datajpa.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.hetman.wiktoria.java.app.socialactivitytracker.controller.model.ActivityTypeModel;

import java.util.Optional;

@SpringBootTest
public class ActivityTypeJpaDataRepositoryIntegrationTest {

    private static final String ACTIVITY_NAME_FISHING = "Fishing";
    private static final String ACTIVITY_NAME_SNORKELING = "Snorkeling";

    @Autowired
    private DefaultActivityTypeDataJpaRepository defaultActivityTypeDataJpaRepository;

    @Test
    public void delete(){
        //given
        ActivityTypeModel activityTypeModel = new ActivityTypeModel();
        activityTypeModel.setCustom(true);
        activityTypeModel.setName(ACTIVITY_NAME_SNORKELING);

        //when
        ActivityTypeModel savedActivityTypeModel = defaultActivityTypeDataJpaRepository.save(activityTypeModel);
        defaultActivityTypeDataJpaRepository.delete(savedActivityTypeModel);
        Optional<ActivityTypeModel> optionalReadActivityTypeModel =
                defaultActivityTypeDataJpaRepository.findById(savedActivityTypeModel.getId());
        ActivityTypeModel readActivityTypeModel = optionalReadActivityTypeModel.orElse(null);


        //then
        Assertions.assertNull(readActivityTypeModel, "savedActivityTypeModel is not null");

    }
}
