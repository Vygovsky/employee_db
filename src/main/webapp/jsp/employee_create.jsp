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
    Имя сотрудника : <input type="text" name="name">
    Электронная почта :<input type="text" name="email">
    Дата рождения :<input type="date" name="date">
    <input type="submit" value="Отправить">
</form>
</body>
</html>
