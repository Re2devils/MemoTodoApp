<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">

<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="css/common/common.css" />
    <link rel="preconnect" href="https://fonts.gstatic.com" />
    <link rel="stylesheet" href="css/index/index.css" />
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet" />
    <script src="https://kit.fontawesome.com/98ca2fa25d.js" crossorigin="anonymous"></script>
    <title>Welcome to MEMOandTODO</title>
</head>

<body>
    <!-- mobile first -->
    <div class="wrapper">
        <div class="logo">
            <img src="images/logo.png" alt="logo" width="360" height="140" />
        </div>
        <div class="content">
            <h1 style="background-color: #fff200; font-size: 8vw;">メモからタスクリストへ</h1>
            <div class="text">
                <p>あなたのメモとやる事リストを管理しましょう</p>
                <p>
                    <span class="highlight">効率的に</span>
                    仕事できるようになりたい方は
                </p>
                <p>
                    <span class="highlight">ログイン</span>
                    いただきましてご利用ください
                </p>
                <p>
                    アカウントを持っていない方
                    <span class="highlight">新規を登録</span>
                    してください
                </p>
            </div>
            <div class="btn-container">
                <a href="login" class="btn login">ログイン</a>
                <a href="signup" class="btn signin">登録</a>
            </div>
            <div class="simulation">
                <h3>タスクリスト</h3>
                <div class="simulation-container">
                    <div class="cell">
                        <div class="circle"><i class="fas fa-check"></i></div>
                        <div class="rectangle"></div>
                    </div>
                    <div class="cell">
                        <div class="circle"><i class="fas fa-caret-up"></i></div>
                        <div class="rectangle"></div>
                    </div>
                    <div class="cell">
                        <div class="circle"><i class="fas fa-check"></i></div>
                        <div class="rectangle"></div>
                    </div>
                    <div class="cell">
                        <div class="circle"><i class="fas fa-check"></i></div>
                        <div class="rectangle"></div>
                    </div>
                    <div class="cell">
                        <div class="circle"><i class="fas fa-times"></i></div>
                        <div class="rectangle"></div>
                    </div>
                </div>
            </div>
        </div>

        <object class="footer" data="footer"></object>
    </div>
</body>

</html>