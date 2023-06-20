package pl.hetman.wiktoria.java.app.socialactivitytracker.dao;

import org.h2.mvstore.MVStoreException;
import pl.hetman.wiktoria.java.app.socialactivitytracker.api.exception.ActivityException;
import pl.hetman.wiktoria.java.app.socialactivitytracker.controller.model.ActivityModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLNonTransientConnectionException;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ActivityDao implements Dao<ActivityModel> {
    // TODO: 20.06.2023 zmieniłam printstacki na loggery
    private static final Logger LOGGER = Logger.getLogger(ActivityDao.class.getName());

    @Override
    public Optional<ActivityModel> create(ActivityModel activityModel) throws ActivityException{

        LOGGER.info("create(" + activityModel + ")");

        //Connection connection = null;
        //PreparedStatement preparedStatement = null;
        String queryString = "INSERT INTO ACTIVITIES" +
                "(id, name, custom, label, start, stop, duration)" +
                " VALUES(?,?,?,?,?,?,?)";
        Long generatedId = UniqueIdGenerator.generateId();
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

    //pozmieniać printstacki na loggery
    @Override
    public void update(ActivityModel activityModel) {

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
    public void delete(ActivityModel activityModel) {

        LOGGER.info("delete("+activityModel+")");

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
    public Optional<ActivityModel> read(Long id) {

        LOGGER.info("read("+id+")");

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

    // TODO: 12.06.2023 dorobić? czy powinno być optionalem?
    @Override
    public List<ActivityModel> list(ActivityModel activityModel) {
        LOGGER.info("list(" + activityModel + ")");

//list nie powinno przyjmować parametrów, ale może będzie musiała jakiś przyjąć


        LOGGER.info("list(...)");
        return null;
    }
}
