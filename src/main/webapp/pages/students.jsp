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
            <p>Список студентов</p>
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">First</th>
                    <th scope="col">Last</th>
                    <th scope="col">Handle</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="student" items="${students}">
                    <tr>
                        <th scope="row">${student.id}</th>
                        <td>${student.name}</td>
                        <td>${student.surname}</td>
                        <td>${student.email}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

        </div>
    </div>
</div>

<!--footer-->
<%@include file="/pages/blocks/footer.jsp" %>
<!--end footer-->

</body>
</html>
