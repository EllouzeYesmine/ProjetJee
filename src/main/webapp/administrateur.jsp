<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Interface Administrateur</title>
    <link rel="stylesheet" href="css/styleAdmin.css">
</head>
<body>
    <header>
        <h1>Interface Administrateur</h1>
    </header>
    <main>
        <div class="container">
            <div class="user-management">
                <h2>Gestion des Utilisateurs</h2>
                <ul>
                    <li><a href="AdminEnseignantServlet?action=create">Ajouter un Enseignant</a></li>
                    <li><a href="AdminEnseignantServlet?action=editEnseignant">Modifier un Enseignant</a></li>
                    <li><a href="AdminEnseignantServlet?action=delete">Supprimer un Enseignant</a></li>
                    <li><a href="AdminEnseignantServlet?action=viewAll">Afficher tous les Enseignants</a></li>
                </ul>
            </div>
           
        </div>
    </main>
    <footer>
        <p>© 2024 Plateforme de Gestion d'Impression. Tous droits réservés.</p>
    </footer>
</body>
</html>
