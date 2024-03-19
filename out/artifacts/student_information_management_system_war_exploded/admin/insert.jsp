<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.sd.WebInfo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><%= WebInfo.getWebName() %> - 添加学生信息></title>
    <link rel="stylesheet" href="/assets/css/app.css">
    <link rel="stylesheet" href="/assets/css/insert.css">
    <link rel="stylesheet" href="/assets/bootstrap-4.6.2-dist/css/bootstrap.min.css">
</head>
<body>
<div class="insert">
    <div class="card">
        <div class="card-header">
            添加学生信息
        </div>
        <div class="card-body">
            <form action="/insert" method="post" class="insert-form">
                <div class="insert-form-item">
                    <label for="id">学号：</label>
                    <input type="text" name="id" id="id">
                </div>
                <div class="insert-form-item">
                    <label for="name">姓名：</label>
                    <input type="text" name="name" id="name">
                </div>
                <div class="insert-form-item">
                    <label for="age">年龄：</label>
                    <input type="text" name="age" id="age">
                </div>
                <div class="insert-form-item">
                    <label for="tel">电话：</label>
                    <input type="text" name="tel" id="tel">
                </div>
                <div class="insert-form-item">
                    <label for="address">地址：</label>
                    <input type="text" name="address" id="address">
                </div>
                <div class="insert-form-item">
                    <label for="gid">班级：</label>
                    <select name="gid" id="gid">
                        <c:forEach items="${ requestScope.grades }" var="grade">
                            <option value="${ grade.gid }"> ${ grade.gname }</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="insert-form-item">
                    <button type="submit" class="btn btn-primary submit">提交</button>
                    <input type="hidden" name="currentPage" value="${ sessionScope.currentPage }">
                </div>
            </form>
        </div>
    </div>
</div>


</body>
</html>
