function Gallery() {
}
Gallery.prototype={
    init:function(){
        this.count = 0;
        var itemCount = $('.gallery .item').length;
        var itemWidth = $('.gallery .item').width();
        this.items = $('.gallery .items');
        this.items.css("width" , (itemCount * itemWidth) + 'px');
        this.number=$('.gallery .number');
        this.number.mouseenter({'gallery':this} , function (event) {
            event.data.gallery.stop();
            event.data.gallery.count=event.data.gallery.number.length - event.data.gallery.number.index(this) - 1;
            event.data.gallery.slide();
        });
        this.number.mouseleave({'gallery':this} , function (event) {
            event.data.gallery.start();
        });
    },
    start:function () {
        this.timer = setInterval("gallery.slide();" , 1000);
    },
    stop: function () {
      clearInterval(this.timer);
    },
    slide:function () {
        var marginLeft = "-" + this.count%5*1000 + "px";
        this.items.css("margin-left" , marginLeft);
        var index = (this.number.length - 1) - (this.count % this.number.length);
        this.number.removeClass('bg-grey');
        $(this.number[index]).addClass('bg-grey');
        this.count = this.count + 1;
    }
}
var gallery = new Gallery();
$(function () {
    gallery.init();
    gallery.start();
});