#	クライアントからサーバーへの SQL ステートメントの送信に使用される文字セットを示します。
#	SQLインジェクションにつながる可能性があるため、MySQLへの接続時SET NAMESは使わないほうがいい。
#	変わりに、5.2.3以降で追加されたAPIである mysql_set_charset() が推奨されてます。
set names utf8;

#	外部キー制約を無視する命令（mysqlコマンドから抜けるたびに命令が無効になります。）
#	外部キー制約のあるテーブルが存在すると、データを削除できないため設定する必要がある。
set foreign_key_checks = 0;

drop database if exists template;
create database if not exists template;
use template;

#	必要？
drop table if exists login_user_transaction;

#	auto_increment（自動採番）
# カラムに AUTO_INCREMENT をつけると、
# データを追加した時にカラムに値が指定されなかった場合、カラムに対して
# 現在格納されている最大の数値に 1 を追加した数値をMySQLが自動で格納する
# データ型は整数。
# 値は1ずつ増加して連番になる。
# カラムに連続した数値を自動で格納したい場合に便利
create table login_user_transaction(
id int not null primary key auto_increment,
login_id varchar(16) unique,
login_pass varchar(16),
user_name varchar(50),
insert_date datetime,
updated_date datetime
);

drop table if exists item_info_transaction;
create table item_info_transaction(
id int not null primary key auto_increment,
item_name varchar(30),
item_price int,
item_stock int,
insert_date datetime,
update_date datetime
);

drop table if exists user_buy_item_transaction;
create table user_buy_item_transaction(
id int not null primary key auto_increment,
item_transaction_id int,
total_price int,
total_count int,
user_master_id varchar(16),
pay varchar(30),
insert_date datetime,
delete_date datetime
);

INSERT INTO item_info_transaction(item_name, item_price, item_stock) VALUES("ノートBook", 100,
50);
INSERT INTO item_info_transaction(item_name, item_price, item_stock) VALUES("iPad", 200,
30);
INSERT INTO login_user_transaction(login_id, login_pass, user_name) VALUES("internous",
"internous01", "test");
INSERT INTO login_user_transaction(login_id, login_pass, user_name) VALUES("taro",
"123", "taro");

