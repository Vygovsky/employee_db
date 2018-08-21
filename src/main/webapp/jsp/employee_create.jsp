<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link rel="stylesheet" href="<c:url value="/css/styles.css"/>" type="text/css"/>
</head>

<body>
<form method="POST" action="/employee/create">
    <div class="wpforms-form">
        <table>
            <tr>
                <td>Имя сотрудника :</td>
                <td><input type="text" name="name"><br></td>
            </tr>
            <tr>
                <td> Электронная почта :</td>
                <td><input type="text" name="email"></td>
                <br>
            </tr>
            <tr>
                <td>Дата рождения :</td>
                <td><input type="date" name="date"></td>
                <br>
            </tr>
            <tr>
                <td>Департамент :</td>
                <td><select name="organization">
                    <option selected value="Google">Google</option>
                    <option value="Yahoo">Yahoo</option>
                    <option value="Oracle">Oracle</option>
                    <option value="Linux">Linux</option>
                </select>
                </td>
            </tr>
            <tr>
                <td><input type="submit" value="Отправить"></td>
            </tr>
        </table>
    </div>
</form>

</body>
</html>
