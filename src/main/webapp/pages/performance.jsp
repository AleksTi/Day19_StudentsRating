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
    <h1>Система успеваемости студентов</h1>
    <div class="row">
        <div class="col-md-3 sidebar">
            <%@include file="/pages/blocks/sidebar.jsp" %>
        </div>
        <div class="col-md-9">
            <h3>Успеваемость</h3><br/>
            <p>Данная страница доступна только для студента, который вошёл в систему. На ней отображается успеваемость
                по предметам.</p>


        </div>
    </div>
</div>

<!--footer-->
<%@include file="/pages/blocks/footer.jsp" %>
<!--end footer-->

</body>
</html>