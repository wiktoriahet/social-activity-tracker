package pl.hetman.wiktoria.java.app.socialactivitytracker.dao.datajpa.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.hetman.wiktoria.java.app.socialactivitytracker.controller.model.UserModel;

@SpringBootTest
class DefaultUserJpaDataRepositoryTest {

    private static final String ACTIVITY_NAME_FISHING = "Fishing";
    private static final String ACTIVITY_NAME_SNORKELING = "Snorkeling";

    @Autowired
    private DefaultUserJpaDataRepository defaultUserJpaDataRepository;

    @Test
    public void create() {
        //given
        UserModel userModel = new UserModel();
//        ActivityModel activityModel = new ActivityModel();
//        activityModel.setLabel(ACTIVITY_NAME_SNORKELING);
//        userModel.setActivityModel(activityModel);
        //hibernate onetoone!!!!

        //when
        UserModel savedUserModel = defaultUserJpaDataRepository.save(userModel);

        //then
        Assertions.assertNotNull(savedUserModel, "savedUserModel is null");

    }

    @Test
    public void read(){
        //given
        UserModel userModel = new UserModel();
        UserModel savedUserModel = defaultUserJpaDataRepository.save(userModel);

        //when
        UserModel readUserModel = defaultUserJpaDataRepository.getReferenceById(savedUserModel.getId());

        //then
        Assertions.assertNotNull(readUserModel, "readUserModel is null");

    }

    @Test
    public void update(){
        //given
        UserModel userModel = new UserModel();
        UserModel savedUserModel = defaultUserJpaDataRepository.save(userModel);
        UserModel updateUserModel = new UserModel();
        updateUserModel.setId(savedUserModel.getId());

        //when
        UserModel updatedUserModel = defaultUserJpaDataRepository.save(updateUserModel);

        //then
        Assertions.assertNotNull(updatedUserModel, "updatedUserModel is null");

    }
}