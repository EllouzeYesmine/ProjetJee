<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Enseignant" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Liste des Enseignants</title>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        th {
            background-color: #f2f2f2;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <h2>Liste des Enseignants</h2>
    <table>
        <thead>
            <tr>
                <th>Username</th>
                <th>Email</th>
                <th>Password</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <%
            Object enseignantsObject = request.getAttribute("enseignants");
            if (enseignantsObject instanceof List<?>) {
                List<?> enseignantsList = (List<?>) enseignantsObject;
                for (Object obj : enseignantsList) {
                    if (obj instanceof Enseignant) {
                        Enseignant enseignant = (Enseignant) obj;
            %>
            <tr>
                <td><%=enseignant.getUsername()%></td>
                <td><%=enseignant.getEmail()%></td>
                <td><%=enseignant.getPassword()%></td>
                <td>
                    <form action="AdminEnseignantServlet" method="GET">
                        <input type="hidden" name="action" value="editEnseignant">
                        <input type="hidden" name="id" value="<%=enseignant.getIdEnseigant()%>">
                        <button type="submit">Modifier</button>
                    </form>
                </td>
            </tr>
            <%
                    }
                }
            }
            %>
        </tbody>
    </table>
</body>
</html>
