<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <h1>Something goes wrong</h1>

  <c:forEach var="warehousingItem" items="${itemLists}" varStatus="status">
      <li> ${status.index+1} : ${warehousingItem.itemName}</li>
  </c:forEach>
</body>
</html>
