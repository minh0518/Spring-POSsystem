<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    String id= (String) request.getAttribute("id");

        out.println("<h1> welcome!! </h1>");

%>

<div>
    <p>POS System</p>
    <p>select menu below</p>
</div>


    <div>
        <button type="button" onclick="location.href='/home/buy'">상품 구매</button>
        <button type="button" onclick="location.href='/home/warehousing/menu'">재고 관리</button>
        <button type="button" onclick="location.href='/home/log'">통계</button>
    </div>

<%--    <a href="buy/menu">상품 구매</a>--%>
<%--    <a href="warehousing/menu">재고 관리</a>--%>
<%--    <a href="buy/menu">통계</a>--%>
<%--    <a href="buy/menu">종료</a>--%>
</body>
</html>
