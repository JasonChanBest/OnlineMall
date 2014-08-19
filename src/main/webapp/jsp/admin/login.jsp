<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags/form" %>
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
    <div style="width: 60%;max-width: 400px;margin: 0 auto 0 auto;">
        <form action="admin/login.do" method="post" role="form">
            <div class="form-group">
                <label>登陆名：</label><sp:errors path="admin.loginName" cssStyle="color: red"/>
                <input class="form-control" type="text" name="loginName" placeholder="请输入登陆名" value="${admin.loginName}"/>
            </div>
            <div class="form-group">
                <label>登陆密码：</label><sp:errors path="admin.loginPwd" cssStyle="color: red"/>
                <input class="form-control" type="password" name="loginPwd" placeholder="请输入登陆密码"/>
            </div>
            <input type="submit" class="btn btn-default" value="确定"/>
        </form>
    </div>
</body>
</html>