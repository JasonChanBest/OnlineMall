$(function () {
    initPage();
});

function initPage(container) {
    var a;
    var form;
    if(container){
        a = container.find('a[ajax]');
        form = container.find('form[ajax]');
    } else {
        a = $('a[ajax]');
        form = $('form[ajax]');
    }
    a.click(function () {
        var selector = $(this).attr('ajax');
        var url = $(this).attr('href');
        var container = $(selector);
        $.ajax({
            url:url,
            success: function (data) {
                container.html(data);
                initPage(container);
            }
        });
        return false;
    });
    form.submit(function () {
        var form = $(this);
        var selector = form.attr('ajax');
        var container = $(selector);
        form.ajaxSubmit({
            success: function (data) {
                container.html(data);
                initPage(container);
            }
        });
        return false;
    });
}