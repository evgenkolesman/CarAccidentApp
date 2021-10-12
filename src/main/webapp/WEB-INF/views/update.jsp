<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>Edit page</head>
<body>
<style>
    body {
        text-align: center;
    }
</style>
<div class="container pt-3">
    <form action="<c:url value='/save?id=${accident.id}'/>" method='POST'>
        <table>
            <tr>
                <td>Name:</td>
                <td><input type='text' name='name' value="${accident.name}"></td>
            </tr>
            <tr>
                <td>Accident description:</td>
                <td><input type='text' name='text' value="${accident.text}"></td>
            </tr>
            <tr>
                <td>Address:</td>
                <td><input type='text' name='address' value="${accident.address}"></td>
            </tr>
            <tr>
                <td>Type</td>
                <td type="text" name="type" value="${accident.type}">
                    <select name="type.id">
                        <c:forEach var="type" items="${types}">
                            <option value="${type.id}">${type.name}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>States:</td>
                <td>
                    <select name="rIds" multiple>
                        <c:forEach var="rule" items="${rules}">
                            <option value="${rule.id}">${rule.name}</option>
                        </c:forEach>
                    </select>
            </tr>
            <tr>
                <td colspan='2'><input name="submit" type="submit" value="Сохранить"/></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>

