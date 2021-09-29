<%@ page import="di.model.Accident" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
      integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<head>
    <%--    Download Table c --%>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
    <title>CarAccidentApp</title>
</head>
<body>

<div class="container">
    <style>
        body {
            text-align: center;
        }
    </style>
    <h2>Accident table</h2>
    <div>
        <div class="row">
            <table class="table">
                <thead class="thead-dark">
                <tr>
                    <th>ID</th>
                    <th>NAME</th>
                    <th>DESCRIPTION</th>
                    <th>ADDRESS</th>
                    <th>TYPE</th>
                    <th>RULE</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${accidents}" var="accident">
                    <tr>
                    <td>
                        <a href="<c:url value='/update?id=${accident.id}'/>">
                        <i class="fa fa-edit mr-3"></i>
                        </a>
                        <c:out value="${accident.id}"/>
                    </td>
                    <td>
                        <c:out value="${accident.name}"/>
<%--                        Ссылка изменения имени--%>
<%--                        <div>--%>
<%--                            <span>--%>
<%--                                 <a href="<c:url value='/update?id=${accident.id}'/>">Добавить инцидент</a>--%>
<%--                            </span>--%>
<%--                        </div>--%>
                    </td>
                    <td><c:out value="${accident.text}"/></td>
                    <td><c:out value="${accident.address}"/></td>
                    <td><c:out value="${accident.type.name}"/></td>
                    <td><c:out value="${accident.rule.name}"/></td>
                    </tr>
                </c:forEach>
                </tbody>

            </table>
            <a href="<c:url value='/create'/>">Add accident</a>
            <ul class="nav">
                <li class="nav-item" style="font-weight: bold">
                    <a class="nav-link" href="<c:url value="/logout"/>">Выйти из системы</a>
                </li>
            </ul>
        </div>
    </div>
</div>
</body>
</html>