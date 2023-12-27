package pl.hetman.wiktoria.java.app.socialactivitytracker.web.services;

import pl.hetman.wiktoria.java.app.socialactivitytracker.dao.entity.UserEntity;
import pl.hetman.wiktoria.java.app.socialactivitytracker.dao.hibernate.repository.DefaultActivityRepository;

import java.util.List;
import java.util.logging.Logger;

public class UserService {
    private static final Logger LOGGER = Logger.getLogger(UserService.class.getName());

//    private final ActivityDao activityDao; //zależność
//
//    public UserService(ActivityDao activityDao) { //wstrzykiwanie zależności za pomocą konstr.
//        this.activityDao = activityDao;
//    }

    private final DefaultActivityRepository defaultActivityRepository;

    public UserService(DefaultActivityRepository defaultActivityRepository) {
        this.defaultActivityRepository = defaultActivityRepository;
    }

    // C - create
    public UserEntity create(UserEntity userEntity) {
        return null;
    }
    // R - read
    public UserEntity read(Long id) {
        return null;
    }
    // U - update
    public UserEntity update(Long id) {
        return null;
    }
    // D - delete
    public void delete(Long id) {
    }
    // L - list
    public List<UserEntity> list() {
        return null;
    }
}
