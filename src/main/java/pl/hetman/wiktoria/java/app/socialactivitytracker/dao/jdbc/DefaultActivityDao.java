package pl.hetman.wiktoria.java.app.socialactivitytracker.dao.jdbc;

import org.springframework.stereotype.Component;
import pl.hetman.wiktoria.java.app.socialactivitytracker.api.exception.ActivityException;
import pl.hetman.wiktoria.java.app.socialactivitytracker.dao.entity.ActivityEntity;
import pl.hetman.wiktoria.java.app.socialactivitytracker.dao.entity.ActivityTypeEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLNonTransientConnectionException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class DefaultActivityDao implements DefaultDao<ActivityEntity> {

    private static final Logger LOGGER = Logger.getLogger(DefaultActivityDao.class.getName());

    private UserDao userDao;

    public DefaultActivityDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Optional<ActivityEntity> create(ActivityEntity activityEntity) throws ActivityException {

        LOGGER.info("create(" + activityEntity + ")");
        String queryString = "INSERT INTO ACTIVITIES" +
//                "(id, name, custom, label, start, stop, duration, user_id)" +
//                " VALUES(?,?,?,?,?,?,?,?)";
                "(id, name, custom, label, start, stop, duration)" +
                " VALUES(?,?,?,?,?,?,?)";
        Long generatedId = UniqueIdGenerator.generateId();
        //UserModel userModel = activityModel.getUser();
        //Long userId = userModel.getId();
        // <--- nie działa, stworzyliśmy na przyszłość do hibernate, ale jest nullowy teraz,
        // więc wszystko się sypnęło, (chcemy, żeby aktywność zapisała użytkownika)
        // póki co to wykomentowałam i testy działają


        try (Connection connection = ConnectionManager.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(queryString)) {
            //try-with-resource

            preparedStatement.setLong(1, generatedId);
            if (activityEntity.getActivityType() != null) {
                preparedStatement.setString(2, activityEntity.getActivityType().getName());
                preparedStatement.setString(3, String.valueOf(activityEntity.getActivityType().isCustom()));
            } else {
                preparedStatement.setString(2, null);
                preparedStatement.setString(3, null);
            }
            preparedStatement.setString(4, activityEntity.getLabel());
            if (activityEntity.getStart() != null) {
                preparedStatement.setString(5, activityEntity.getStart().toString());
            } else {
                preparedStatement.setString(5, null);
            }
            preparedStatement.setString(6, null);
            preparedStatement.setString(7, activityEntity.getDuration());
            preparedStatement.executeUpdate();
        } catch (RuntimeException e) {
            throw new ActivityException("General database problem while creating activity", e);
        } catch (SQLNonTransientConnectionException e) {
            LOGGER.log(Level.SEVERE, "SQL Database problem while creating activity", e);
            throw new ActivityException("SQL Database problem while creating activity", e);
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Database problem while creating activity", e);
            throw new ActivityException("Database problem while creating activity", e);
        }

        activityEntity.setId(generatedId);
        Optional<ActivityEntity> optionalActivityModel = Optional.of(activityEntity);
        LOGGER.info("create(...)=" + optionalActivityModel);
        return optionalActivityModel;
    }

    @Override
    public void update(ActivityEntity activityEntity) throws ActivityException {

        LOGGER.info("update(" + activityEntity + ")");

        String queryString = "UPDATE ACTIVITIES " +
                "SET name = ?," +
                "custom = ?," +
                "label = ?," +
                "start = ?," +
                "stop = ?," +
                "duration = ?" +
                "WHERE id = ?";

        try (Connection connection = ConnectionManager.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(queryString)) {

            if (activityEntity != null) {
                if (activityEntity.getActivityType() != null) {
                    preparedStatement.setString(1, activityEntity.getActivityType().getName());
                    preparedStatement.setString(2, String.valueOf(activityEntity.getActivityType().isCustom()));
                } else {
                    preparedStatement.setString(1, null);
                    preparedStatement.setString(2, null);
                }
                preparedStatement.setString(3, activityEntity.getLabel());
                if (activityEntity.getStart() != null) {
                    preparedStatement.setString(4, activityEntity.getStart().toString());
                } else {
                    preparedStatement.setString(4, null);
                }
                if (activityEntity.getStop() != null) {
                    preparedStatement.setString(5, activityEntity.getStop().toString());
                } else {
                    preparedStatement.setString(5, null);
                }
                preparedStatement.setString(6, activityEntity.getDuration());
                preparedStatement.setLong(7, activityEntity.getId());
                preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Database problem during update", e);
        }

        LOGGER.info("update(...)");
    }

    @Override
    public void delete(ActivityEntity activityEntity) throws ActivityException {

        LOGGER.info("delete(" + activityEntity + ")");

        String queryString = "DELETE ACTIVITIES " +
                "WHERE id = ?";

        try (Connection connection = ConnectionManager.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(queryString)) {

            preparedStatement.setLong(1, activityEntity.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Database problem while deleting activity", e);
        }
        LOGGER.info("delete(...)");
    }

    @Override
    public Optional<ActivityEntity> read(Long id) throws ActivityException {

        LOGGER.info("read(" + id + ")");

        String queryString = "SELECT * FROM ACTIVITIES WHERE id = ?;";

        try (Connection connection = ConnectionManager.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(queryString)) {

            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            userDao.read(id);

            if (resultSet.next()) {
                Long readId = resultSet.getLong("ID");
                String name = resultSet.getString("NAME");
                String custom = resultSet.getString("CUSTOM");
                String label = resultSet.getString("LABEL");

                ActivityEntity activityEntity = new ActivityEntity();
                activityEntity.setId(readId);
                activityEntity.setLabel(label);

                LOGGER.info("read(...)");

                return Optional.of(activityEntity);
            }

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Database problem while reading from database", e);
        }
        LOGGER.info("read(...)");
        return Optional.empty();

    }

    @Override
    public List<ActivityEntity> list() throws ActivityException {
        LOGGER.info("list()");

        List<ActivityEntity> activityEntities = new ArrayList<>();
        String queryString = "SELECT * FROM ACTIVITIES;";

        try (Connection connection = ConnectionManager.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(queryString)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                ActivityTypeEntity activityTypeEntity = new ActivityTypeEntity();
                ActivityEntity activityEntity = new ActivityEntity();

                activityEntity.setId(resultSet.getLong(1));
                activityTypeEntity.setName(resultSet.getString(2));
                activityTypeEntity.setCustom(resultSet.getBoolean(3));
                activityEntity.chooseActivityType(activityTypeEntity);
                activityEntities.add(activityEntity);
            }

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Database problem while listing activities", e);
        }

        LOGGER.info("list(...)" + activityEntities);

        return activityEntities;
    }
}
