#	testdb.sqlと同じ内容？
drop database if exists testdb_5;
create database testdb_5;
use testdb_5;

#	auto_increment（自動採番）
-- カラムに AUTO_INCREMENT をつけると、
-- データを追加した時にカラムに値が指定されなかった場合、カラムに対して
-- 現在格納されている最大の数値に 1 を追加した数値をMySQLが自動で格納する
-- データ型は整数。
-- 値は1ずつ増加して連番になる。
-- カラムに連続した数値を自動で格納したい場合に便利

create table users(
user_id int primary key auto_increment,
user_name varchar(255),
password varchar(255)
);

insert into users values(1,"taro","123");
insert into users values(2,"jiro","456");
insert into users values(3,"hanako","789");

create table inquiry(
name varchar(255),
qtype varchar(255),
body varchar(255)
);
