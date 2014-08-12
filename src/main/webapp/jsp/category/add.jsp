<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <base href="<%=request.getScheme()%>://<%=request.getServerName()%>:<%=request.getServerPort()%><%=request.getContextPath()%>/"/>
    <title></title>
</head>
<body>
    <div>
        <form action="admin/category/add.do" method="post">
            <table>
                <tr>
                    <td>名称：</td>
                    <td>
                        <input type="text" name="name"/>
                    </td>
                </tr>
                <tr>
                    <td>上级分类：</td>
                    <td>
                        <select name="parentId">
                            <option value="0">无</option>
                            <c:forEach items="${categories}" var="category">
                                <option value="${category.id}">${category.name}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="确定"/>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>