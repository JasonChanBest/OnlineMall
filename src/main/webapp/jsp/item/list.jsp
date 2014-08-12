<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <div>
        <table>
            <tr>
                <th>商品名称</th>
                <th>价格</th>
                <th>分类</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${items}" var="item">
                <tr>
                    <td>${item.name}</td>
                    <td>${item.price}</td>
                    <td>${item.category.name}</td>
                    <td>
                        <a href="admin/item/editInit.do?id=${item.id}">编辑</a>
                        <a href="admin/item/delete.do?id=${item.id}">删除</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>