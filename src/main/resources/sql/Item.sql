create table item(
  id int auto_increment,
  name varchar(20),
  price float,
  detail longtext,
  category_id int,
  constraint pk_item_id primary key(id)
);