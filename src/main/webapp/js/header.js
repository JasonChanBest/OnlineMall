$(function(){
    $('.header .treeMenu .grandparent').hover(
        function(){
            $(this).find('.parents').toggle();
        },
        function(){
            $(this).find('.parents').toggle();
        }
    );
});