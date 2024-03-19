<%@ page import="org.sd.WebInfo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><%= WebInfo.getWebName() %> - 登录></title>
    <link rel="stylesheet" href="/assets/css/app.css">
    <link rel="stylesheet" href="/assets/css/login.css">
    <link rel="stylesheet" href="/assets/bootstrap-4.6.2-dist/css/bootstrap.min.css">
</head>
<body>
<div class="login">
    <div class="login-form-pane">
        <h3 class="login-title"><%= WebInfo.getWebName() %></h3>
        <form action="/login" method="post">
            <div class="login-form-item">
                <input type="text" name="name" placeholder="用户名" autocomplete="off"/>
            </div>
            <div class="login-form-item">
                <input type="password" name="password" placeholder="密码"/>
            </div>
            <div class="login-form-item">
                <input type="submit" value="登 录" />
            </div>
        </form>
    </div>
</div>
</body>
</html>
