<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<ul class="nav nav-sidebar">
    <li class="active"><a href="${pageContext.request.contextPath}/">Главная<span class="sr-only">(current)</span></a>
    </li>
    <li><a href="${pageContext.request.contextPath}/schedule">Расписание</a></li>
    <c:if test="${role == 'student'}">
        <li><a href="${pageContext.request.contextPath}/students/performance">Успеваемость</a></li>
    </c:if>
    <c:if test="${role == 'teacher'}">
        <%@include file="/pages/blocks/sidebarteacher.jsp" %>
    </c:if>
    <c:if test="${role == 'admin'}">
        <%@include file="/pages/blocks/sidebarteacher.jsp" %>
        <%@include file="/pages/blocks/sidebaradmin.jsp" %>
    </c:if>
</ul>