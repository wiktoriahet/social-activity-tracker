package pl.hetman.wiktoria.java.app.socialactivitytracker.dao.datajpa.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.hetman.wiktoria.java.app.socialactivitytracker.controller.model.ActivityModel;
import pl.hetman.wiktoria.java.app.socialactivitytracker.controller.model.ActivityTypeModel;
import pl.hetman.wiktoria.java.app.socialactivitytracker.controller.model.UserModel;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserJpaDataRepositoryTest {

    private static final String ACTIVITY_NAME_FISHING = "Fishing";
    private static final String ACTIVITY_NAME_SNORKELING = "Snorkeling";

    @Autowired
    private UserJpaDataRepository userJpaDataRepository;

    @Test
    public void create() {
        //given
        UserModel userModel = new UserModel();
//        ActivityModel activityModel = new ActivityModel();
//        activityModel.setLabel(ACTIVITY_NAME_SNORKELING);
//        userModel.setActivityModel(activityModel);
        //hibernate onetoone!!!!

        //when
        UserModel savedUserModel = userJpaDataRepository.save(userModel);

        //then
        Assertions.assertNotNull(savedUserModel, "savedUserModel is null");

    }
}