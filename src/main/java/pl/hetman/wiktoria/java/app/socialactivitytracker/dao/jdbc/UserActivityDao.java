package pl.hetman.wiktoria.java.app.socialactivitytracker.dao.jdbc;

import pl.hetman.wiktoria.java.app.socialactivitytracker.api.exception.ActivityException;
import pl.hetman.wiktoria.java.app.socialactivitytracker.api.exception.UserException;
import pl.hetman.wiktoria.java.app.socialactivitytracker.controller.model.ActivityModel;
import pl.hetman.wiktoria.java.app.socialactivitytracker.controller.model.UserModel;

import java.util.Optional;

public class UserActivityDao {
    private final UserDao userDao;
    private final DefaultActivityDao defaultActivityDao;

    public UserActivityDao(UserDao userDao, DefaultActivityDao defaultActivityDao) {
        this.userDao = userDao;
        this.defaultActivityDao = defaultActivityDao;
    }

    public void create(Long userId) throws ActivityException, UserException {
        Optional<UserModel> optionalUserModel = userDao.read(userId);
        UserModel userModel = optionalUserModel.orElseThrow(
                () -> new UserException("User not found"));

        ActivityModel activityModel = new ActivityModel();
//        activityModel.setUser(userModel);

        defaultActivityDao.create(activityModel);
    }
}
