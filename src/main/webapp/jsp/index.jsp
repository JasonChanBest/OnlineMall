<%--
  Author: Jayson
  Date: 2014-10-19 12:37
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";%>
<html>
<head>
    <title>京东网上商城-综合网购首选（JD.COM）-正品低价、品质保障、货到付款、配送及时、放心服务、轻松购物！</title>
    <base href="<%=basePath%>">
    <script type="text/javascript" src="thirdpart/jquery/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="js/header.js"></script>
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

