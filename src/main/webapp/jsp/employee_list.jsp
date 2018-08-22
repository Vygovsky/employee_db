<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Roman_v
  Date: 22.08.2018
  Time: 13:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List users in departments</title>
</head>
<body>
<form method="get" action="/listEmployee">
    <p><h1>List Users</h1></p>
    <div class="zui-table-zebra">
        <table >

            <thead  >
            <tr class="zui-table-horizontal" >
                <th>Name</th>
                <th>E-mail</th>
                <th>Birthday</th>
                <%--<th>Department</th>--%>
                <th class="but"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="user" items="${list}">
                <tr>
                    <td><strong></strong>${user.name}</td>
                    <td>${user.email}</td>
                    <td>${user.birthday}</td>

                </tr>
            </c:forEach>
            </tbody>

        </table>
    </div>
</form>


</body>
</html>
