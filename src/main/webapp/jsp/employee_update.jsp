<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>User update</title>
</head>

<body>

<form method="post" action="editEmployee">
    <%--@declare id="name"--%>
    <%--@declare id="email"--%>
    <%--@declare id="birthday"--%>
    <tr>
        Имя сотрудника : <input
            type="text" name="name"
            value="<c:out value="${employee.name}" />"/> <br/>
    </tr>
    <tr>
        Почта : <input type="text" name="email"
                       value="<c:out value="${employee.email}" />"/> <br/>
    </tr>
    <tr>
        День рожления :
        <td><input type="date" name="date"></td>
    </tr>

    <button type="submit" name="save" value="${employee.id}">save</button>


</form>
</body>
</html>
