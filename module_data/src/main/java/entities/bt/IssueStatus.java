package entities.bt;

import dao.impl.DAOImpl;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Component
public interface IssueStatus extends Entity {
    int getStatusId();
    String getValue();
    void setValue(String newValue);
    void setStatusId(int statusId);

    @Override
    default void save() throws SQLException {
        try (Connection connection = new DAOImpl().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO BT_ISSUE_STATUSES ("
                 + "STATUS_ID, VALUE) "
                 + "VALUES (?, ?);")) {
            preparedStatement.setLong(1, getStatusId());
            preparedStatement.setString(2, getValue());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    default void update() throws SQLException {
        try (Connection connection = new DAOImpl().getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement("UPDATE BT_ISSUE_STATUSES SET " +
             "VALUE = ? " +
             "WHERE STATUS_ID = ?;")) {
            preparedStatement.setString(1, getValue());
            preparedStatement.setInt(2, getStatusId());
            preparedStatement.executeUpdate();
        }
    }


    @Override
    default void delete() throws SQLException {
        try (Connection connection = new DAOImpl().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM BT_ISSUES WHERE ISSUE_ID = ?;");
            preparedStatement.setInt(1, getStatusId());
            preparedStatement.execute();
        }
    }
}