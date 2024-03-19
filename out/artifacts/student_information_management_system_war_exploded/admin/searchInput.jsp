<%@ page import="org.sd.WebInfo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><%= WebInfo.getWebName() %> - 搜索学生信息</title>
    <link rel="stylesheet" href="/assets/css/app.css">
    <link rel="stylesheet" href="/assets/css/search.css">
    <link rel="stylesheet" href="/assets/bootstrap-4.6.2-dist/css/bootstrap.min.css">
</head>
<body>
<div class="search">
    <div class="card">
        <div class="card-header">
            搜索学生信息
        </div>
        <div class="card-body">
            <form action="/search">
                <div class="search-form-item">
                    <label for="name">请输入查询姓名：</label>
                    <input type="text" name="name" id="name">
                    <button type="submit" class="btn btn-primary">提交</button>
                </div>
                <div class="search-form-item">
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
