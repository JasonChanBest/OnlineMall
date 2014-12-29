<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/jsp/common.jsp"%>

<div style="width: 80%;max-width: 1000px;margin: 0 auto 0 auto;">
    <form id="addPictureForm" action="<%=base%>/admin/picture/upload.do" method="post" enctype="multipart/form-data">
        <div class="panel panel-default">
            <div class="panel-body">
                <div class="form-group">
                    <input type="file" name="files">
                </div>
            </div>
        </div>

        <div class="progress hide">
            <div class="progress-bar progress-bar-striped active" role="progressbar" aria-valuenow="45" aria-valuemin="0" aria-valuemax="100" style="width: 45%">
                <span class="sr-only">45% Complete</span>
            </div>
        </div>

        <div class="form-group">
            <button id="addFileBtn" type="button" class="btn btn-info">添加图片</button>
            <button type="submit" class="btn btn-success">上传</button>
        </div>
    </form>

    <form id="addItemForm" action="admin/item/add.do" method="post" role="form" ajax="#mainDiv">
        <s:errors path="*"></s:errors>
        <div class="form-group">
            <label>商品名称：</label>
            <s:errors path="itemForm.name"></s:errors>
            <input class="form-control" type="text" value="${itemForm.name}" name="name" placeholder="请输入商品名称"/>
        </div>
        <div class="form-group">
            <label>商品价格：</label>
            <s:errors path="itemForm.price"></s:errors>
            <input class="form-control" type="number" value="${itemForm.price}" name="price" placeholder="请输入商品价格"/>
        </div>
        <div class="form-group">
            <label>商品分类：</label>
            <s:errors path="itemForm.categoryId"></s:errors>
            <select class="form-control" name="categoryId">
                <c:forEach items="${categories}" var="category">
                    <option value="${category.id}" <c:if test="${itemForm.categoryId==categoryId}">selected="selected"</c:if>>${category.name}</option>
                </c:forEach>
            </select>
        </div>

        <div class="form-group">
            <label>商品详情：</label>
            <s:errors path="itemForm.detail"></s:errors>
            <script id="container" name="detail" type="text/plain"></script>
        </div>
        <div class="form-group">
            <input class="btn btn-default" type="submit" value="确定"/>
        </div>
        <div id="hideDiv" class="hide">

        </div>
    </form>
</div>

<link rel="stylesheet" href="thirdpart/bootstrap-fileinput/css/fileinput.min.css">
<script type="text/javascript" src="thirdpart/bootstrap-fileinput/js/fileinput.min.js"></script>
<script type="text/javascript" src="thirdpart/ueditor/ueditor.config.js"></script>
<script type="text/javascript" src="thirdpart/ueditor/ueditor.all.min.js"></script>

<script type="text/javascript">
    var editor;
    $(function () {
        initFile();
        editor = UE.getEditor('container');
        $('#addFileBtn').click(addFile);
        $('#addPictureForm').submit(function () {
            submitFile();
            return false;
        });
        $('#addItemForm').submit(function () {
            var name = $('input[name="name"]').val();
            if(name == ''){
                alert('未输入商品名称');
                return false;
            }
            var price = $('input[name="price"]').val();
            if(price == ''){
                alert('未输入商品价格');
                return false;
            }
            var categoryId = $('select[name="categoryId"]').val();
            if(!categoryId){
                alert('未选择商品分类');
                return false;
            }
            var detail = editor.getContent();
            if(detail == ''){
                alert('未输入商品详情');
                return false;
            }
        });
    });
    function initFile(file) {
        if(!file){
            file = $(':file');
        }
        file.fileinput({
            showUpload:false,
            browseLabel:"选择文件",
            removeLabel:"删除"
        });
    }
    function addFile() {
        var form_group = $('<div class="form-group"><input type="file" name="files"></div>');
        $('.panel-body').append(form_group);
        var file = form_group.find(':file');
        initFile(file);
    }
    function submitFile() {
        var count = 0;
        $(':file').each(function (index, element) {
            if(element.value){
                count++;
            }
        });
        console.log(count);
        if(count < 1){
            alert('未选择图片文件');
            return;
        }
        var form = $('#addPictureForm');
        console.log(form.length);
        form.ajaxSubmit({
            dataType:'json',
            success: function (data) {
                if(data.fail.length > 0){
                    alert('上传失败！');
                } else {
                    alert('上传成功');
                    for(var i = 0 ; i < data.success.length ; ++i){
                        var input = $('<input name="pictures" type="hidden" value="'+data.success[i]+'">');
                        $('#hideDiv').append(input);
                    }
                }
            },
            error: function () {
                alert('连接服务器失败！');
            }
        });
    }
</script>