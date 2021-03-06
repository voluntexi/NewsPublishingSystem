<%@ page import="java.util.*" contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>--西华大学新闻系统-- | </title>

    <!-- Bootstrap -->
    <link href="../vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="../vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="../vendors/nprogress/nprogress.css" rel="stylesheet">
    <!-- Animate.css -->
    <link href="https://colorlib.com/polygon/gentelella/css/animate.min.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="../build/css/custom.min.css" rel="stylesheet">
  </head>

  <body class="login">
    <div>
      <a class="hiddenanchor" id="signup"></a>
      <a class="hiddenanchor" id="signin"></a>

      <div class="login_wrapper">
        <div class="animate form login_form">
          <section class="login_content">
            <form method="post" action="/production/login">
              <h1>用户登录</h1>
              <div>
                <input type="text" name="userName" class="form-control" placeholder="请输入用户名" required="" />
              </div>
              <div>
                <input type="password" name="userPassword" class="form-control" placeholder="请输入密码" required="" />
              </div>
              <div>
                <button type="submit" class="btn btn-success" >登录</button>
             <%--   <a class="btn btn-default submit" href="index.jsp">登&nbsp;录</a>--%>
              </div>

              <div class="clearfix"></div>

              <div class="separator">

                </p>

                <div class="clearfix"></div>
                <br />

                <div>
                  <h1><i class="fa fa-paw"></i> 西华新闻发布系统!</h1>
                  <p>©2021 All Rights Reserved. Xihua University! </p>
                </div>
              </div>
            </form>
          </section>
        </div>
      </div>
    </div>
  </body>
</html>