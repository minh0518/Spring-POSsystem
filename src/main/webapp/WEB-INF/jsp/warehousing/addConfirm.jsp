<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>입고가 완료되었습니다!</h1>
    <%--현재 url warhousing/menu/plus/addConfirm--%>
    <button type="button" onclick="location.href='/home/warehousing/menu/plus'">다른 상품 입고하기</button>
    <button type="button" onclick="location.href='/home'">홈으로</button>

    <p>현재 상품 목록들</p>
    <ul>
    <c:forEach var="warehousingItem" items="${items}" varStatus="status">
        <li> <strong>${warehousingItem.itemName}</strong>   가격:${warehousingItem.itemPrice}   잔여 수량:${warehousingItem.itemCount}   입고 날짜:${warehousingItem.date}</li>
    </c:forEach>
    </ul>

</body>
</html>
