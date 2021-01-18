<%--
  Created by IntelliJ IDEA.
  User: 14203
  Date: 2020/11/20
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>书籍展示</title>
    <!--导入bootstrap美化界面-->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css">
</head>


<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>书籍列表 ---------显示所有书籍</small>
                </h1>
            </div>
        </div>
            <div class="row">
                <div class="col-md-4 column">
                    <a href="${pageContext.request.contextPath}/book/toAddBook" class="btn btn-primary">新增书籍</a>
                </div>
                <div class="col-md-4 column">
                    <a href="${pageContext.request.contextPath}/book/allBook" class="btn btn-primary">所有书籍</a>
                </div>
                <div class="col-md-4 column">
                    <form action="${pageContext.request.contextPath}/book/findBookByName" method="post" class="form-inline" >
                        <span style="color:red;font-weight: bold">${err}</span>
                        <input type="text" name="queryBookName" class="form-control" placeholder="请输入要查询的书籍名称">
                        <input type="submit" value="查询">
                    </form>
                </div>
            </div>


    </div>

        <div class="row clearfix">
            <div class="col-md-12 column">
                <table class="table table-hover table-striped">
                    <thead>
                        <tr>
                            <th>书籍编号</th>
                            <th>书籍名称</th>
                            <th>书籍数量</th>
                            <th>书籍详情</th>
                            <th>操作</th>
                        </tr>
                    </thead>

                    <%--书籍从数据库中查询出来，从这个list中遍历出来：foreach--%>
                    <tbody>
                        <c:forEach items="${list}" var="book">
                            <tr>
                                <td>${book.bookID}</td>
                                <td>${book.bookName}</td>
                                <td>${book.bookCounts}</td>
                                <td>${book.detail}</td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/book/toupdate?id=${book.bookID}">修改</a>
                                    &nbsp;|&nbsp;
                                    <a href="${pageContext.request.contextPath}/book/deleteBook?id=${book.bookID}">删除</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>

</div>


</div>

</body>
</html>
