<%--
  Created by IntelliJ IDEA.
  User: Jayson
  Date: 2014/8/10
  Time: 22:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <base href="<%=request.getScheme()%>://<%=request.getServerName()%>:<%=request.getServerPort()%><%=request.getContextPath()%>/"/>
    <title></title>
</head>
<body>
    <div>
        <form action="admin/login.do" method="post">
            <table>
                <tr>
                    <td>
                        <input type="text" name="loginName" placeholder="请输入登陆名" value="${admin.loginName}"/>
                        <sp:errors path="admin.loginName"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="password" name="loginPwd" placeholder="请输入登陆密码"/>
                        <sp:errors path="admin.loginPwd"/>
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
