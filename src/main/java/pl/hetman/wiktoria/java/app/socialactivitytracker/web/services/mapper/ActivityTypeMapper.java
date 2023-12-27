package pl.hetman.wiktoria.java.app.socialactivitytracker.web.services.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import pl.hetman.wiktoria.java.app.socialactivitytracker.dao.entity.ActivityTypeEntity;
import pl.hetman.wiktoria.java.app.socialactivitytracker.web.controller.model.ActivityTypeModel;

import java.util.logging.Logger;

public class ActivityTypeMapper {
    private static Logger LOGGER = Logger.getLogger(ActivityTypeMapper.class.getName());

    public ActivityTypeEntity from(ActivityTypeModel activityTypeModel) {
        LOGGER.info("from(" + activityTypeModel + ")");
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);
        ActivityTypeEntity mappedActivityTypeEntity = modelMapper.map(activityTypeModel, ActivityTypeEntity.class);
        LOGGER.info("from()");
        return mappedActivityTypeEntity;
    }

    public ActivityTypeModel from(ActivityTypeEntity activityTypeEntity) {
        LOGGER.info("from(" + activityTypeEntity + ")");
        ModelMapper modelMapper = new ModelMapper();
        ActivityTypeModel mappedActivityTypeModel = modelMapper.map(activityTypeEntity, ActivityTypeModel.class);
        LOGGER.info("from(...)");
        return mappedActivityTypeModel;
    }
}
