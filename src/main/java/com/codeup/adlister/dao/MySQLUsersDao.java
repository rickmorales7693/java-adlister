package com.codeup.adlister.dao;

import Utils.Config;
import com.codeup.adlister.models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

public abstract class MySQLUsersDao implements Users {
    private Connection connection = null;

    public MySQLUsersDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver() {
                @Override
                public Connection connect(String url, Properties info) throws SQLException {
                    return null;
                }

                @Override
                public boolean acceptsURL(String url) throws SQLException {
                    return false;
                }

                @Override
                public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
                    return new DriverPropertyInfo[0];
                }

                @Override
                public int getMajorVersion() {
                    return 0;
                }

                @Override
                public int getMinorVersion() {
                    return 0;
                }

                @Override
                public boolean jdbcCompliant() {
                    return false;
                }

                @Override
                public Logger getParentLogger() throws SQLFeatureNotSupportedException {
                    return null;
                }
            });
            connection = DriverManager.getConnection(
                config.getUrl(),
                config.getUser(),
                config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public User getUserById(long id) {
        String query = "SELECT * FROM users WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new User(
                        rs.getLong("id"),
                        rs.getString("username"),
                        rs.getString("email")
                );
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException("Error finding user by id.", e);
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM users";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                users.add(new User(
                        rs.getLong("id"),
                        rs.getString("username"),
                        rs.getString("email")
                ));
            }
            return users;
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all users.", e);
        }
    }

    @Override
    public long insertUser(User user) {
        String insertQuery = "INSERT INTO users(username, email, password) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(insertQuery)) {
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                return rs.getLong(1);
            }
            return -1;
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new user.", e);
        }
    }
}

