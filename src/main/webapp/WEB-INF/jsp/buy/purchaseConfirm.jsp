<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>




<h1> 구매 내역 </h1>
<div>
${itemName}
구매 수량 : ${itemCount}
총 금액 : ${totalPrice}
</div>
<div>
    <button type="button" onclick="location.href='/home/buy'">다른 상품 구매하러 가기</button>
    <button type="button" onclick="location.href='/home'">홈으로</button>
</div>


</body>
</html>
