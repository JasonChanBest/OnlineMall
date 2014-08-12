<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="<%=request.getScheme()%>://<%=request.getServerName()%>:<%=request.getServerPort()%><%=request.getContextPath()%>/"/>
    <title></title>
</head>
<body>
    <div>
        <form action="/admin/category/edit.do">
            <input type="hidden" value="${category.id}"/>
            <table>
                <tr>
                    <td>分类名称：</td>
                    <td>
                        <input type="text" value="${category.name}" name="name"/>
                    </td>
                </tr>
                <tr>
                    <td>上级分类：</td>
                    <td>
                        <select name="parent.id">
                            <option value="0">无</option>
                            <c:forEach items="${categories}" var="_category">
                                <option value="${_category.id}" <c:if test="${_category.id == category.parent.id}">selected="selected"</c:if>>
                                        ${_category.name}
                                </option>
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
