<html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body>
<p>ХОТИТЕ ДОБАВИТЬ ПОСТАВЬТЕ ID = 0, ХОТИТЕ ИЗМЕНИТЬ ВПИШИТЕ ID</p>
<form action="<c:url value='/save'/>" method='POST'>
<%--<form action="<c:url value='/save'/>" method='POST'>--%>
  <table>
    <tr>
<%--      <td>ID:</td>--%>
<%--      <td><input type='text' name='id'></td>--%>
      <td>Название:</td>
      <td><input type='text' name='name'></td>
      <td>Описание:</td>
      <td><input type='text' name='text'></td>
      <td>Адрес:</td>
      <td><input type='text' name='address'></td>
    </tr>
    <tr>
      <td colspan='2'><input name="submit" type="submit" value="Сохранить" /></td>
    </tr>
  </table>
</form>
</body>
</html>
