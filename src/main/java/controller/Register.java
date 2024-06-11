package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tn.iit.dao.AdminDAO;
import tn.iit.dao.AgentDAO;
import tn.iit.dao.AgentTirageDAO;
import tn.iit.dao.EnseignantDAO;
import tn.iit.model.Admin;
import tn.iit.model.Agent;
import tn.iit.model.Teacher;

import java.io.IOException;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    request.getRequestDispatcher("register.jsp").forward(request, response);
		}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String username = request.getParameter("username");
		 String lastName = request.getParameter("lastName");
	        String password = request.getParameter("password");
	        String email = request.getParameter("email");
	        String role = request.getParameter("role");
	        request.getSession().setAttribute("registeredUsername", username);
	        request.getSession().setAttribute("registeredUsername", lastName);
	        request.getSession().setAttribute("registeredMdp", password);
	        request.getSession().setAttribute("registeredRole", role);
	        // Ins�rer les informations dans la table appropri�e en fonction du r�le
	        if ("admin".equals(role)) {
	            AdminDAO.save(new Admin(username,lastName, email, password));
	        } else if ("enseignant".equals(role)) {
	            EnseignantDAO.save(new Teacher(username,lastName, email, password));
	        } else if ("agent_tirage".equals(role)) {
	            AgentDAO.save(new Agent(username,lastName, email, password));
	        }

	        // Rediriger vers la page de connexion
	        response.sendRedirect("login.jsp");
		
	}
}
