<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <base href="<%=request.getScheme()%>://<%=request.getServerName()%>:<%=request.getServerPort()%><%=request.getContextPath()%>/"/>
    <link rel="stylesheet" href="bootstrap-3.2.0-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="bootstrap-3.2.0-dist/css/bootstrap-theme.min.css">
    <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="bootstrap-3.2.0-dist/js/bootstrap.min.js"></script>
    <title></title>
</head>
<body>
<ul class="nav nav-pills nav-stacked" role="tablist">
    <li role="presentation" class="active"><a href="#">Home</a></li>
    <li role="presentation"><a href="#">Profile</a></li>
    <li role="presentation"><a href="#">Messages</a></li>
    <li role="presentation" class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
            Dropdown<span class="caret"></span>
        </a>
        <ul class="dropdown-menu" role="menu">
            <li role="presentation"><a href="#">dropdown1</a></li>

            <li role="presentation" class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                    Dropdown<span class="caret"></span>
                </a>
                <ul class="dropdown-menu" role="menu">
                    <li role="presentation"><a href="#">dropdown1</a></li>
                    <li role="presentation"><a href="#">dropdown1</a></li>
                </ul>
            </li>

            <li role="presentation"><a href="#">dropdown1</a></li>
        </ul>
    </li>
    <li role="presentation"><a href="#">Message</a></li>
    <li role="presentation"><a href="#">Message</a></li>
    <li role="presentation"><a href="#">Message</a></li>
    <li role="presentation"><a href="#">Message</a></li>
</ul>
</body>
</html>