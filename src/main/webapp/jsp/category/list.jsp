<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <base href="<%=request.getScheme()%>://<%=request.getServerName()%>:<%=request.getServerPort()%><%=request.getContextPath()%>/"/>
    <title></title>
</head>
<body>
    <div>
        ${categoryErr}
    </div>
    <div>
        <table>
            <tr>
                <th>名称</th>
                <th>上级名称</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${categories}" var="category">
                <tr>
                    <td>
                            ${category.name}
                    </td>
                    <td>
                            ${category.parent.name}
                    </td>
                    <td>
                        <a href="admin/category/editInit.do?id=${category.id}">编辑</a>
                        <a href="admin/category/delete.do?id=${category.id}">删除</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>