<%--
  Author: Jayson
  Date: 2014-10-19 12:37
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";%>
<html>
<head>
    <title></title>
    <base href="<%=basePath%>">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div>
    this is index page
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
<style type="text/css">
    body{
        margin: 0;
        padding: 0;
    }
</style>
</html>

