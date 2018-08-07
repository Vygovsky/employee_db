<%--
  Created by IntelliJ IDEA.
  User: Roman_v
  Date: 07.08.2018
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Employee</title>
</head>
<body>
<form method="POST" action="/employee/create">
    <table>
        <tr>
            <td>Имя сотрудника :</td>
            <td><input type="text" value="name"></td>
        </tr>
        <tr>
            <td>Электронная почта :</td>
            <td><input type="text" value="mail"></td>
        </tr>
        <tr>
            <td>Дата рождения :</td>
            <td><input type="datetime-local" value="date"></td>
        </tr>
        <tr>
            <td align="right" colspan="2"><input type="submit" value="Отправить"></td>
        </tr>
    </table>
</form>


</body>
</html>
