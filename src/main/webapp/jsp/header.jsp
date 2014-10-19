<%--
  Author: Jayson
  Date: 2014-10-19 12:50
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="top">
    <div class="content">
        <ul>
            <li><a href="#">[请登陆]</a></li>
            <li><a href="#">[免费注册]</a></li>
            <li>|</li>
            <li><a href="#">我的订单</a></li>
        </ul>
    </div>
</div>
<div id="header">
    <div class="content">
        <div class="logo">
            <img src="http://misc.360buyimg.com/lib/img/e/logo-201305.png"/>
        </div>
        <div class="search">
            <div>
                <input type="text"/>
                <input type="submit" value="搜索"/>
            </div>
        </div>
        <div class="cart">
            <a href="#">购物车</a>
        </div>
    </div>
    <div class="banner">
        <ul>
            <li>
                <a href="#">全部商品分类</a>
            </li>
            <li>
                <a href="#">首页</a>
            </li>
            <li>
                <a href="#">服装城</a>
            </li>
            <li>
                <a href="#">食品</a>
            </li>
        </ul>
    </div>
</div>
<style type="text/css">
    #top *, #header * {
        padding: 0;
        margin: 0;
        color: #666666;
    }
    #top a:link {
        text-decoration: none;
    }

    #top a:hover {
        color: red;
        text-decoration: underline;
    }

    #top {
        height: 30px;
        width: 100%;
        background: #F7F7F7;
        border: solid 1px #EEEEEE;
        margin-bottom: 10px;
    }

    #top .content {
        margin: 0 auto;
        width: 1200;
        height: 100%;
    }

    #top .content ul {
        list-style: none;
        float: right;
    }

    #top ul li {
        float: left;
        font: 500 13px/30px "microsoft yahei";
        margin: auto 5px;
    }
    #header {
        height: 115px;
        margin: 0 auto;
        width: 1200px;
    }

    #header .content{
        height: 70px;
    }

    #header .logo{
        float: left;
    }

    #header .search{
        float: left;
        margin: 10px 15px auto 15px;
        width: 500px;
        border: 3px #E4393C solid;
    }
    #header .search input{
        border: none;
    }
    #header .search input[type=text]{
        margin: 5px;
        width: 400px;
        font: normal 15px/18px "microsoft yahei";
    }
    #header .search input[type=submit]{
        background: #E4393C;
        float: right;
        margin: 0;
        padding: 0;
        width: 80px;
        font: bold 15px/28px "microsoft yahei";
        color: #ffffff;
        cursor: pointer;
    }
    
    #header .cart{
        float: left;
    }

    #header .banner{
        height: 40px;
    }
    #header .banner ul{
        float: left;
        list-style: none;
        width: 100%;
        background: #E4393C;
    }
    #header .banner li{
        float: left;
        color: #ffffff;
        width: 85px;
    }
    #header .banner li:first-child{
        width: 200px;
    }
    #header .banner li:first-child a:hover{
        text-decoration: underline;
        background: #E4393C;
    }
    #header .banner a{
        text-decoration: none;
        color: #ffffff;
        display: block;
        text-align: center;
        font: 700 15px/40px "microsoft yahei";
    }
    #header .banner a:hover{
        background: #A40000;
    }
</style>