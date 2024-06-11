package utils;

import java.sql.Connection;
import java.sql.SQLException;

public class DBTest {

	//pour tester la connectivité avec la base
	  public static void main(String[] args) {
	        try {
	            Connection conn = JDBUtils.getConnection();
	            if (conn != null) {
	                System.out.println("Connexion a la base de donn�es �tablie avec succees !");
	                conn.close(); 
	            } else {
	                System.out.println("La connexion a la base de donn�es a echoue.");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
}
