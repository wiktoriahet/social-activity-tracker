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

    @Test
    public void read(){
        //given
        UserModel userModel = new UserModel();
        UserModel savedUserModel = userJpaDataRepository.save(userModel);

        //when
        UserModel readUserModel = userJpaDataRepository.getReferenceById(savedUserModel.getId());

        //then
        Assertions.assertNotNull(readUserModel, "readUserModel is null");

    }

    @Test
    public void update(){
        //given
        UserModel userModel = new UserModel();
        UserModel savedUserModel = userJpaDataRepository.save(userModel);
        UserModel updateUserModel = new UserModel();
        updateUserModel.setId(savedUserModel.getId());

        //when
        UserModel updatedUserModel = userJpaDataRepository.save(updateUserModel);

        //then
        Assertions.assertNotNull(updatedUserModel, "updatedUserModel is null");

    }
}