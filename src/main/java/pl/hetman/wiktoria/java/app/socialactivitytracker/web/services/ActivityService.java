package pl.hetman.wiktoria.java.app.socialactivitytracker.web.services;

import org.springframework.stereotype.Service;
import pl.hetman.wiktoria.java.app.socialactivitytracker.api.exception.ActivityException;
import pl.hetman.wiktoria.java.app.socialactivitytracker.dao.entity.ActivityEntity;
import pl.hetman.wiktoria.java.app.socialactivitytracker.dao.hibernate.repository.DefaultActivityRepository;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class ActivityService {

    private static final Logger LOGGER = Logger.getLogger(ActivityService.class.getName());

//    private final ActivityDao activityDao; //zależność
//
//    public ActivityService(ActivityDao activityDao) { //wstrzykiwanie zależności za pomocą konstr.
//        this.activityDao = activityDao;
//    }

    private final DefaultActivityRepository defaultActivityRepository;

    public ActivityService(DefaultActivityRepository defaultActivityRepository) {
        this.defaultActivityRepository = defaultActivityRepository;
    }

    // C - create
    public ActivityEntity create(ActivityEntity activityEntity) throws ActivityException {
        LOGGER.info("create(" + activityEntity + ")");
        Optional<ActivityEntity> optionalActivityModel =
                //activityDao.create(activityModel); //delegacja
                defaultActivityRepository.create(activityEntity);
        ActivityEntity createdActivityEntity = optionalActivityModel.orElseThrow(
                () -> new ActivityException("Unable to create activity"));

        LOGGER.info("create(...) = " + createdActivityEntity);
        return createdActivityEntity;
    }

    // R - read
    public ActivityEntity read(Long id) {
        return null;
    }

    // U - update
    public ActivityEntity update(Long id, ActivityEntity activityEntity) {
        return null;
    }

    // D - delete
    public void delete(Long id) {
    }

    // L - list
    public List<ActivityEntity> list() {
        return null;
    }

}