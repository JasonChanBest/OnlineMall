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
            event.data.gallery.count=parseInt($(this).attr('index'));
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
        this.count = this.count + 1;
        console.log(this.count);
    }
}
var gallery = new Gallery();
$(function () {
    gallery.init();
    gallery.start();
});