<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<p>구매 가능 목록</p>
<ul>
    <c:forEach var="warehousingItem" items="${items}" varStatus="status">
        <li> <strong>${warehousingItem.itemName}</strong>   가격:${warehousingItem.itemPrice}   잔여 수량:${warehousingItem.itemCount}</li>
    </c:forEach>
</ul>


<p>구매할 상품의 이름,가격,수량을 입력해 주세요</p>

    <form action="buy/purchaseConfirm" method="post">
        <p> <label>이름 : <br>
            <input type="text" name="itemName" id="itemName">
        </label> </p>
        <p> <label>수량 : <br>
            <input type="number" name="itemCount" id="itemCount">
        </label> </p>
        <input type="submit" value="구매 하기">
    </form>
<button type="button" onclick="location.href='/home'">홈으로</button>
</body>
</html>
