<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>삭제할 상품의 품목과 수량을 입력해 주세요</p>

<p>삭제 가능 목록</p>
<ul>
    <c:forEach var="warehousingItem" items="${items}" varStatus="status">
        <li> <strong>${warehousingItem.itemName}</strong>   가격:${warehousingItem.itemPrice}   잔여 수량:${warehousingItem.itemCount}</li>
    </c:forEach>
</ul>


<form action="minus/removeConfirm" method="post">
    <p> <label>이름 : <br>
        <input type="text" name="itemName" id="itemName">
    </label> </p>
    <p> <label>수량 : <br>
        <input type="number" name="itemCount" id="itemCount">
    </label> </p>
    <input type="submit" value="상품 제거">
</form>
</body>
</html>
