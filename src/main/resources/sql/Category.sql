create table Category(
  id int auto_increment,
  name varchar(20),
  parent_id int,
  constraint pk_category_id primary key(id)
);