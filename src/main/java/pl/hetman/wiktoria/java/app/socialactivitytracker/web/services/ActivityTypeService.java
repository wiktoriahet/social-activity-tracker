package pl.hetman.wiktoria.java.app.socialactivitytracker.web.services;

import org.springframework.stereotype.Service;
import pl.hetman.wiktoria.java.app.socialactivitytracker.dao.entity.ActivityTypeEntity;
import pl.hetman.wiktoria.java.app.socialactivitytracker.dao.hibernate.repository.DefaultActivityRepository;

import java.util.List;
import java.util.logging.Logger;

@Service
public class ActivityTypeService {
    private static final Logger LOGGER = Logger.getLogger(ActivityTypeService.class.getName());

//    private final ActivityDao activityDao; //zależność
//
//    public ActivityTypeService(ActivityDao activityDao) { //wstrzykiwanie zależności za pomocą konstr.
//        this.activityDao = activityDao;
//    }

    private final DefaultActivityRepository defaultActivityRepository;

    public ActivityTypeService(DefaultActivityRepository defaultActivityRepository) {
        this.defaultActivityRepository = defaultActivityRepository;
    }

    // C - create
    public ActivityTypeEntity create(ActivityTypeEntity activityTypeEntity) {
        return null;
    }
    // R - read
    public ActivityTypeEntity read(Long id) {
        return null;
    }
    // U - update
    public ActivityTypeEntity update(Long id) {
        return null;
    }
    // D - delete
    public void delete(Long id) {
    }
    // L - list
    public List<ActivityTypeEntity> list() {
        return null;
    }

}
