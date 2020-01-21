<?php
mb_internal_encoding("utf8");

//環境によって異なる。インターノウスの研修所内では、『 “root”, “mysql” 』で設定すること。
//※デフォルト（＝初期）設定では、『 “root”, “” 』でOK。
//host=   通常は、DB用のサーバー名を記述
//PDOは「PHP Data Objects」の略で、どのデータベースを使っているかを隠蔽してくれるものです。各種データベースへの接続を抽象化する。
$pdo = new PDO("mysql:dbname=r_itagaki;host=localhost;", "root", "mysql");
  
//※CRUDのうち、select文のみ『exec』でなく『query』を利用します
//次のような並びになる『’』『”』『.』 $_POST[‘箱の名前’]『.』『”』『’』
//シングルクオテーションの中には必ずダブルクオテーションを使う
$pdo->exec("insert into 4each_keijiban(handlename,title,comments)
values('".$_POST['handlename']."','".$_POST['title']."','".$_POST['comments']."');");
  
//  リダイレクト：”自動的”に他のwebページに移動すること。header関数にリンクしたいURLや相対パスを記述する。
//header("Location:http://localhost/4each_keijiban/index.php");
header("Location:http://localhost/r_itagaki/191115/4each_keijiban_191113/4each_keijiban/index.php");
?>