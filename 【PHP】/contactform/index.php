<!DOCTYPE html>
<html lang="ja">

<head>
  <meta charset="utf-8" />
  <!-- 
『http://localhost/contactform/index.html』を入力して、作成したページへアクセス。
localhostは自分のパソコンという意味。contactformは作成したフォルダー名。index.htmlは最初に表示するファイル名。
      -->
  <title>問い合わせ画面</title>

  <link rel="stylesheet" href="問い合わせ関連.css">
  <link rel="stylesheet" href="問い合わせ入力画面.css">
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
  <!-- <?php echo $_POST['mail']; ?>-->
  <div class="all">
    <h1>問合わせフォームの管理者送信</h1>
    <main>
      <h2>お問合わせフォーム</h2>
      <div class="form_wrapper">
        <!-- action：フォームの入力内容をどこに送るか、送信先のページを指定。 -->
        <!-- method：フォーム送信の通信方式(get/post)を指定。 -->
        <form action="mail_confirm.php" method="post">
          <!-- 一行入力欄 -->
          <p>
            <label>名前<br>
              <input type="text" class="line1" name="name" value="<?php echo $_POST['name']; ?>" placeholder="test2">
            </label>
          </p>
          <p>
            <label>メールアドレス<br>
              <input type="text" class="line1" name="mail" value="<?php echo $_POST['mail']; ?>" placeholder="test">
            </label>
          </p>

          <!-- セレクトボックス -->
          <p>
            <lavel>年齢<br>
              <select name="age" value="<?php echo $_POST['age']; ?>">
                <option>選択してください</option>
<!--                attr = i == '<?php $_POST['age']; ?>' ? ' selected' : '';-->
                <script>
                  //              SlectAge();
                  for (var i = 18; i <= 65; i++) {
                    //                  document.write("<option value='i'>");
                    //                  document.write(i);
                    //                  document.write("</option>");
                    document.write("<option value=" + i + ">" + i + "歳</option>");
                  }

                </script>
              </select>
            </lavel>
          </p>
          <!-- 複数行のテキスト入力欄 -->
          <p>
            <lavel>コメント<br>
              <!-- <textarea class="textarea" name="message" rows="8" cols="35" placeholder=""></textarea> -->
              <textarea class="textarea" name="comments" rows="8" cols="60" value="<?php echo $_POST['comments']; ?>" placeholder=""><?php echo $_POST['comments']; ?></textarea>
            </lavel>
          </p>
          <p><input type="submit" class="button" value="送信する"></p>
        </form>
      </div>
    </main>
  </div>
  <!-- <script src="https://code.jquery.com/jquery-3.3.1.js"></script> -->
  <!-- <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>-->
  <!-- <script src="js/よく使パタン.js" async></script> -->
</body>

</html>
