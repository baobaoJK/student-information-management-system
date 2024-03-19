<%@ page import="org.sd.WebInfo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><%= WebInfo.getWebName() %> - 更新学生信息</title>
    <link rel="stylesheet" href="/assets/css/app.css">
    <link rel="stylesheet" href="/assets/css/update.css">
    <link rel="stylesheet" href="/assets/bootstrap-4.6.2-dist/css/bootstrap.min.css">
</head>
<body>
<div class="update">
    <div class="card">
        <div class="card-header">
            更新学生信息
        </div>
        <div class="card-body">
            <form action="/update" class="update-form">
                <div class="update-form-item">
                    <label for="id">ID：</label>
                    <input type="text" name="id" id="id" value="<%= request.getParameter("id") %>">
                </div>
                <div class="update-form-item">
                    <label for="id">姓名：</label>
                    <input type="text" name="name" id="name" value="<%= request.getParameter("name") %>">
                </div>
                <div class="update-form-item">
                    <label for="id">年龄：</label>
                    <input type="text" name="age" id="age" value="<%= request.getParameter("age") %>">
                </div>
                <div class="update-form-item">
                    <label for="id">电话：</label>
                    <input type="text" name="tel" id="tel" value="<%= request.getParameter("tel") %>">
                </div>
                <div class="update-form-item">
                    <label for="id">地址：</label>
                    <input type="text" name="address" id="address" value="<%= request.getParameter("address") %>">
                </div>
                <div class="update-form-item">
                    <button type="submit" class="btn btn-primary submit">更新</button>
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>
