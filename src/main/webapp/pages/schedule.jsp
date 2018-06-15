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
            <h3>Расписание занятий</h3><br/>

            <form class="form-inline" action="${pageContext.request.contextPath}/schedule" method="get">
                <div class="form-group">
                    <label for="exampleSelect1">Название дисциплины </label>
                    <select class="form-control" id="exampleSelect1" name="disciplineId">
                        <c:forEach var="discipline" items="${requestScope.get('disciplines')}">
                            <option value="${discipline.id}">${discipline.name}</option>
                        </c:forEach>
                    </select>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
            <br/>

            <!--<input hidden name="disciplineName" value="${discipline.name}">-->

            <!--Table of schedule-->
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">id</th>
                    <th scope="col">Дисциплина</th>
                    <th scope="col">Тема</th>
                    <th scope="col">Дата</th>
                    <th scope="col">Время</th>
                    <th scope="col">Место</th>
                    <th scope="col">Ссылка</th>
                    <th scope="col">Имя преподавателя</th>
                    <th scope="col">Фамилия преподавателя</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="lesson" items="${requestScope.get('lessons')}">
                    <tr>
                        <th scope="row">${lesson.id}</th>
                        <td>${lesson.disciplineName}</td>
                        <td>${lesson.theme}</td>
                        <td>${lesson.date}</td>
                        <td>${lesson.time}</td>
                        <td>${lesson.place}</td>
                        <td>${lesson.link}</td>
                        <td>${lesson.teacherName}</td>
                        <td>${lesson.teacherSurname}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <!--End table of schedule-->

        </div>
    </div>
</div>

<!--footer-->
<%@include file="/pages/blocks/footer.jsp" %>
<!--end footer-->

</body>
</html>

