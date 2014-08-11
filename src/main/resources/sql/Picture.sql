create table Picture(
  id int auto_increment,
  small_path varchar(200),
  big_path varchar(200),
  item_id int,
  constraint pk_picture_id primary key(id)
);