$(function(){
    $('.header .treeMenu .grandparent-item').hover(
        function(){
            $(this).next('.parents').toggle();
        },
        function(){
            $(this).next('.parents').toggle();
        }
    );
});