<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div style="width: 80%;max-width: 1000px;margin: 0 auto 0 auto;">
    <form action="admin/item/add.do" method="post" role="form">
        <div class="form-group">
            <label>商品名称：</label><sp:errors path="item.name"></sp:errors>
            <input class="form-control" type="text" value="${item.name}" name="name" placeholder="请输入商品名称"/>
        </div>
        <div class="form-group">
            <label>商品价格：</label><sp:errors path="item.price"></sp:errors>
            <input class="form-control" type="number" value="${item.price}" name="price" placeholder="请输入商品价格"/>
        </div>
        <div class="form-group">
            <label>商品分类：</label>
            <select class="form-control" name="categoryId">
                <c:forEach items="${categories}" var="category">
                    <option value="${category.id}" <c:if test="${item.category.id==categoryId}">selected="selected"</c:if>>${category.name}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group" id="addPicture">
            <button onclick="fileInput()" type="button" class="btn btn-info">添加图片</button>
        </div>
        <div class="form-group">
            <label>商品详情：</label>
            <script id="container" name="detail" type="text/plain"></script>
        </div>
        <div class="form-group">
            <input class="btn btn-default" type="submit" value="确定"/>
        </div>
    </form>
</div>

<link rel="stylesheet" href="thirdpart/bootstrap-fileinput/css/fileinput.min.css">
<script type="text/javascript" src="thirdpart/bootstrap-fileinput/js/fileinput.min.js"></script>
<script type="text/javascript" src="thirdpart/ueditor/ueditor.config.js"></script>
<script type="text/javascript" src="thirdpart/ueditor/ueditor.all.min.js"></script>
<script type="text/javascript">
    var progressTemplate=$('' +
            '<div class="progress">' +
            '   <div class="progress-bar progress-bar-striped active"  role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width: 0%">' +
            '   </div>' +
            '</div>' +
            '');
    var formGroupTemplate=$('' +
            '<div class="form-group">' +
            '</div>' +
            '');
    var inputTemplate=$('' +
            '<input type="file" name="files[]" multiple>' +
            '');
    function beforeFormGroup(sibling){
        var formGroup=formGroupTemplate.clone();
        sibling.before(formGroup);
        return formGroup;
    }
    function appendInput(parent) {
        var input=inputTemplate.clone();
        parent.append(input);
        return input;
    }
    function beforeProgress(sibling){
        var progress=progressTemplate.clone();
        sibling.before(progress);
        return progress;
    }
    function appendHidden(parent,value) {
        var hidden=$('<input type="hidden" name="pictureNames">');
        hidden.val(value);
        parent.append(hidden);
    }
    function removeHidden (parent) {
        parent.find('input:hidden').remove();
    }
    function fileInput() {
        var formGroup=beforeFormGroup($('div#addPicture'));
        var input=appendInput(formGroup);
        input.fileinput({
            uploadLabel:"上传",
            browseLabel:"选择文件"
        });
        input.on("fileclear",function () {
            removeHidden(formGroup);
            formGroup.find('div.progress').hide();
        });
        input.on("fileloaded", function () {
            removeHidden(formGroup);
        })
        var uploadButton=formGroup.find('button.kv-fileinput-upload');
        uploadButton.attr("type","button");
        uploadButton.click(function(){
            var self=$(this);
            var file=self.siblings("div.btn-file").children(":file").clone();
            var fileName=file.val();
            if(fileName==''||fileName==NaN||fileName==undefined){
                alert("要先选择了文件才能上传");
                return;
            }
            var form=$("<form></form>").attr("action","admin/picture/upload.do").attr("enctype","multipart/form-data").attr("method","post").append(file);
            form.ajaxSubmit({
                dataType:"json",
                success: function (data) {
                    var formGroup=self.parents('div.form-group');
                    var value=data.fileName;
                    appendHidden(formGroup , value);
                    var progressBar=formGroup.find("div.progress-bar");
                    progressBar.text('上传完成');
                },
                uploadProgress: function (event, position, total, percentComplete) {
                    var progress=formGroup.find('div.progress');
                    progress.show();
                    var progressBar=progress.find("div.progress-bar");
                    progressBar.attr("style","width:"+percentComplete+"%");
                    progressBar.text(percentComplete + '%');
                },
                error: function () {
                }
            });
        });
        var progress=beforeProgress(formGroup.find('div.input-group'));
        progress.hide();
    }
    $(function(){
        console.log('ok');
        var editor = UE.getEditor('container');
        fileInput();
    });
</script>