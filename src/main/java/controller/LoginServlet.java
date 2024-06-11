package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tn.iit.dao.AuthentificationDAO;

import java.io.IOException;
import java.sql.SQLException;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String username = request.getParameter("username");
	        String password = request.getParameter("password");
	        String role = request.getParameter("role");

	        try {
	            boolean isAuthenticated = AuthentificationDAO.authenticate(username, password, role);

	            if (isAuthenticated) {
	                HttpSession session = request.getSession();
	                session.setAttribute("username", username);
	                session.setAttribute("role", role);
	                if ("enseignant".equals(role)) {
	                    response.sendRedirect("enseignant.jsp");
	                } else if ("admin".equals(role)) {
	                    response.sendRedirect("administrateur.jsp");
	                } else if ("agent".equals(role)) {
	                    response.sendRedirect("agentTirage.jsp");
	                }
	            } else {
	                // L'authentification a échoué, rediriger vers la page de connexion avec un message d'erreur
	                request.setAttribute("errorMessage", "Nom d'utilisateur ou mot de passe incorrect. Veuillez réessayer!!.");
	                request.getRequestDispatcher("login.jsp").forward(request, response);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            // Gérer l'erreur d'authentification
	            response.sendRedirect("error.jsp");
	        }
	    }

}
