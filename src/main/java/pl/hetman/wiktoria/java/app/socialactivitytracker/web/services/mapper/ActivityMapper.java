package pl.hetman.wiktoria.java.app.socialactivitytracker.web.services.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import pl.hetman.wiktoria.java.app.socialactivitytracker.dao.entity.ActivityEntity;
import pl.hetman.wiktoria.java.app.socialactivitytracker.web.controller.model.ActivityModel;

import java.util.logging.Logger;

@Component
public class ActivityMapper {
    private static Logger LOGGER = Logger.getLogger(ActivityMapper.class.getName());

    public ActivityEntity from(ActivityModel activityModel) {
        LOGGER.info("from(" + activityModel + ")");
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);
        ActivityEntity mappedActivityEntity = modelMapper.map(activityModel, ActivityEntity.class);
        LOGGER.info("from()");
        return mappedActivityEntity;
    }

    public ActivityModel from(ActivityEntity activityEntity) {
        LOGGER.info("from(" + activityEntity + ")");
        ModelMapper modelMapper = new ModelMapper();
        ActivityModel mappedBookModel = modelMapper.map(activityEntity, ActivityModel.class);
        LOGGER.info("from(...)");
        return mappedBookModel;
    }
}
