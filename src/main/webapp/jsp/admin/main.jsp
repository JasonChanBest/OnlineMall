<%@include file="/jsp/common.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <base href="<%=base%>/"/>
    <link rel="stylesheet" href="css/main.css">
    <link rel="stylesheet" href="thirdpart/bootstrap-3.2.0-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="thirdpart/bootstrap-3.2.0-dist/css/bootstrap-theme.min.css">
    <script type="text/javascript" src="thirdpart/jquery/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="thirdpart/bootstrap-3.2.0-dist/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/common.js"></script>
    <script type="text/javascript" src="thirdpart/jquery.form/jquery.form.min.js"></script>
    <title>Online Mall管理系统</title>
</head>
<body>
<!--导航begin-->
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="admin/main.do">主页</a>
        </div>

        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">商品分类<span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="admin/category/list.do" ajax="#mainDiv">商品分类列表</a></li>
                        <li class="divider"></li>
                        <li><a href="admin/category/addInit.do" ajax="#mainDiv">添加商品分类</a></li>
                    </ul>
                </li>

                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">商品<span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="admin/item/list.do" ajax="#mainDiv">商品列表</a></li>
                        <li class="divider"></li>
                        <li><a href="admin/item/addInit.do" ajax="#mainDiv">添加商品</a></li>
                    </ul>
                </li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">管理员<span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="#" target="mainFrame">更改密码</a></li>
                        <li><a href="admin/logout.do">退出</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>
<!--导航end-->

<div class="container-fluid" id="mainDiv"></div>

<script type="text/javascript">
    $('#mainDiv').load('admin/welcome.do');
</script>
</body>
</html>