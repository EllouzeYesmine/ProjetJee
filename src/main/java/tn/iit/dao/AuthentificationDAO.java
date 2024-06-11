package tn.iit.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utils.JDBUtils;

public class AuthentificationDAO {
	public static boolean authenticate(String username, String password, String role) throws SQLException {
        PreparedStatement pstmt;
        ResultSet rs = null;
        try {
        	pstmt = JDBUtils.getConnection().prepareStatement(
        		    "SELECT * FROM user WHERE username = ? AND password = ? AND role = ?");
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, role);
            rs = pstmt.executeQuery();
            return rs.next(); // Si une correspondance est trouv�e, l'authentification est r�ussie
        } finally {
            if (rs != null) {
                rs.close();
            }
        }
    }

    public static String getRole(String username) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String role = null;
        try {
            pstmt = JDBUtils.getConnection().prepareStatement(
                    "SELECT role FROM user WHERE username = ?");
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
