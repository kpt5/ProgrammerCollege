drop database if exists testdb_sv;
create database testdb_sv;
use testdb_sv;

create table test_table_sv(
	user_id int,
	user_name varchar(255),
	password varchar(255)
);

insert into test_table_sv values(1,"taro","123");
insert into test_table_sv values(2,"jiro","456");
insert into test_table_sv values(3,"hanako","789");
