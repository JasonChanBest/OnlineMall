<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="<%=request.getScheme()%>://<%=request.getServerName()%>:<%=request.getServerPort()%><%=request.getContextPath()%>/"/>
    <link rel="stylesheet" href="thirdpart/bootstrap-3.2.0-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="thirdpart/bootstrap-3.2.0-dist/css/bootstrap-theme.min.css">
    <script type="text/javascript" src="thirdpart/jquery/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="thirdpart/bootstrap-3.2.0-dist/js/bootstrap.min.js"></script>
    <title></title>
</head>
<body>
    <div style="width: 80%;max-width: 600px;margin: 0 auto 0 auto;">
        <form action="/admin/category/edit.do" method="post" role="form">
            <input type="hidden" value="${category.id}"/>
            <div class="form-group">
                <label>商品分类名称：</label>
                <input class="form-control" type="text" placeholder="请输入商品分类名称" value="${category.name}" name="name"/>
            </div>
            <div class="form-group">
                <label>上级分类：</label>
                <select class="form-control" name="parent.id">
                    <option value="0">无</option>
                    <c:forEach items="${categories}" var="_category">
                        <option value="${_category.id}" <c:if test="${_category.id == category.parent.id}">selected="selected"</c:if>>
                                ${_category.name}
                        </option>
                    </c:forEach>
                </select>
            </div>
            <input type="submit" class="btn btn-default" value="确定"/>
        </form>
    </div>
</body>
</html>
