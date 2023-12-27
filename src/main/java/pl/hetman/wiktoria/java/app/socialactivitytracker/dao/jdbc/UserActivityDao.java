package pl.hetman.wiktoria.java.app.socialactivitytracker.dao.jdbc;

import pl.hetman.wiktoria.java.app.socialactivitytracker.api.exception.ActivityException;
import pl.hetman.wiktoria.java.app.socialactivitytracker.api.exception.UserException;
import pl.hetman.wiktoria.java.app.socialactivitytracker.dao.entity.ActivityEntity;
import pl.hetman.wiktoria.java.app.socialactivitytracker.dao.entity.UserEntity;

import java.util.Optional;

public class UserActivityDao {
    private final UserDao userDao;
    private final DefaultActivityDao defaultActivityDao;

    public UserActivityDao(UserDao userDao, DefaultActivityDao defaultActivityDao) {
        this.userDao = userDao;
        this.defaultActivityDao = defaultActivityDao;
    }

    public void create(Long userId) throws ActivityException, UserException {
        Optional<UserEntity> optionalUserModel = userDao.read(userId);
        UserEntity userEntity = optionalUserModel.orElseThrow(
                () -> new UserException("User not found"));

        ActivityEntity activityEntity = new ActivityEntity();
//        activityModel.setUser(userModel);

        defaultActivityDao.create(activityEntity);
    }
}
