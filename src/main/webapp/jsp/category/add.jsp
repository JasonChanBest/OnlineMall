<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<div style="width: 80%;max-width: 600px;margin: 0 auto 0 auto;">
    <form action="admin/category/add.do" method="post" role="form" ajax="#mainDiv">
        <div class="form-group">
            <label>商品分类名称</label>
            <input type="text" name="name" class="form-control" placeholder="请输入商品分类名称"/>
        </div>
        <div class="form-group">
            <label>上级分类</label>
            <select name="parent.id" class="form-control">
                <option value="0">无</option>
                <c:forEach items="${categories}" var="category">
                    <option value="${category.id}">${category.name}</option>
                </c:forEach>
            </select>
        </div>
        <input type="submit" class="btn btn-default" value="确定"/>
    </form>
</div>