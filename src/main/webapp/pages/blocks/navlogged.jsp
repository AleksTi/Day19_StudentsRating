<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<ul class="nav navbar-nav navbar-right">
    <li><a href="#"><%=session.getAttribute("name") + " " + session.getAttribute("surname")%>
    </a></li>
</ul>

