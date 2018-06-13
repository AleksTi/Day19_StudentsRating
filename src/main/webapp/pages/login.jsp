<%--
  Created by IntelliJ IDEA.
  User: Anton
  Date: 20.05.2018
  Time: 8:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <%=request.getAttribute("message")%><br/><br/>
    <%=("authErr".equals(request.getParameter("errorMsg"))) ? "Неверное имя пользователя или пароль<br />" : ""%>
    <%=("noAuth".equals(request.getParameter("errorMsg"))) ? "Необходимо идентифицироваться<br />" : ""%>
    Введите данные для входа:<br/>
    <div style="background-color: #cccccc; width: 300px; text-align: right;">
        <form action=${pageContext.request.contextPath}/login method="post">
            e-mail <input type="text" name="email"><br/>
            Пароль <input type="text" name="password"><br/>
            <input type="submit" value="Войти">
        </form>
    </div>
</div>
</body>
</html>
