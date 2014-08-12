<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="<%=request.getScheme()%>://<%=request.getServerName()%>:<%=request.getServerPort()%><%=request.getContextPath()%>/"/>
    <script type="text/javascript" src="ueditor/ueditor.config.js"></script>
    <script type="text/javascript" src="ueditor/ueditor.all.min.js"></script>
    <title></title>
</head>
<body>
    <div>
        <form action="/admin/item/add.do" method="post">
            <table>
                <tr>
                    <td>商品名称：</td>
                    <td>
                        <input type="text" value="${item.name}" name="name"/>
                    </td>
                </tr>
                <tr>
                    <td>商品价格：</td>
                    <td>
                        <input type="text" value="${item.price}" name="price"/>
                    </td>
                </tr>
                <tr>
                    <td>分类：</td>
                    <td>
                        <select name="category.id">
                            <c:forEach items="${categories}" var="category">
                                <option value="${category.id}">${category.name}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
            </table>
            <script id="container" name="detail" type="text/plain"></script>
            <input type="submit" value="确定"/>
        </form>
    </div>
    <script type="text/javascript">
        var editor = UE.getEditor('container');
    </script>
</body>
</html>