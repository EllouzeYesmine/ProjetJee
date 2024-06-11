package tn.iit.dao;

import tn.iit.model.Teacher;
import tn.iit.model.User;
import utils.JDBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EnseignantDAO extends UserDao {
    public static boolean authenticate(String username, String password) {
        try {
            // Utiliser le DAO AuthentificationDAO pour authentifier l'utilisateur
            return AuthentificationDAO.authenticate(username, password, "enseignant");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

	    public static void save(User user) {
	        if (user instanceof Teacher) {
	            Teacher enseignant = (Teacher) user;
	            try (Connection conn = JDBUtils.getConnection();
	                 PreparedStatement pstmt = conn.prepareStatement(
	                         "INSERT INTO users (username, lastName, email, password, role) VALUES (?, ?, ?, ?, ?)")) {
	                pstmt.setString(1, enseignant.getUsername());
	                pstmt.setString(2, enseignant.getLastName());
	                pstmt.setString(3, enseignant.getEmail());
	                pstmt.setString(4, enseignant.getPassword());
	                pstmt.setString(5, enseignant.getRole());
	                pstmt.executeUpdate();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        } else {
	            save(user);
	        }
	    }

	    public List<Teacher> getAllEnseignants() {
	        List<Teacher> enseignants = new ArrayList<>();
	        try (Connection conn = JDBUtils.getConnection();
	             Statement stmt = conn.createStatement();
	             ResultSet rs = stmt.executeQuery("SELECT * FROM user WHERE role = 'enseignant'")) {
	            while (rs.next()) {
	                Teacher enseignant = new Teacher(
	                        rs.getString("username"),
	                        rs.getString("lastName"),
	                        rs.getString("email"),
	                        rs.getString("password")
	                );
	                enseignants.add(enseignant);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return enseignants;
	    }

	    public Teacher getEnseignantById(int id) {
	        Teacher enseignant = null;
	        try (Connection conn = JDBUtils.getConnection();
	             PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM user WHERE id = ? AND role = 'enseignant'")) {
	            pstmt.setInt(1, id);
	            try (ResultSet rs = pstmt.executeQuery()) {
	                if (rs.next()) {
	                    enseignant = new Teacher(
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
	        return enseignant;
	    }
}
