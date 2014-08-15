<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="<%=request.getScheme()%>://<%=request.getServerName()%>:<%=request.getServerPort()%><%=request.getContextPath()%>/"/>
    <link rel="stylesheet" href="thirdpart/bootstrap-3.2.0-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="thirdpart/bootstrap-3.2.0-dist/css/bootstrap-theme.min.css">
    <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="thirdpart/bootstrap-3.2.0-dist/js/bootstrap.min.js"></script>

    <script type="text/javascript" src="thirdpart/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" src="thirdpart/ueditor/ueditor.all.min.js"></script>
    <title></title>
</head>
<body>
    <div style="width: 80%;max-width: 1000px;margin: 0 auto 0 auto;">
        <form action="/admin/item/add.do" method="post" role="form">
            <div class="form-group">
                <label>商品名称：</label>
                <input class="form-control" type="text" value="${item.name}" name="name" placeholder="请输入商品名称"/>
            </div>
            <div class="form-group">
                <label>商品价格：</label>
                <input class="form-control" type="number" value="${item.price}" name="price" placeholder="请输入商品价格"/>
            </div>
            <div class="form-group">
                <label>商品分类：</label>
                <select class="form-control" name="category.id">
                    <c:forEach items="${categories}" var="category">
                        <option value="${category.id}">${category.name}</option>
                    </c:forEach>
                </select>
            </div>
            <script id="container" name="detail" type="text/plain"></script>
            <br/>
            <input class="btn btn-default" type="submit" value="确定"/>
        </form>
    </div>
    <script type="text/javascript">
        var editor = UE.getEditor('container');
    </script>
</body>
</html>