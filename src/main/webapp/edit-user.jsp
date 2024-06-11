<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit User</title>
</head>
<body>
    <form action="update" method="post">
        <input type="hidden" name="id" value="${user.id}">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="${user.name}"><br>
        <label for="email">Email:</label>
        <input type="text" id="email" name="email" value="${user.email}"><br>
        <label for="country">Country:</label>
        <input type="text" id="country" name="country" value="${user.country}"><br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>