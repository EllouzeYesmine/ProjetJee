<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>S�lectionner un Enseignant � Modifier</title>
</head>
<body>
    <h2>S�lectionner un Enseignant � Modifier</h2>
    <form action="AdminEnseignantServlet" method="get">
        <label for="id">ID de l'Enseignant:</label>
        <input type="text" id="id" name="id" required><br>
        <input type="hidden" name="action" value="editEnseignant">
        <input type="submit" value="Modifier">
    </form>
</body>
</html>