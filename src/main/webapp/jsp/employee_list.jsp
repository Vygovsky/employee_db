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
    <style>
        #customers {
            border: solid 1px #DDEEEE;
            border-collapse: collapse;
            border-spacing: 0;
            font: normal 13px Arial, sans-serif;
        }

        #customers td, #customers th {
            border: solid 1px #DDEEEE;
            color: #333;
            padding: 10px;

        }

        #customers tr:nth-child(even) {
            background-color: #DDEFEF;
            border: solid 1px #DDEEEE;
            color: #336B6B;
            padding: 10px;
            text-align: left;
            text-shadow: 1px 1px 1px #fff;
        }

        #customers tr:hover {
            background-color: #fff;
        }

        #customers tbody tr:nth-child(even) {
            background-color: #EEF7EE;
        }

        #customers th {
            padding-top: 12px;
            padding-bottom: 12px;
            text-align: left;
            background-color: #86af90;
            color: white;
        }
    </style>
</head>

<title>List users by departments</title>
</head>
<body>
<h1>List of users</h1></p>
<table id="customers">
    <thead>
    <tr>
        <th>#</th>
        <th>Name</th>
        <th>E-mail</th>
        <th>Birthday</th>
        <th>Update</th>
        <th>Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${list}">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.email}</td>
            <td>${user.birthday}</td>
            <%--<form action="employee_update.jsp" method="post">
                <td>
                    <button type="submit" name="update" value="${user.id}">update</button>
                </td>
            </form>--%>
            <form action="deleteEmployee" method="get">
                <td>
                    <%--<button type="submit" name="delete" =value="${user.id}">delete</button>--%>
                        <a href="/deleteEmployee?id=<c:out value='${user.id}'/>">Delete</a>

                </td>
            </form>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
