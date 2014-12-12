<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<div>
    <table class="table table-striped table-bordered table-hover table-condensed">
        <thead>
        <tr>
            <th>名称</th>
            <th>上级名称</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${categories}" var="category">
            <tr>
                <td>
                        ${category.name}
                </td>
                <td>
                        ${category.parent.name}
                </td>
                <td>
                    <a href="admin/category/editInit.do?id=${category.id}" class="btn btn-info btn-xs" ajax="#mainDiv">编辑</a>
                    <a href="admin/category/delete.do?id=${category.id}" class="btn btn-danger btn-xs" ajax="#mainDiv">删除</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>