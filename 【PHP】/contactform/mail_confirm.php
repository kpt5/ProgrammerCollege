<!DOCTYPE html>
<html lang="ja">

<head>
  <meta charset="utf-8" />
  <title>入力内容確認画面</title>
  <!--  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">-->
  <link rel="stylesheet" href="問い合わせ関連.css">
  <link rel="stylesheet" href="入力内容確認画面.css">
  <!--
  <style>
    .class名 {
      プロパティ: 値;
    }

  </style>
-->
  <!--
  <script>
    const sample = (name) => console.log(name);

  </script>
-->
</head>

<body>
  <div class="all">
    <h1>問合わせフォームの管理者送信</h1>
    <main>
      <h2>お問合わせ内容確認</h2>
      <div class="form_wrapper">
        <p>
          お問い合わせ内容はこちらで宜しいでしょうか？<br>
          よろしければ「送信する」ボタンを押して下さい。
        </p>
        <p>
          名前<br>
          <?php echo $_POST['name']; ?>
        </p>
        <p>
          メールアドレス<br>
          <?php echo $_POST['mail']; ?>
        </p>
        <p>
          年齢<br>
          <?php echo $_POST['age']."歳"; ?>
        </p>
        <p>
          コメント<br>
          <?php echo $_POST['comments']; ?>
        </p>
        <!-- action=“○○○”は、リンク先のURL(ファイル名）のこと -->
        <form action="index.php" method="post">
          <p>
            <!-- value=“○○○”は、ボタン上に表示されるテキストのこと。 -->
            <input type="submit" class="button back" value="戻って修正する">
            <input type="hidden" value="<?php echo $_POST['name']; ?>" name="name">
            <input type="hidden" value="<?php echo $_POST['mail']; ?>" name="mail">
            <input type="hidden" value="<?php echo $_POST['age']; ?>" name="age">
            <input type="hidden" value="<?php echo $_POST['comments']; ?>" name="comments">
          </p>
        </form>
        <!--
『index.html』から引き渡されたpostをここで、再度箱の中に格納し、『insert.php』へ引き渡す。
type=“hidden”にすることで、代入した内容を隠す（web上に表示しない）ことが出来る。
        -->
        <form action="insert.php" method="post">
          <!-- registという英語は存在しなくてregisterが正解 -->
          <p>
            <input type="submit" class="button register" value="登録する">
          </p>
          <input type="hidden" value="<?php echo $_POST['name']; ?>" name="name">
          <input type="hidden" value="<?php echo $_POST['mail']; ?>" name="mail">
          <input type="hidden" value="<?php echo $_POST['age']; ?>" name="age">
          <input type="hidden" value="<?php echo $_POST['comments']; ?>" name="comments">
        </form>
      </div>
    </main>
  </div>
  <!-- <script src="https://code.jquery.com/jquery-3.3.1.js"></script> -->
  <!-- <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>-->
  <!-- <script src="js/よく使パタン.js" async></script> -->
</body>

</html>
