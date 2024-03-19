<%@ page import="org.sd.WebInfo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><%= WebInfo.getWebName() %> - 主页</title>
</head>
<link rel="stylesheet" href="/assets/css/app.css">
<link rel="stylesheet" href="/assets/css/main.css">
<link rel="stylesheet" href="/assets/bootstrap-4.6.2-dist/css/bootstrap.min.css">
<body>
<div class="index">
    <div class="aside">
        <h4 class="title"><%= WebInfo.getWebName() %>
        </h4>
        <ul class="nav flex-column">
            <li class="nav-item">
                <a href="/impl?currentPage=1" target="frame">显示学生情况</a>
            </li>
            <li class="nav-item">
                <a href="/grade" target="frame">添加学生信息</a>
            </li>
            <li class="nav-item">
                <a href="/admin/searchInput.jsp" target="frame">查询学生信息</a>
            </li>
            <li class="nav-item">
                <a href="/signout">退出登录</a>
            </li>
        </ul>
    </div>
    <div class="center">
        <div class="header"></div>
        <div class="main">
            <iframe src="../impl?currentPage=1" frameborder="0" name="frame"></iframe>
            <%--            <iframe src="/admin/searchInput.jsp" frameborder="0" name="frame"></iframe>--%>
        </div>
    </div>
</div>
</body>
</html>
