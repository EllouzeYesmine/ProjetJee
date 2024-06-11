package tn.iit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tn.iit.model.Admin;
import tn.iit.model.Agent;
import tn.iit.model.User;
import utils.JDBUtils;

public class AgentDAO extends UserDao {
	 public static boolean authenticate(String username, String password) {
	        try {
	            return AuthentificationDAO.authenticate(username, password, "agent");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return false;
	    }

		    public void save(User user) {
		        if (user instanceof Agent) {
		        	Agent agent = (Agent) user;
		            try (Connection conn = JDBUtils.getConnection();
		                 PreparedStatement pstmt = conn.prepareStatement(
		                         "INSERT INTO user (username, lastName, email, password, role) VALUES (?, ?, ?, ?, ?)")) {
		                pstmt.setString(11, agent.getUsername());
		                pstmt.setString(12, agent.getLastName());
		                pstmt.setString(13, agent.getEmail());
		                pstmt.setString(14, agent.getPassword());
		                pstmt.setString(15, agent.getRole());
		                pstmt.executeUpdate();
		            } catch (SQLException e) {
		                e.printStackTrace();
		            }
		        } else {
		            super.save(user);
		        }
		    }

		    public List<Agent> getAllAgent() {
		        List<Agent> agents = new ArrayList<>();
		        try (Connection conn = JDBUtils.getConnection();
		             Statement stmt = conn.createStatement();
		             ResultSet rs = stmt.executeQuery("SELECT * FROM user WHERE role = 'agent'")) {
		            while (rs.next()) {
		                Agent agent = new Agent(
		                        rs.getInt("id"),
		                        rs.getString("username"),
		                        rs.getString("lastName"),
		                        rs.getString("email"),
		                        rs.getString("password")
		                );
		                agents.add(agent);
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		        return agents;
		    }

		    public Agent getAgentById(int id) {
		    	Agent agent = null;
		        try (Connection conn = JDBUtils.getConnection();
		             PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM user WHERE id = ? AND role = 'admin'")) {
		            pstmt.setInt(1, id);
		            try (ResultSet rs = pstmt.executeQuery()) {
		                if (rs.next()) {
		                	agent = new Agent(
		                            rs.getInt("id"),
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
		        return agent;
		    }

}
