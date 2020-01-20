#	クライアントからサーバーへの SQL ステートメントの送信に使用される文字セットを示します。
#	SQLインジェクションにつながる可能性があるため、MySQLへの接続時SET NAMESは使わないほうがいい。
#	変わりに、5.2.3以降で追加されたAPIである mysql_set_charset() が推奨されてます。
set names utf8;

#	外部キー制約を無視する命令（mysqlコマンドから抜けるたびに命令が無効になります。）
#	外部キー制約のあるテーブルが存在すると、データを削除できないため設定する必要がある。
set foreign_key_checks = 0;

#	DBConnectorクラスで設定したデータベース名と合わせます
drop database if exists logindb_itagaki;
create database logindb_itagaki;
use logindb_itagaki;

create table user(
id int,
user_name varchar(255),
password varchar(255)
);

insert into user values
(1,"taro","123"),
(2,"jiro","123"),
(3,"hanako","123"),
(4,"saburo","123");
