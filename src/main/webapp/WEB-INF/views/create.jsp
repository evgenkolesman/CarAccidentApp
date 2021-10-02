<html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body>
<form action="<c:url value='/save'/>" method='POST'>
<%--<form action="<c:url value='/save'/>" method='POST'>--%>
  <table>
    <tr>
<%--      <td>ID:</td>--%>
<%--      <td><input type='text' name='id'></td>--%>
      <td>Name:</td>
      <td><input type='text' name='name'></td>
      <td>Description:</td>
      <td><input type='text' name='text'></td>
      <td>Address:</td>
      <td><input type='text' name='address'></td>
    </tr>
      <tr>
          <td>Type</td>
          <td type="text" name="type" >
              <select name="type.id">
                  <c:forEach var="type" items="${types}" >
                      <option value="${type.id}">${type.name}</option>
                  </c:forEach>
              </select>
          </td>
      </tr>
      <tr>
          <td>States:</td>
          <td>
              <select name="rIds" multiple>
                  <c:forEach var="rule" items="${rules}" >
                      <option value="${rule.id}">${rule.name}</option>
                  </c:forEach>
              </select>
      </tr>
    <tr>
      <td colspan='2'><input name="submit" type="submit" value="Сохранить" /></td>
    </tr>
  </table>
</form>
</body>
</html>
