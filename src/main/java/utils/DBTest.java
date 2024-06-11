package utils;

import java.sql.Connection;
import java.sql.SQLException;

public class DBTest {

	//pour tester la connectivité avec la base
	  public static void main(String[] args) {
	        try {
	            Connection conn = JDBUtils.getConnection();
	            if (conn != null) {
	                System.out.println("Connexion � la base de donn�es �tablie avec succ�s !");
	                conn.close(); 
	            } else {
	                System.out.println("La connexion � la base de donn�es a �chou�.");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
}
