<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <base href="<%=request.getScheme()%>://<%=request.getServerName()%>:<%=request.getServerPort()%><%=request.getContextPath()%>/"/>
    <link rel="stylesheet" href="thirdpart/bootstrap-3.2.0-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="thirdpart/bootstrap-3.2.0-dist/css/bootstrap-theme.min.css">
    <script type="text/javascript" src="thirdpart/jquery/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="thirdpart/bootstrap-3.2.0-dist/js/bootstrap.min.js"></script>
    <title></title>
</head>
<body>
    <div>
        ${categoryErr}
    </div>
    <div>
        <table class="table table-striped table-bordered table-hover table-condensed">
            <thead>
            <tr>
                <th>名称</th>
                <th>上级名称</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${categories}" var="category">
                <tr>
                    <td>
                            ${category.name}
                    </td>
                    <td>
                            ${category.parent.name}
                    </td>
                    <td>
                        <a href="admin/category/editInit.do?id=${category.id}" class="btn btn-info btn-xs">编辑</a>
                        <a href="admin/category/delete.do?id=${category.id}" class="btn btn-danger btn-xs">删除</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>