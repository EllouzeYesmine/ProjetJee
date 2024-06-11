<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="UTF-8">
<title>Ajouter un Enseignant</title>
</head>
<body>
	<h2>Ajouter un Enseignant</h2>
	<form action="AdminEnseignantServlet" method="post">
		<label for="username">Username:</label> <input type="text"
			id="username" name="username" required><br> <label
			for="email">Email:</label> <input type="email" id="email"
			name="email" required><br> <label for="password">Password:</label>
		<input type="password" id="password" name="password" required><br>
		<input type="hidden" name="action" value="create"> <input
			type="submit" value="Ajouter">
	</form>
</body>
</html>