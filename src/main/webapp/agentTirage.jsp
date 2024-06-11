<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Tableau de bord de l'agent de tirage</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <h2>Tableau de bord de l'agent de tirage</h2>
    <table>
        <thead>
            <tr>
                <th>Nom de l'enseignant</th>
                <th>Nombre de copies</th>
                <th>Date de réception</th>
                <th>Document à imprimer</th>
            </tr>
        </thead>
        <tbody>
            <!-- Ici, vous pouvez utiliser une boucle pour afficher les tâches à effectuer -->
            <c:forEach var="tache" items="${taches}">
                <tr>
                    <td>${tache.nomEnseignant}</td>
                    <td>${tache.nombreCopies}</td>
                    <td>${tache.dateReception}</td>
                    <td>${tache.documentImprimer != null ? "Oui" : "Non"}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
