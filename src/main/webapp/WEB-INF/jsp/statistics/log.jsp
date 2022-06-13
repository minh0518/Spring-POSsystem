<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>구매 내역</h1>
<button type="button" onclick="location.href='/home/buy'"> 다른 상품 구매하러 가기 </button>
<button type="button" onclick="location.href='/home'">홈으로</button>


<div>
<p>구매 로그</p>
<ul>
    <c:forEach var="purchasingItem" items="${items}" varStatus="status">
        <li> <strong>${purchasingItem.itemName}</strong>   물품 가액 : ${purchasingItem.itemPrice}
            구매 수량:${purchasingItem.itemCount}  총 금액 : ${purchasingItem.totalPrice} 구매 일시 : ${purchasingItem.plusDate}</li>
    </c:forEach>
</ul>
</div>

<div>
<p>총 매출액</p>
    <strong>${totalPrice}</strong>원
</div>

</body>
</html>
