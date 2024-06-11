package tn.iit.dao;

import tn.iit.model.User;
import utils.JDBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    public void save(User user) {
        try (Connection conn = JDBUtils.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(
                     "INSERT INTO user (username, lastName, email, password, role) VALUES (?, ?, ?, ?, ?)")) {
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getLastName());
            pstmt.setString(3, user.getEmail());
            pstmt.setString(4, user.getPassword());
            pstmt.setString(5, user.getRole());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User getUserById(int id) {
        User user = null;
        try (Connection conn = JDBUtils.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM user WHERE id = ?")) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    user = new User(
                            rs.getInt("id"),
                            rs.getString("username"),
                            rs.getString("lastName"),
                            rs.getString("email"),
                            rs.getString("password"),
                            rs.getString("role")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try (Connection conn = JDBUtils.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM users")) {
            while (rs.next()) {
                User user = new User(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("lastName"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("role")
                );
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public void update(User user) {
        try (Connection conn = JDBUtils.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(
                     "UPDATE user SET username = ?, lastName = ?, email = ?, password = ?, role = ? WHERE id = ?")) {
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getLastName());
            pstmt.setString(3, user.getEmail());
            pstmt.setString(4, user.getPassword());
            pstmt.setString(5, user.getRole());
            pstmt.setInt(6, user.getIdUser());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try (Connection conn = JDBUtils.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("DELETE FROM user WHERE id = ?")) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
