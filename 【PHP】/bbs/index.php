<!DOCTYPE html>

<html lang="ja">

<head>
  <!-- IE8+に対して「IE=edge」と指定することで、利用できる最も互換性の高い最新のエンジンを使用するよう指示 -->
  <!-- IEの互換表示を強制的に標準モードにする -->
  <meta http-equiv="X-UA-Compatible" content="IE=edge">

  <!-- charsetの指定はheadタグの一番最初(titleなどの要素内容に日本語を含むかもしれない要素の出現よりも前)で行う -->
  <meta charset="utf-8">

  <!-- ページタイトル＝サイト名(～30文字程度) -->
  <title>4eachblog 掲示板</title>

  <!-- content属性にページの紹介文（80～120文字で多くても200文以内）を記述 -->
  <!-- 検索結果に出てきた際にリンクの下に書かれてあるサイトの概要部分になる -->
  <!-- タイトル同様に全ページで同じ記述にする-->
  <meta name="description" content="4eachblog 掲示板">

  <!-- content属性にページの著者情報を記述 -->
  <!-- SEO的には2015年時点で関係ないようなので、あってもなくても良い -->
  <meta name="author" content="板垣　遼">

  <!--  モバイル端末への対応。ページをビューポートの幅に合わせてコンテンツの幅を調整（Android, iOS6以降）-->
  <!--  ズームを許可しない設定「user-scalable=no」は加えない -->
  <!--  width=device-width：　端末に合った表示領域を幅を自動で設定。-->
  <!-- initial-scale=1：　初期のズーム倍率100％表示 -->
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <!-- content="yes"の場合、スマートフォンでアクセス時、ブラウザの枠をなくしアプリっぽい動作にする（フルスクリーンモード）（任意） -->
  <!-- <meta name="apple-mobile-web-app-capable" content="yes">-->

  <!-- スマートフォンサイト時、電話番号自動リンク停止（任意） -->
  <!--  <meta name="format-detection" content="telephone=no">-->

  <!-- スタイルシートの<link>タグを指定する場合には、rel属性とhref属性が必須。href属性にスタイルシートファイルのURIを記述。-->
  <link rel="stylesheet" href="./4eachblog_掲示板.css">

  <!-- bxSlider -->
  <!--
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
  <script src="【演習➁】4eachblog_板垣.js"></script>
-->
  <!--
  <script>
    $(document).ready(function() {
//      var windowWidth = jQuery(window).width();
      var windowWidth = jQuery('header').width();
//      var width = windowWidth / 3;
      var width = windowWidth;
      $('.slider').bxSlider({
        auto: true,
        //        mode: 'fade',
        //        横スライド方式
        mode: 'horizontal',
        speed: 2000,
        slideWidth: width,
      });
    });

  </script>
-->
  <!-- IE8以下用に2つのスクリプトを記述
    html5shiv.js: IE8以下にHTML5の要素を認識するようにさせる
    respond.js: IE8以下にMedia Queriesの代替え機能を提供 -->
  <!-- HTML5やレスポンシブをIE8以下に認識させる場合記述 -->
  <!-- 以下、コメントアウトのままにしておく -->
  <!--[if lt IE 9]>
  <script src="//cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.2/html5shiv.min.js"></script>
  <script src="//cdnjs.cloudflare.com/ajax/libs/respond.js/1.4.2/respond.min.js"></script>
  <![endif]-->

</head>

<body>
  <?php
    mb_internal_encoding("utf8");
//  ※デフォルト（＝初期）設定では、『 “root”, “” 』でOK。
    $pdo = new PDO("mysql:dbname=r_itagaki;host=localhost;", "root", "mysql");
    $stmt = $pdo->query("select * from 4each_keijiban");
//    while ($row = $stmt->fetch()) {
//     echo $row['handlename'];
//     echo $row['title'];
//     echo $row['comments'];
//    }
//    foreach ($stmt as $row) {
//     echo $row['handlename'];
//     echo $row['title'];
//     echo $row['comments'];
//    }
  ?>
  <!-- ★ロゴと上部ナビ -->
  <header class="top_head">
    <div class="container">
      <div class="top_logo">
        <!-- alt属性：画像の代わりに表示させる「代替テキスト」（必須） -->
        <img src="./img/4eachblog_logo.jpg" alt="4eachblog">
      </div>
      <!-- nav要素は主要なナビゲーションにのみ用いる。多くても３つくらい。リンク集は非nav -->
      <!-- navの中身はリスト要素であるべき -->
      <nav>
        <div class="header-menu">
          <!-- unordered list（順序無しリスト） -->
          <ul>
            <li><a href="#top">トップ</a></li>
            <li><a href="■URL■">プロフィール</a></li>
            <li><a href="■URL■">4eachについて</a></li>
            <li><a href="■URL■">登録フォーム</a></li>
            <li><a href="■URL■">問い合わせ</a></li>
            <li><a href="■URL■">その他</a></li>
          </ul>
        </div>
      </nav>
    </div>
  </header>
  <div class="top-wrapper" id="top">
    <div class="container">
      <!-- IE11がmainタグに対応していないため、role="main"のdivタグで代用 -->
      <div class="main" role="main">
        <!-- article：独立または自己完結しているコンテンツとその関連情報。 -->
        <!-- 複数可。入れ子可。必ず見出しをつける。 -->
        <section>
          <header id="slider_company">
            <h1>プログラミングに役立つ掲示板</h1>
          </header>
          <div class="form_wrapper">
            <h2 class="input_form_h2">入力フォーム</h2>
            <!-- action：フォームの入力内容をどこに送るか、送信先のページを指定。 -->
            <!-- method：フォーム送信の通信方式(get/post)を指定。 -->
            <form action="insert.php" method="post">
              <!-- 一行入力欄 -->
              <p>
                <label>ハンドルネーム<br>
                  <input type="text" class="line1" name="handlename" value="" placeholder="test2">
                </label>
              </p>
              <p>
                <label>タイトル<br>
                  <input type="text" class="line1" name="title" value="" placeholder="test">
                </label>
              </p>

              <!-- 複数行のテキスト入力欄 -->
              <p>
                <lavel>コメント<br>
                  <!-- <textarea class="textarea" name="message" rows="8" cols="35" placeholder=""></textarea> -->
                  <textarea class="textarea" name="comments" rows="8" cols="60" value="" placeholder=""></textarea>
                </lavel>
              </p>
              <p><input type="submit" class="button" value="投稿する"></p>
            </form>
          </div>
        </section>
        <?php
          while ($row = $stmt->fetch()) {
            echo "<article>";
            echo "<div class='form_wrapper'>";
            echo "<h2 class='article_h2'>".$row['title']."</h2>";
            echo "<p>".$row['comments']."</p>";
            echo "<p>posted by ".$row['handlename']."</p>";
//            echo "<p>".$row."</p>";
            echo "</div>";
            echo "</article>";
//            var_dump($row);
          }
        ?>
        <?php
//          foreach ($stmt as $row) {
//            echo "<article>";
//            echo "<div class='form_wrapper'>";
//            echo "<h2 class='article_h2'>".$row['title']."</h2>";
//            echo "<p>".$row['comments']."</p>";
//            echo "<p>posted by ".$row['handlename']."</p>";
//            echo "</div>";
//            echo "</article>";
//          }
        ?>
      </div>
      <!-- <aside>：蛇足コンテンツ。ex.サイドバー・広告・参考リンク・アイキャッチ画像・補足記事 -->
      <aside>
        <div class="side-bars">
          <!-- nav要素は主要なナビゲーションにのみ用いる。多くても３つくらい。リンク集は非nav -->
          <!-- navの中身はリスト要素であるべき -->
          <nav>
            <section>
              <div class="side_bar">
                <h3>人気の記事</h3>
                <ul>
                  <li><a href="■URL■">PHP オススメ本</a></li>
                  <li><a href="■URL■">PHP MyAdminの使い方</a></li>
                  <li><a href="■URL■">今人気のエディタ Top5</a></li>
                  <li><a href="■URL■">HTMLの基礎</a></li>
                </ul>
              </div>
            </section>
            <section>
              <div class="side_bar">
                <h3>オススメリンク</h3>
                <ul>
                  <li><a href="■URL■">インターノウス株式会社</a></li>
                  <li><a href="■URL■">XAMPPのダウンロード</a></li>
                  <li><a href="■URL■">Eclipseのダウンロード</a></li>
                  <li><a href="■URL■">Bracketsのダウンロード</a></li>
                </ul>
              </div>
            </section>
            <section>
              <div class="side_bar">
                <h3>カテゴリ</h3>
                <ul>
                  <li><a href="■URL■">HTML</a></li>
                  <li><a href="■URL■">PHP</a></li>
                  <li><a href="■URL■">MySQL</a></li>
                  <li><a href="■URL■">JavaScript</a></li>
                </ul>
              </div>
            </section>
          </nav>
        </div>
      </aside>
    </div>
  </div>
  <!-- <footer>：コンテンツの付帯情報・補足情報 -->
  <!-- ex.関連文書へのリンクや内部リンク、著作権（copyright）、サイトマップ -->
  <footer class="last_foot">
    <div class="container">
      <!-- ©  &copy;  著作権記号（Copyright sign） -->
      <small>copyright&copy;internous | 4each blog is the one which provides A to Z about programming</small>
    </div>
  </footer>
  <!--  <script src="【演習➁】4eachblog_板垣.js" async></script>-->
</body>

</html>
