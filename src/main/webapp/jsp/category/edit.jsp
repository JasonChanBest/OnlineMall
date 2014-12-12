<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div style="width: 80%;max-width: 600px;margin: 0 auto 0 auto;">
    <form action="admin/category/edit.do" method="post" role="form" ajax="#mainDiv">
        <input type="hidden" name="id" value="${category.id}"/>
        <div class="form-group">
            <label>商品分类名称：</label>
            <input class="form-control" type="text" placeholder="请输入商品分类名称" value="${category.name}" name="name"/>
        </div>
        <div class="form-group">
            <label>上级分类：</label>
            <select class="form-control" name="parent.id">
                <option value="0">无</option>
                <c:forEach items="${categories}" var="_category">
                    <c:if test="${_category.id != category.id && _category.parent.id != category.id}">
                    </c:if>
                    <option value="${_category.id}" <c:if test="${_category.id == category.parent.id}">selected="selected"</c:if>>
                            ${_category.name}
                    </option>
                </c:forEach>
            </select>
        </div>
        <input type="submit" class="btn btn-default" value="确定"/>
    </form>
</div>