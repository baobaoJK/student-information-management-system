<%@ page import="org.sd.WebInfo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title><%= WebInfo.getWebName() %> - 学生信息</title>
    <link rel="stylesheet" href="/assets/css/app.css">
    <link rel="stylesheet" href="/assets/css/display.css">
    <link rel="stylesheet" href="/assets/bootstrap-4.6.2-dist/css/bootstrap.min.css">
</head>
<body>
<div class="display">
    <div class="card">
        <div class="card-header">
            学生情况
        </div>
        <div class="card-body">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">学号</th>
                    <th scope="col">姓名</th>
                    <th scope="col">年龄</th>
                    <th scope="col">电话</th>
                    <th scope="col">地址</th>
                    <th scope="col">班级编号</th>
                    <th scope="col">班级</th>
                    <th scope="col">操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${ requestScope.students }" var="student" varStatus="num">
                    <tr>
                        <td><c:out value="${ student.id }" default=""/></td>
                        <td><c:out value="${ student.name }" default=""/></td>
                        <td><c:out value="${ student.age }" default=""/></td>
                        <td><c:out value="${ student.tel }" default=""/></td>
                        <td><c:out value="${ student.address }" default=""/></td>
                        <td><c:out value="${ student.grade.gid }" default=""/></td>
                        <td><c:out value="${ student.grade.gname }" default=""/></td>
                        <td>
                            <c:url value="/admin/updateStudent.jsp" var="update">
                                <c:param name="id" value="${ student.id }"/>
                                <c:param name="name" value="${ student.name }"/>
                                <c:param name="age" value="${ student.age }"/>
                                <c:param name="tel" value="${ student.tel }"/>
                                <c:param name="address" value="${ student.address }"/>
                            </c:url>
                            <a href="${ update }">更新</a>
                            &nbsp;
                            &nbsp;
                            &nbsp;
                            <c:url value="/delete" var="del">
                                <c:param name="id" value="${ student.id }"/>
                                <c:param name="currentPage" value="1"/>
                            </c:url>
                            <a href="${ del }">删除</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

            <nav aria-label="Page navigation example">
                <ul class="pagination justify-content-center">
                    <li class="page-item"><a class="page-link" href="impl?currentPage=1">首页</a></li>
                    <c:choose>
                        <c:when test="${ sessionScope.currentPage == 1 }">
                            <li class="page-item disabled">
                                <a class="page-link" href="impl?currentPage=${ sessionScope.currentPage - 1 }"
                                   aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li class="page-item">
                                <a class="page-link" href="impl?currentPage=${ sessionScope.currentPage - 1 }"
                                   aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                        </c:otherwise>
                    </c:choose>
                    <c:choose>
                        <c:when test="${ sessionScope.currentPage == sessionScope.countPage }">
                            <li class="page-item disabled">
                                <a class="page-link" href="impl?currentPage=${ sessionScope.currentPage + 1 }"
                                   aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li class="page-item">
                                <a class="page-link" href="impl?currentPage=${ sessionScope.currentPage + 1 }"
                                   aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                        </c:otherwise>
                    </c:choose>
                    <li class="page-item"><a class="page-link"
                                             href="impl?currentPage=${ sessionScope.countPage }">尾页</a></li>
                </ul>
            </nav>
        </div>
    </div>
</div>
</body>
</html>
