<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="model.Enseignant" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Modifier Enseignant</title>
</head>
<body>
    <h2>Modifier Enseignant</h2>
    <form action="AdminEnseignantServlet" method="POST">
        <input type="hidden" name="action" value="editEnseignant">
        <%-- Récupérer l'enseignant depuis la requête --%>
        <% Enseignant enseignant = (Enseignant) request.getAttribute("enseignant"); %>
        <%-- Vérifier si l'enseignant existe --%>
        <% if (enseignant != null) { %>
            <input type="hidden" name="id" value="<%= enseignant.getIdEnseigant() %>">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" value="<%= enseignant.getUsername() %>"><br>
            <label for="email">Email:</label>
            <input type="text" id="email" name="email" value="<%= enseignant.getEmail() %>"><br>
            <label for="password">Password:</label>
            <input type="text" id="password" name="password" value="<%= enseignant.getPassword() %>"><br>
            <button type="submit">Enregistrer</button>
        <% } else { %>
            <p>Enseignant non trouvé.</p>
        <% } %>
    </form>
</body>
</html>
