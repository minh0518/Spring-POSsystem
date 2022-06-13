<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <p>입고할 상품의 이름,가격,수량을 입력해 주세요</p>


    <form action="plus/addConfirm" method="post">
        <p> <label>이름 : <br>
            <input type="text" name="itemName" id="itemName">
        </label> </p>
        <p> <label>가격 : <br>
            <input type="number" name="itemPrice" id="itemPrice">
        </label> </p>
        <p> <label>수량 : <br>
            <input type="number" name="itemCount" id="itemCount">
        </label> </p>

        <input type="submit" value="상품 입고">
    </form>
</body>
</html>
