function Gallery() {
}
Gallery.prototype={
    init:function(){
        var itemCount = $('.gallery .item').length;
        var itemWidth = $('.gallery .item').width();
        this.items = $('.gallery .items');
        this.number=$('.gallery .number');
        this.items.css("width" , (itemCount * itemWidth) + 'px');
        this.count = this.number.length;
        this.index = this.count - 1;
        this.number.mouseenter({'gallery':this} , function (event) {
            event.data.gallery.stop();
            event.data.gallery.index=event.data.gallery.number.index(this);
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
        console.log(this.index);
        var marginLeft = "-" + (this.count - this.index - 1) * 1000 + "px";
        this.items.css("margin-left" , marginLeft);
        this.number.removeClass('bg-grey');
        $(this.number[this.index]).addClass('bg-grey');
        this.index = (this.index - 1) % this.count;
    }
}
var gallery = new Gallery();
$(function () {
    gallery.init();
    gallery.start();
});