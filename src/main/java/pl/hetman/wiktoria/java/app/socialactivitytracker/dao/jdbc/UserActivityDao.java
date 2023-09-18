package pl.hetman.wiktoria.java.app.socialactivitytracker.dao.jdbc;

import pl.hetman.wiktoria.java.app.socialactivitytracker.api.exception.ActivityException;
import pl.hetman.wiktoria.java.app.socialactivitytracker.api.exception.UserException;
import pl.hetman.wiktoria.java.app.socialactivitytracker.controller.model.ActivityModel;
import pl.hetman.wiktoria.java.app.socialactivitytracker.controller.model.UserModel;

import java.util.Optional;

public class UserActivityDao {
    private final UserDao userDao;
    private final ActivityDao activityDao;

    public UserActivityDao(UserDao userDao, ActivityDao activityDao) {
        this.userDao = userDao;
        this.activityDao = activityDao;
    }

    public void create(Long userId) throws ActivityException, UserException {
        Optional<UserModel> optionalUserModel = userDao.read(userId);
        UserModel userModel = optionalUserModel.orElseThrow(
                () -> new UserException("User not found"));

        ActivityModel activityModel = new ActivityModel();
        activityModel.setUser(userModel);

        activityDao.create(activityModel);
    }
}
