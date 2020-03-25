<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
<h1>Users</h1>
<h2>Add user</h2>
<c:url value="/add" var="add"/>
<a href="${add}">Add new user</a>
<table>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>password</th>
        <th>email</th>
    </tr>
    <c:forEach var="user" items="${userList}">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.password}</td>
            <td>${user.email}</td>
            <td>
                <a href="/edit/${user.id}">edit</a>
                <a href="/delete/${user.id}">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>



</body>
</html>