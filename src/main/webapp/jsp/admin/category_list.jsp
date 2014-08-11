<%@ page import="com.mall.orm.category.Category" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Set" %>
<%--
  Created by IntelliJ IDEA.
  User: Jayson
  Date: 2014/8/11
  Time: 1:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title></title>
</head>
<body>
    <%!
       private void display(Category category){
           Set<Category> categories = category.getCategories();
           if(categories != null && !categories.isEmpty()){

           }else{

           }
       }
    %>
    <%
        List<Category> categories = (List<Category>) request.getAttribute("categories");
        if(categories != null && !categories.isEmpty()){
            for(Category category : categories){
                if(category.getCategory() == null){
                    display(category);
                }
            }
        }
    %>
</body>
</html>
