http://localhost/phpmyadmin/index.php


CREATE TABLE address_list(
	user_id int(11),
    name varchar(255),
    mail varchar(255),
    tell varchar(255),
    prefecture varchar(255)
);

CREATE TABLE fruit_stock(
	id int(11),
    fruit varchar(255),
	number int(11),
	price int(11),
    madein varchar(255),
);

C:\xampp\phpMyAdmin\js\vendor\codemirror\lib


INSERT INTO `address_list`(`user_id`, `name`, `mail`, `tell`, `prefecture`) VALUES ([value-1],[value-2],[value-3],[value-4],[value-5])


insert into address_list(user_id, name, mail, tell, prefecture)
  values("1","山田太郎","abcd123@yahoo.co.jp","03-0000-0000","東京");
  

insert into address_list values
("2","佐藤花子","xyz777@yahoo.co.jp","073-0000-0000","神奈川"),
("3","田中浩史","hello888@yahoo.co.jp","045-0000-0000","静岡"),
("4","鈴木次郎","efg123@yahoo.co.jp","080-0000-0000","沖縄"),
("5","藤田三郎","cccc999@yahoo.co.jp","090-0000-0000","千葉");

insert into fruit_stock values
(1,"りんご",33,100,"日本"),
(2,"オレンジ",40,120,"日本"),
(3,"イチゴ",10,250,"日本"),
(4,"ぶどう",25,240,"アメリカ"),
(5,"ナシ",23,150,"日本"),
(6,"パイナップル",15,230,"フィリピン");



SELECT * FROM `address_list`;
SELECT * FROM `fruit_stock` order by number asc;
SELECT * FROM `fruit_stock` order by number desc;
SELECT count(fruit) FROM `fruit_stock`;
SELECT sum(number) FROM `fruit_stock`;
SELECT max(price) FROM `fruit_stock`;
SELECT min(price) FROM `fruit_stock`;
SELECT avg(price) FROM `fruit_stock`;
SELECT count(fruit) FROM `fruit_stock` WHERE price >= 200 and madein = "日本";
SELECT `mail` FROM `address_list` WHERE `prefecture` = '千葉';
SELECT name FROM `address_list` WHERE user_id = 3;
SELECT * FROM `fruit_stock` WHERE number >= 25 order by price desc;

SELECT `user_id`, `name`, `mail`, `tell`, `prefecture` FROM `address_list` WHERE 1


UPDATE `address_list` SET `user_id`=[value-1],`name`=[value-2],`mail`=[value-3],`tell`=[value-4],`prefecture`=[value-5] WHERE 1

UPDATE address_list SET prefecture = "埼玉" WHERE user_id = 1;


DELETE FROM `address_list` WHERE 0
DELETE FROM address_list WHERE user_id = 3;




mysql -u root t –p

create table item(
item_id int,
item_name varchar(255),
item_team enum('spring','summer','fall','winter'),
price decimal(9,2)
);

insert into item(item_id, item_name, item_team, price) values
(1, 'りんご', 'summer', 150),
(2, 'ぶどう', 'fall', 200),
(3, 'さつまいも', 'fall', 250),
(4, 'ネギ', 'winter', 190), 
(5, 'にんじん', 'spring', 50),
(6, 'トマト', 'summer', 100);


MariaDB [itagaki_r2]> select * from item;

select item_name from item;
select item_name, price from item;

update item set item_team="winter" where item_id=1;

update item set price = 500 where item_id=1;

delete from item where item_id =1;
delete from item;

drop table item;
drop database itagaki_r2;
create database itagaki_r3;
create table sample01(
  id int,
  name varchar(255),
  email varchar(255),
  class enum('no1','no2','no3')
);

 insert into sample01 values
  (1, '田中さん', 'tanaka@yahoo.co.jp','no1'),
  (2, '山田さん', 'yamada@gmail.com','no3'),
  (3, '木村さん', 'kimura@yahoo.co.jp', 'no2');
  
alter table sample01 rename sample02;
alter table sample02 change id Number int;
alter table sample02 change Number Number varchar(255);
alter table sample02 change email mailaddress varchar(255);
alter table sample02 modify class varchar(255);
alter table sample02 add age int;
alter table sample02 drop class;

XX
create table spot (
spot_id int not null,
latlon geometory not null,
primary key (point_id),
spatial key (latlon)
);

create table spot (
point_id int not null,
spot_id int not null,
latlon geometry not null,
primary key (point_id)
);

insert into spot (spot_id, latlon) values (1,GeomFromText('POINT(137.10 35.20)'));

select * from spot;
select * from user \G;
select * from user;
select * from user limit 2,2;
select * from user limit 1,2;
select * from user limit 0,2;


mysqldump -u root -p sample > sampledump.sql
mysqldump -u root -p sample < sampledump.sql




サーバ: 127.0.0.1
Run SQL query/queries on server “127.0.0.1”:
create database itagaki_r;
create database r_itagaki;


※テーブル名は、contactform。
※カラム名は、name、mail、age、commentsとする。
(データ型はageのみint、それ以外はvarcharとする)

CREATE TABLE contactform(
    name varchar(255),
    mail varchar(255),
    age int(11),
    comments varchar(255)
);

DESCRIBE contactform;


CREATE TABLE 4each_keijiban(
    handlename varchar(255),
    title varchar(255),
    comments varchar(255)
);

DESCRIBE 4each_keijiban;