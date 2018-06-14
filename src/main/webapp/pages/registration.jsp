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

    <c:if test="${requestScope.get('regResult') == 'regFalse'}">
        <div class="alert alert-danger alert-dismissible" role="alert">Ошибка регистрации нового пользователя</div>
    </c:if>

    <h1>Система успеваемости студентов</h1>
    <div class="row">
        <div class="col-md-3 sidebar">
            <%@include file="/pages/blocks/sidebar.jsp" %>
        </div>
        <div class="col-md-9">
            <h3>Регистрация нового пользователя</h3>

            <form action="${pageContext.request.contextPath}/registration" method="post">
                <div class="form-group">
                    <label for="exampleInputName">Имя</label>
                    <input type="text" class="form-control" id="exampleInputName" placeholder="Введите имя" name="name">
                </div>
                <div class="form-group">
                    <label for="exampleInputSurname">Фамилия</label>
                    <input type="text" class="form-control" id="exampleInputSurname" placeholder="Введите фамилию"
                           name="surname">
                </div>
                <div class="form-group">
                    <label for="exampleInputEmail1">Email address</label>
                    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"
                           placeholder="Введите email" name="email">
                    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.
                    </small>
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">Password</label>
                    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password"
                           name="password">
                </div>
                <div class="form-group">
                    <label for="exampleSelect1">Зарегистрироваться как</label>
                    <select class="form-control" id="exampleSelect1" name="role">
                        <option value="student">Студент</option>
                        <option value="teacher">Преподаватель</option>
                        <option value="admin">Администратор</option>
                    </select>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>

        </div>
    </div>
</div>

<!--footer-->
<%@include file="/pages/blocks/footer.jsp" %>
<!--end footer-->

</body>
</html>


