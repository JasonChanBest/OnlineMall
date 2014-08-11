<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title></title>
</head>
<body>
    <div>
        <table>
            <tr>
                <th>名称</th>
                <th>上级名称</th>
                <th>操作</th>
            </tr>
            <c:forEach items="categories" var="category">
                <tr>
                    <td>
                        ${category.name}
                    </td>
                    <td>
                        ${category.parent.name}
                    </td>
                    <td>
                        <a href="#">编辑</a>
                        <a href="#">删除</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>