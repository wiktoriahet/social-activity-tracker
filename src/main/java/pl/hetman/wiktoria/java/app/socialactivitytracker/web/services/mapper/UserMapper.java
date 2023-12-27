package pl.hetman.wiktoria.java.app.socialactivitytracker.web.services.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import pl.hetman.wiktoria.java.app.socialactivitytracker.dao.entity.UserEntity;
import pl.hetman.wiktoria.java.app.socialactivitytracker.web.controller.model.UserModel;

import java.util.logging.Logger;

public class UserMapper {
    private static Logger LOGGER = Logger.getLogger(UserMapper.class.getName());

    public UserEntity from(UserModel userModel) {
        LOGGER.info("from(" + userModel + ")");
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);
        UserEntity mappedUserEntity = modelMapper.map(userModel, UserEntity.class);
        LOGGER.info("from()");
        return mappedUserEntity;
    }

    public UserModel from(UserEntity userEntity) {
        LOGGER.info("from(" + userEntity + ")");
        ModelMapper modelMapper = new ModelMapper();
        UserModel mappedUserModel = modelMapper.map(userEntity, UserModel.class);
        LOGGER.info("from(...)");
        return mappedUserModel;
    }
}
