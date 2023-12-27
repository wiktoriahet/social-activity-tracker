package pl.hetman.wiktoria.java.app.socialactivitytracker.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.hetman.wiktoria.java.app.socialactivitytracker.controller.model.UserModel;
import pl.hetman.wiktoria.java.app.socialactivitytracker.dao.jdbc.UserDao;

import java.util.Optional;

@SpringBootTest
class DefaultUserDaoSpringTest {

    @Autowired
    private UserDao userDao;

    @Test
    void create() {
        //given
        UserModel userModel = new UserModel();

        //when
        Optional<UserModel> optionalUserModel = userDao.create(userModel);

        //then
        Assertions.assertNotNull(optionalUserModel, "optionalUserModel is null");

    }
}