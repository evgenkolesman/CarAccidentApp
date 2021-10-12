<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>LOGIN PAGE</head>
<style>
    body {
        text-align: center;
    }
</style>
<body>

<div class="container pt-3" style="text-align:center">
    <c:if test="${not empty errorMessage}">
        <div style="color:red; font-weight: bold; margin: 30px 0px;">
                ${errorMessage}
        </div>
    </c:if>
    <form name='login' action="<c:url value='/login'/>" method='POST'>
        <table class="table_with_text_on_center">
            <tr>
                <td>
                    <div class="form-group">
                        <label for="username">UserName:</label>
                        <input class="form-control form-control-lg" id="username" type='text' name='username'
                               placeholder="username"/>
                    </div>
                </td>
                <td>
                    <div class="form-group">
                        <label>Password:</label>
                        <input class="form-control form-control-lg" type='password' name='password'
                               placeholder="password"/>
                    </div>
                </td>
            </tr>
            <tr>
                <td class="form-group form-control-lg" colspan='2'><input name="submit" type="submit" value="submit"/>
                </td>
            </tr>
        </table>

        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
    <a class="btn btn-secondary btn-lg btn-block" href="<c:url value='/reg'/>" role="button">Регистрация</a>
</div>
</body>
</html>