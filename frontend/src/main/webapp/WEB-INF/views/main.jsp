<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>App</title>
</head>
<body>
WELCOME TO THE MAIN BANK

<c:if test="${not empty loggedIn}">
    loggedIn : <%= request.getAttribute("loggedIn") %>
  </c:if>
</body>
</html>