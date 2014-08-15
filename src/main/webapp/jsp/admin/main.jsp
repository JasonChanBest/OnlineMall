<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <base href="<%=request.getScheme()%>://<%=request.getServerName()%>:<%=request.getServerPort()%><%=request.getContextPath()%>/"/>
    <link rel="stylesheet" href="css/main.css">
    <link rel="stylesheet" href="thirdpart/bootstrap-3.2.0-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="thirdpart/bootstrap-3.2.0-dist/css/bootstrap-theme.min.css">
    <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="thirdpart/bootstrap-3.2.0-dist/js/bootstrap.min.js"></script>
    <title>Online Mall管理系统</title>
</head>
<body>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="admin/main.do">主页</a>
        </div>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">商品分类<span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="admin/category/list.do" target="mainFrame">商品分类列表</a></li>
                        <li class="divider"></li>
                        <li><a href="admin/category/addInit.do" target="mainFrame">添加商品分类</a></li>
                    </ul>
                </li>

                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">商品<span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="admin/item/list.do" target="mainFrame">商品列表</a></li>
                        <li class="divider"></li>
                        <li><a href="admin/item/addInit.do" target="mainFrame">添加商品</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>
<iframe name="mainFrame" src="admin/welcome.do">
</iframe>
</body>
</html>