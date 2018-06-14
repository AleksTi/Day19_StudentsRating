<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!--head-->
<%@include file="/pages/blocks/head.jsp" %>
<!--end head-->

<body>

<!--nav-->
<%@include file="/pages/blocks/nav.jsp" %>
<!--end nav-->

<div class="container">
    <c:if test="${message == 'authErr'}">
        <div class="alert alert-danger alert-dismissible" role="alert">Неверное имя пользователя или пароль</div>
    </c:if>

    <h1>Система успеваемости студентов</h1>
    <div class="row">
        <div class="col-md-3 sidebar">
            <%@include file="/pages/blocks/sidebar.jsp" %>
        </div>
        <div class="col-md-9">
            <c:if test="${sessionScope.get('email') != null}">
                <p class="lead"><%=session.getAttribute("name")%>, добро пожаловать в систему успеваемости студентов</p>
            </c:if>
        </div>
    </div>
</div>

<!--footer-->
<%@include file="/pages/blocks/footer.jsp" %>
<!--end footer-->

</body>
</html>
