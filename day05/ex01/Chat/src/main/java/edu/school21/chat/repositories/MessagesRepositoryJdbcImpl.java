package edu.school21.chat.repositories;

import edu.school21.chat.models.Message;
import edu.school21.chat.models.Room;
import edu.school21.chat.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessagesRepository {
    private final DataSource dataSource;

    public MessagesRepositoryJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    private void closeConnection(PreparedStatement preparedStatement, Connection connection) throws SQLException{
        preparedStatement.close();
        connection.close();
    }

    @Override
    public Optional<Message> findById(Long id) throws SQLException {
        User user = null;
        Room room = null;
        try {
            Connection connection = dataSource.getConnection();
            String selectSQL = "SELECT id, author, room, text, date FROM chat.message WHERE id=" + id;
            PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                closeConnection(preparedStatement, connection);
                return Optional.empty();
            }
            long userId = resultSet.getLong(2);
            long roomId = resultSet.getLong(3);
            String text = resultSet.getString(4);
            Date dateTime = resultSet.getTimestamp(5);
            selectSQL = "SELECT id, login, password FROM chat.user WHERE id=" + userId;
            preparedStatement = connection.prepareStatement(selectSQL);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = new User(userId, resultSet.getString(2), resultSet.getString(3), null, null);
            }
            selectSQL = "SELECT id, name FROM chat.room WHERE id=" + roomId;
            preparedStatement = connection.prepareStatement(selectSQL);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                room = new Room(roomId, resultSet.getString(2), null, null);
            }
            Message message = new Message(id, user, room, text, dateTime);
            closeConnection(preparedStatement, connection);
            return Optional.of(message);
        } catch (SQLException e) {
            System.err.println("Error sql");
        }
        return Optional.empty();
    }
}
