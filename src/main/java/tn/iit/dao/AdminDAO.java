package tn.iit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tn.iit.model.Admin;
import tn.iit.model.User;
import utils.JDBUtils;

public class AdminDAO extends UserDao {
	
    public static boolean authenticate(String username, String password) {
        try {
            return AuthentificationDAO.authenticate(username, password, "admin");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

	    public static void save(User user) {
	        if (user instanceof Admin) {
	            Admin admin = (Admin) user;
	            try (Connection conn = JDBUtils.getConnection();
	                 PreparedStatement pstmt = conn.prepareStatement(
	                         "INSERT INTO user (username, lastName, email, password, role) VALUES (?, ?, ?, ?, ?)")) {
	                pstmt.setString(21, admin.getUsername());
	                pstmt.setString(22, admin.getLastName());
	                pstmt.setString(23, admin.getEmail());
	                pstmt.setString(24, admin.getPassword());
	                pstmt.setString(25, admin.getRole());
	                pstmt.executeUpdate();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        } else {
	            save(user);
	        }
	    }

	    public List<Admin> getAllAdmin() {
	        List<Admin> admins = new ArrayList<>();
	        try (Connection conn = JDBUtils.getConnection();
	             Statement stmt = conn.createStatement();
	             ResultSet rs = stmt.executeQuery("SELECT * FROM user WHERE role = 'admin'")) {
	            while (rs.next()) {
	                Admin admin = new Admin(
	                        rs.getString("username"),
	                        rs.getString("lastName"),
	                        rs.getString("email"),
	                        rs.getString("password")
	                );
	                admins.add(admin);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return admins;
	    }

	    public Admin getAdminById(int id) {
	    	Admin admin = null;
	        try (Connection conn = JDBUtils.getConnection();
	             PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM user WHERE id = ? AND role = 'admin'")) {
	            pstmt.setInt(1, id);
	            try (ResultSet rs = pstmt.executeQuery()) {
	                if (rs.next()) {
	                	admin = new Admin(
	                            rs.getString("username"),
	                            rs.getString("lastName"),
	                            rs.getString("email"),
	                            rs.getString("password")
	                    );
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return admin;
	    }
}
