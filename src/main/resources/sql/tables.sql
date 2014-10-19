create table admin(
  id int auto_increment ,
  login_name varchar(20),
  login_pwd varchar(50),
  constraint pk_user_id primary key (id)
);

create table user(
  id int auto_increment,
  login_name varchar(20),
  login_pwd varchar(50),
  constraint pk_user_id primary key (id)
);

create table cart(
  id int auto_increment,
  user_id int,
  constraint pk_cart_id primary key (id)
);

create table cart_item (
  cart_id int,
  item_id int
);

create table Category(
  id int auto_increment,
  name varchar(20),
  parent_id int,
  constraint pk_category_id primary key(id)
);

create table item(
  id int auto_increment,
  name varchar(20),
  price float,
  detail longtext,
  category_id int,
  constraint pk_item_id primary key(id)
);

create table Picture(
  id int auto_increment,
  path varchar(200),
  item_id int,
  constraint pk_picture_id primary key(id)
);

