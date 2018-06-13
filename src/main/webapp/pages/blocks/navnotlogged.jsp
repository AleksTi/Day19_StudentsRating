<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form action="${pageContext.request.contextPath}/login" class="navbar-form navbar-right" method="post">
    <div class="form-group">
        <input type="text" placeholder="Email" class="form-control" name="email">
    </div>
    <div class="form-group">
        <input type="password" placeholder="Password" class="form-control" name="password">
    </div>
    <button type="submit" class="btn btn-success">Sign in</button>
</form>