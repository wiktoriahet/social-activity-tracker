package pl.hetman.wiktoria.java.app.socialactivitytracker.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class ActivityDao implements Dao<ActivityModel> {
    // TODO: 06.04.2023 dokonczyc implementacje actDao, delete i update + read

    @Override
    public void save(ActivityModel activityModel) {
        //Connection connection = null;
        //PreparedStatement preparedStatement = null;
        String queryString = "INSERT INTO activitymodel" +
                "(name, custom, label, start, stop, duration)" +
                " VALUES(?,?,?,?,?,?)";
        try (Connection connection = ConnectionManager.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(queryString);) {
            //try-with-resource

            preparedStatement.setString(1, activityModel.getActivityType().getName());
            preparedStatement.setString(2, String.valueOf(activityModel.getActivityType().isCustom()));
            preparedStatement.setString(3, activityModel.getLabel());
            preparedStatement.setString(4, activityModel.getStart().toString());
            preparedStatement.setString(5, null);
            preparedStatement.setString(6, activityModel.getDuration());
            preparedStatement.executeUpdate();
            System.out.println("Data saved");
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        finally {
//            try {
//                if (preparedStatement != null) {
//                    preparedStatement.close();
//                }
//                if (connection != null) {
//                    connection.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }

    }

    @Override
    public void update(ActivityModel activityModel, String oldName) {

        String queryString = "UPDATE activitymodel " +
                "SET name = ?," +
                "custom = ?," +
                "label = ?," +
                "start = ?," +
                "stop = ?," +
                "duration = ?" +
                "WHERE name = ?";

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
                preparedStatement.setString(7, oldName);
                preparedStatement.executeUpdate();

                System.out.println("Data updated");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    // TODO: 13.04.2023 dostosować dao do nowej kolumny id (już nie operujemy na kolumnie name tylko id)

    @Override
    public void delete(ActivityModel activityModel, String name) {
        String queryString = "DELETE activitymodel " +
                "WHERE name = '" + name + "'";

        try (Connection connection = ConnectionManager.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(queryString)) {

            preparedStatement.executeUpdate();

            System.out.println("Data deleted");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void read(ActivityModel activityModel, String name) {


        String queryString = "SELECT * FROM activitymodel WHERE name = '" + name + "'";

        try (Connection connection = ConnectionManager.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(queryString)) {

            ResultSet resultSet = null;
            resultSet = preparedStatement.executeQuery();
            ResultSetMetaData rsmd = resultSet.getMetaData();

            int columnNumber = rsmd.getColumnCount();

            while (resultSet.next()) {

                for (int i = 1; i <= columnNumber; i++) {
                    System.out.println(resultSet.getString(i));
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
