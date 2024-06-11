package tn.iit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utils.JDBUtils;

public class AuthentificationDAO {
	public static boolean authenticate(String username, String password, String role) throws SQLException {
	    // Get the connection from the JDBUtils
	    Connection connection = JDBUtils.getConnection();

	    // Check if the connection is null
	    if (connection == null) {
	        throw new SQLException("Failed to establish a database connection.");
	    }

	    // Use try-with-resources to ensure proper resource management
	    String query = "SELECT * FROM user WHERE username = ? AND password = ? AND role = ?";
	    try (PreparedStatement pstmt = connection.prepareStatement(query)) {
	        pstmt.setString(1, username);
	        pstmt.setString(2, password);
	        pstmt.setString(3, role);

	        try (ResultSet rs = pstmt.executeQuery()) {
	            return rs.next(); // Si une correspondance est trouvée, l'authentification est réussie
	        }
	    }
	}


	public static String getRole(String username) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String role = null;
		try {
			pstmt = JDBUtils.getConnection().prepareStatement("SELECT role FROM user WHERE username = ?");
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				role = rs.getString("role");
			}
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
		}
		return role;
	}

}
