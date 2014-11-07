function Gallery() {
    var timer;
    var items;
    var count = 0;
}
Gallery.prototype.init=function(){
    var itemCount = $('.gallery .item').length;
    var itemWidth = $('.gallery .item').width();
    $('.gallery ul').css("width" , (itemCount * itemWidth) + 'px');
    this.items = $('.gallery');
};
Gallery.prototype.start= function () {
    this.timer = setInterval("gallery.start();" , 1000);
}
Gallery.prototype.slide= function () {
    var marginLeft = this.count%5*1000 + "px";
    this.items.css("margin-left" , marginLeft);
    this.count = this.count + 1;
}
var gallery = new Gallery();
$(function () {
    gallery.init();
    gallery.start();
});