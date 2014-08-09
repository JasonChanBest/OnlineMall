<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="sp" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title></title>
    <base href="<%=request.getScheme()%>://<%=request.getServerName()%>:<%=request.getServerPort()%><%=request.getContextPath()%>/"/>
</head>
<body>
<div>
    <form action="user/regist.do" method="post">
        <table>
            <tr>
                <td>登陆名：</td>
                <td>
                    <input type="text" placeholder="请输入登陆名" name="user.loginName"/>
                </td>
                <td>
                    <sp:errors path="user.loginName"/>
                </td>
            </tr>
            <tr>
                <td>密码：</td>
                <td>
                    <input type="text" placeholder="请输入密码" name="user.loginPwd"/>
                </td>
                <td>
                    <sp:errors path="user.loginPwd"/>
                </td>
            </tr>
            <tr>
                <td>确认密码：</td>
                <td>
                    <input type="text" placeholder="请输入确认密码" name="confirmPwd"/>
                </td>
                <td>
                    <c:out value="${confirmPwdErr}"/>
                </td>
            </tr>
            <tr>
                <td colspan="3"><input type="submit" value="确定"/></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
