<!--
SQL文を記述
 PDO(ピー・ディ・オー）と言う
ライブラリ（ツール）を使用して行う
1 DB接続をして
2 insert文で情報を格納する
-->

<?php

mb_internal_encoding("utf8");

//環境によって異なる。インターノウスの研修所内では、『 “root”, “mysql” 』で設定すること。
//※デフォルト（＝初期）設定では、『 “root”, “” 』でOK。
//host=   通常は、DB用のサーバー名を記述
$pdo = new PDO("mysql:dbname=r_itagaki;host=localhost;", "root", "mysql");

//※CRUDのうち、select文のみ『exec』でなく『query』を利用します
//次のような並びになる『’』『”』『.』 $_POST[‘箱の名前’]『.』『”』『’』
//シングルクオテーションの中には必ずダブルクオテーションを使う
$pdo->exec("insert into contactform(name,mail,age,comments)
values('".$_POST['name']."','".$_POST['mail']."','".$_POST['age']."','".$_POST['comments']."');");

?>
<!DOCTYPE html>
<html lang="ja">

<head>
  <meta charset="utf-8">
  <title>お問合わせフォームを作る</title>
  <link rel="stylesheet" href="問い合わせ関連.css">
</head>

<body>
  <div class="all">
    <h1>問合わせフォームの管理者送信</h1>
    <main>
      <h2>お問合わせフォーム</h2>
      <div class="form_wrapper">
        <p>
          お問い合わせ有難うございました。<br>
          3営業日以内に担当者よりご連絡差し上げます。
        </p>
      </div>
    </main>
  </div>
</body>
</html>
