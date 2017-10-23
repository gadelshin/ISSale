
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
<head>
    <title>All goods</title>
</head>
<body>
<table border="2" >
    <tbody>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Model</th>
        <th>Description</th>
        <%--<th>Price</th>--%>
    </tr>
    <c:forEach items="${list}" var="item">
    <tr>
        <td><c:out value="${item.id}"/></td>
        <td><c:out value="${item.name}"/></td>
        <td><c:out value="${item.model}"/></td>
        <td><c:out value="${item.description}"/></td>
        <%--<td><c:out value="${item.price}"/></td>--%>
        <td> <a href="${pageContext.servletContext.contextPath}/edit?id=${item.num}">Редактировать</a></td>
        <td> <a href="${pageContext.servletContext.contextPath}/delete?id=${item.num}">Удалить</a></td>
    </tr>

    </c:forEach>
</table>
</body>
</html>
