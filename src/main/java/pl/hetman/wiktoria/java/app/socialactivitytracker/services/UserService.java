package pl.hetman.wiktoria.java.app.socialactivitytracker.services;

import pl.hetman.wiktoria.java.app.socialactivitytracker.controller.model.UserModel;
import pl.hetman.wiktoria.java.app.socialactivitytracker.dao.hibernate.repository.ActivityRepository;

import java.util.List;
import java.util.logging.Logger;

public class UserService {
    private static final Logger LOGGER = Logger.getLogger(UserService.class.getName());

//    private final ActivityDao activityDao; //zależność
//
//    public UserService(ActivityDao activityDao) { //wstrzykiwanie zależności za pomocą konstr.
//        this.activityDao = activityDao;
//    }

    private final ActivityRepository activityRepository;

    public UserService(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    // C - create
    public UserModel create(UserModel userModel) {
        return null;
    }
    // R - read
    public UserModel read(Long id) {
        return null;
    }
    // U - update
    public UserModel update(Long id) {
        return null;
    }
    // D - delete
    public void delete(Long id) {
    }
    // L - list
    public List<UserModel> list() {
        return null;
    }
}
