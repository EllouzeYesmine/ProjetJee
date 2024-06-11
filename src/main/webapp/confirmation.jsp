<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Confirmation</title>
</head>
<body>
    <h1>Confirmation de la Demande de Tirage</h1>
    <p>La demande de tirage pour la matière <strong>${demande.matiere}</strong> a été envoyée avec succès.</p>
    <p>Document: ${demande.document}</p>
    <p>Nombre de copies demandées: ${demande.nombreCopies}</p>
    <p>Heure d'arrivée prévue: ${demande.heureArrivee}</p>
    <p><a href="enseignant.jsp">Retourner pour une nouvelle demande</a></p>
</body>
</html>
