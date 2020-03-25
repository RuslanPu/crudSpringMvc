<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: FOX
  Date: 21.03.2020
  Time: 21:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <c:if test="${empty user.name}">
        <title>Add</title>
    </c:if>
    <c:if test="${!empty user.name}">
        <title>Edit</title>
    </c:if>

</head>
<body>
<c:if test="${empty user.name}">
    <h2>Add user</h2>
</c:if>
<c:if test="${!empty user.name}">
    <h2>Edit user</h2>
</c:if>

<c:if test="${empty user.name}">
    <c:url value="/add" var="var"/>
</c:if>
<c:if test="${!empty user.name}">
    <c:url value="/edit" var="var"/>
</c:if>
<c:url value="/edit" var="var"/>
    <form action="${var}" method="POST">



        <c:if test="${!empty user.name}">
            <input type="hidden" name="id" value="${user.id}">
        </c:if>


        <label for="name">name</label>
        <input type="text" name="name" id="name" value="${user.name}">

        <label for="password">password</label>
        <input type="text" name="password" id="password" value="${user.password}">

        <label for="email">email</label>
        <input type="text" name="email" id="email" value="${user.email}">

        <c:if test="${empty user.name}">
            <input  type="submit" value="add user">
        </c:if>
        <c:if test="${!empty user.name}">
            <input  type="submit" value="edit user">
        </c:if>


    </form>
</body>
</html>
