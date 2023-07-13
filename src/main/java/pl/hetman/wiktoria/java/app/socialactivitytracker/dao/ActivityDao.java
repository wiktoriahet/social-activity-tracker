package pl.hetman.wiktoria.java.app.socialactivitytracker.dao;

import org.h2.mvstore.MVStoreException;
import pl.hetman.wiktoria.java.app.socialactivitytracker.api.exception.ActivityException;
import pl.hetman.wiktoria.java.app.socialactivitytracker.controller.model.ActivityModel;
import pl.hetman.wiktoria.java.app.socialactivitytracker.controller.model.ActivityTypeModel;
import pl.hetman.wiktoria.java.app.socialactivitytracker.controller.model.UserModel;

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

public class ActivityDao implements Dao<ActivityModel> {

    private static final Logger LOGGER = Logger.getLogger(ActivityDao.class.getName());
    // TODO: 10.07.2023 implementacja zależnością? + wstrzykiwanie zależności w konstruktorze
    private final UserDao userDao;

    public ActivityDao(UserDao userDao){
        this.userDao = userDao;
    }

    @Override
    public Optional<ActivityModel> create(ActivityModel activityModel) throws ActivityException {

        LOGGER.info("create(" + activityModel + ")");

        // TODO: 10.07.2023 UserDao metoda create, ale czemu tutaj? czy user nie powinien byc juz na tym etapie stworzony?
        // user zalogowany, sprawdzony czy istnieje, i tu juz te dane zapisane na indywidualnym koncie usera?


        //Connection connection = null;
        //PreparedStatement preparedStatement = null;
        String queryString = "INSERT INTO ACTIVITIES" +
                "(id, name, custom, label, start, stop, duration, user_id)" +
                " VALUES(?,?,?,?,?,?,?,?)";
        Long generatedId = UniqueIdGenerator.generateId();

        // TODO: 10.07.2023 delegacja?
        //Optional<ActivityModel> optionalUserDao = userDao.create(activityModel);
        UserModel userModel = activityModel.getUser();
        Long userId = userModel.getId();

        try (Connection connection = ConnectionManager.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(queryString)) {
            //try-with-resource

            preparedStatement.setLong(1, generatedId);
            if (activityModel.getActivityType() != null) {
                preparedStatement.setString(2, activityModel.getActivityType().getName());
                preparedStatement.setString(3, String.valueOf(activityModel.getActivityType().isCustom()));
            } else {
                preparedStatement.setString(2, null);
                preparedStatement.setString(3, null);
            }
            preparedStatement.setString(4, activityModel.getLabel());
            if (activityModel.getStart() != null) {
                preparedStatement.setString(5, activityModel.getStart().toString());
            } else {
                preparedStatement.setString(5, null);
            }
            preparedStatement.setString(6, null);
            preparedStatement.setString(7, activityModel.getDuration());
            preparedStatement.executeUpdate();
        } catch (RuntimeException e) {
            //e.printStackTrace();
//            LOGGER.log(Level.SEVERE, "General database problem while creating activity", e);
            throw new ActivityException("General database problem while creating activity", e);
        } catch (SQLNonTransientConnectionException e) {
            LOGGER.log(Level.SEVERE, "SQL Database problem while creating activity", e);
            throw new ActivityException("SQL Database problem while creating activity", e);
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Database problem while creating activity", e);
            throw new ActivityException("Database problem while creating activity", e);
        }

        activityModel.setId(generatedId);
        Optional<ActivityModel> optionalActivityModel = Optional.of(activityModel);
        LOGGER.info("create(...)=" + optionalActivityModel);
        return optionalActivityModel;
    }
//    @Override
//    public ActivityModel create(ActivityModel activityModel) {
//        //Connection connection = null;
//        //PreparedStatement preparedStatement = null;
//        String queryString = "INSERT INTO ACTIVITIES" +
//                "(id, name, custom, label, start, stop, duration)" +
//                " VALUES(?,?,?,?,?,?,?)";
//        Long generatedId = UniqueIdGenerator.generateId();
//        try (Connection connection = ConnectionManager.getInstance().getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(queryString);) {
//            //try-with-resource
//
//            preparedStatement.setLong(1, generatedId);
//            if(activityModel.getActivityType() !=null) {
//                preparedStatement.setString(2, activityModel.getActivityType().getName());
//                preparedStatement.setString(3, String.valueOf(activityModel.getActivityType().isCustom()));
//            } else {
//                preparedStatement.setString(2, null);
//                preparedStatement.setString(3, null);
//            }
//            preparedStatement.setString(4, activityModel.getLabel());
//            if(activityModel.getStart() !=null) {
//                preparedStatement.setString(5, activityModel.getStart().toString());
//            } else {
//                preparedStatement.setString(5, null);
//            }
//            preparedStatement.setString(6, null);
//            preparedStatement.setString(7, activityModel.getDuration());
//            preparedStatement.executeUpdate();
//            System.out.println("Data saved");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        activityModel.setId(generatedId);
//        return activityModel;
//    }

    @Override
    public void update(ActivityModel activityModel) throws ActivityException{

        LOGGER.info("update(" + activityModel + ")");

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

            if (activityModel != null) {
                if (activityModel.getActivityType() != null) {
                    preparedStatement.setString(1, activityModel.getActivityType().getName());
                    preparedStatement.setString(2, String.valueOf(activityModel.getActivityType().isCustom()));
                } else {
                    preparedStatement.setString(1, null);
                    preparedStatement.setString(2, null);
                }
                preparedStatement.setString(3, activityModel.getLabel());
                if (activityModel.getStart() != null) {
                    preparedStatement.setString(4, activityModel.getStart().toString());
                } else {
                    preparedStatement.setString(4, null);
                }
                if (activityModel.getStop() != null) {
                    preparedStatement.setString(5, activityModel.getStop().toString());
                } else {
                    preparedStatement.setString(5, null);
                }
                preparedStatement.setString(6, activityModel.getDuration());
                preparedStatement.setLong(7, activityModel.getId());
                preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Database problem during update", e);
//            e.printStackTrace();
        }

        LOGGER.info("update(...)");
    }

    @Override
    public void delete(ActivityModel activityModel) throws ActivityException {

        LOGGER.info("delete(" + activityModel + ")");

        String queryString = "DELETE ACTIVITIES " +
                "WHERE id = ?";

        try (Connection connection = ConnectionManager.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(queryString)) {

            preparedStatement.setLong(1, activityModel.getId());
            preparedStatement.executeUpdate();

            //System.out.println("Data deleted");

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Database problem while deleting activity", e);
//            e.printStackTrace();
        }

        LOGGER.info("delete(...)");

    }

    @Override
    public Optional<ActivityModel> read(Long id) throws ActivityException{

        LOGGER.info("read(" + id + ")");

        String queryString = "SELECT * FROM ACTIVITIES WHERE id = ?;";

        try (Connection connection = ConnectionManager.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(queryString)) {

            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Long readId = resultSet.getLong("ID");
                String name = resultSet.getString("NAME");
                String custom = resultSet.getString("CUSTOM");
                String label = resultSet.getString("LABEL");

                ActivityModel activityModel = new ActivityModel();
                activityModel.setId(readId);
                activityModel.setLabel(label);

                LOGGER.info("read(...)");

                return Optional.of(activityModel);
            }

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Database problem while reading from database", e);
//            e.printStackTrace();
        }
        LOGGER.info("read(...)");
        return Optional.empty();

    }

    @Override
    public List<ActivityModel> list() throws ActivityException{
        LOGGER.info("list()");

        List<ActivityModel> activityModels = new ArrayList<>();
        String queryString = "SELECT * FROM ACTIVITIES;";

        try (Connection connection = ConnectionManager.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(queryString)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                ActivityTypeModel activityTypeModel = new ActivityTypeModel();
                ActivityModel activityModel = new ActivityModel();

                activityModel.setId(resultSet.getLong(1));
                activityTypeModel.setName(resultSet.getString(2));
                activityTypeModel.setCustom(resultSet.getBoolean(3));
                activityModel.chooseActivityType(activityTypeModel);
                activityModels.add(activityModel);
            }

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Database problem while listing activities", e);
        }

        LOGGER.info("list(...)" + activityModels);

        return activityModels;
    }
}
