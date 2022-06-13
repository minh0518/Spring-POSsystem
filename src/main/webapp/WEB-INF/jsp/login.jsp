<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
    <p>Login Page</p>

<%--    <form action="home" method="post">--%>
<%--        <p>--%>
<%--        <label for="ID">ID</label>--%>
<%--        <input type="text" id="ID" name="id"/>--%>
<%--        </p>--%>

<%--        <p>--%>
<%--            <label for="PASS">PASSWORD</label>--%>
<%--            <input type="text" id="PASS" name="password"/>--%>
<%--        </p>--%>

<%--        <input type="submit" value="Login">--%>
<%--    </form>--%>

<form action="/logincheck" method="GET">
    <input type="text" name="id"/>
    <input type="password" name="pwd"/>
    <input type="submit" value="로그인"/>
</form>
</body>
</html>
